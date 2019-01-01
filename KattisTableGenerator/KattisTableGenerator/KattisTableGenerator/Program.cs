using System;
using System.Collections.Generic;
using System.IO;
using System.Net;
using System.Text;
using System.Text.RegularExpressions;

namespace KattisTableGenerator {
    public class Program {
        private static LogWriter log = new LogWriter ();

        public static void Main (string[] args) {
            log.StartTimer ();
            Dictionary<string, string> idToNameMap = new Dictionary<string, string> (2500);
            const string mapfile = @"KattisIDNameMapping.txt";
            if (!File.Exists (mapfile)) {
                log.WriteLine ("Recommendation: You should run KattisMapGenerator.dll to ensure fast speeds");
                File.Create (mapfile).Close ();
            }
            CustomReader sc = new CustomReader (mapfile);
            string line;
            while ((line = sc.NextLine ()) != null) {
                string id = line;
                string name = sc.NextLine ();
                if (name == null)
                    throw new EndOfStreamException ("Missing name for ID '" + id + "'. To fix this, you could delete KattisIDNameMapping.txt and run KattisMappingProgram.cs, or manually fix it by editing KattisIDNameMapping.txt.");
                idToNameMap.Add (id, name);
            }
            const string file = @"Config.txt";
            if (!File.Exists (file)) {
                log.WriteLine ("No Config.txt found");
                File.Create (file).Close ();
            }
            HashSet<string> ignore, urls;
            Stack<Tuple<string, Queue<string>>> folders;
            ignore = new HashSet<string> (10);
            urls = new HashSet<string> (5);
            folders = new Stack<Tuple<string, Queue<string>>> ();
            KattisState state = KattisState.NONE;
            sc = new CustomReader (file);
            while ((line = sc.NextLine ()) != null) {
                // skip blank lines
                if (line.Length == 0)
                    continue;
                if (!isKattisState (line, ref state)) {
                    if (state == KattisState.IGNORE)
                        if (line.Length > 0 && Regex.IsMatch (line, @"^[a-zA-Z\d]*(\.[a-zA-Z\d]+)?$")) {
                            if (!ignore.Contains (line))
                                ignore.Add (line);
                        } else {
                            log.WriteLine ("'" + line + "' does not match IGNORE regex (^[a-zA-Z\\d]*(\\.[a-zA-Z\\d]+)?$). Valid examples (ensure they're on separate lines and no commas): 2048, .cpp, abc.java");
                            throw new InvalidDataException ("'" + line + "' does not match IGNORE regex (^[a-zA-Z\\d]*(\\.[a-zA-Z\\d]+)?$). Valid examples (ensure they're on separate lines and no commas): 2048, .cpp, abc.java");
                        }
                    else if (state == KattisState.URL) {
                        if (!line.StartsWith ("https://github.com", StringComparison.Ordinal)) {
                            log.WriteLine ("'" + line + "' does not begin with https://github.com.");
                            throw new InvalidDataException ("'" + line + "' does not begin with https://github.com.");
                        }
                        if (!urls.Contains (line))
                            urls.Add (line);
                    } else if (state == KattisState.FOLDER) {
                        if (line.StartsWith ("to:", StringComparison.OrdinalIgnoreCase)) {
                            if (line.Length > 3)
                                folders.Push (new Tuple<string, Queue<string>> (line.Substring (3), new Queue<string> ()));
                            else {
                                log.WriteLine ("'to:' requires a folder");
                                throw new InvalidDataException ("'to:' requires a folder");
                            }
                        } else
                            folders.Peek ().Item2.Enqueue (line);
                    } else {
                        log.WriteLine (line + " | First line read should be an action.");
                        throw new InvalidDataException (line + " | First line read should be an action.");
                    }
                }
            }
            sc.Close ();

            SortedDictionary<string, SortedSet<KattisProblem>> table = new SortedDictionary<string, SortedSet<KattisProblem>> ();
            HashSet<string> IDsAddedToTable = new HashSet<string> ();

            // folder check
            while (folders.Count > 0) {
                Tuple<string, Queue<string>> t = folders.Pop ();
                string loc = t.Item1.Replace ("/tree/master/", "/blob/master/") + "/";
                while (t.Item2.Count > 0) {
                    string folder = t.Item2.Dequeue ();
                    DirectoryInfo dir = new DirectoryInfo (folder);
                    if (!dir.Exists) {
                        log.WriteLine (folder + " was not found, resulting in being skipped");
                        continue;
                    }
                    foreach (FileInfo info in dir.GetFiles ()) {
                        string githubProblemURL, githubProblemID, githubProblemExt;
                        // check if proper formatting 
                        if (!Regex.IsMatch (info.Name, @"^[a-zA-Z\d]+\.[a-zA-Z\d]+$"))
                            continue;
                        int periodPos = info.Name.IndexOf (".", StringComparison.Ordinal);
                        githubProblemID = info.Name.Substring (0, periodPos);
                        githubProblemExt = info.Name.Substring (periodPos);
                        githubProblemURL = loc + githubProblemID + githubProblemExt;
                        check (githubProblemURL, githubProblemID, githubProblemExt, ignore, IDsAddedToTable, table, idToNameMap);
                    }
                }
            }
            // folder end

            // URL check
            if (urls.Count > 0) {
                ServicePointManager.SecurityProtocol = (SecurityProtocolType) 3072;
                foreach (string link in urls) {
                    // check if it's an actual URL like https://www.google.com/ and not <sfghsdh-3wtsdfg>asd,.sg
                    if (!Uri.IsWellFormedUriString (link, UriKind.Absolute))
                        continue;
                    Stream githubStream = getURLStream (link);
                    // true if github link is nonexistent
                    if (githubStream == null) {
                        log.WriteLine ("Invalid link found '" + link + "'");
                        continue;
                    }
                    CustomReader githubReader = new CustomReader (githubStream);
                    while ((line = githubReader.NextLine ()) != null) {
                        // indicates that we've reached towards the bottom of the page where nothing below it will have problems/solutions to account for
                        if (line.Contains ("model-backdrop", StringComparison.Ordinal))
                            break;
                        // if the line does have 'a class="js-navigation-open"', then it has the information we need
                        if (!line.Contains ("a class=\"js-navigation-open\""))
                            continue;
                        string githubProblemURL, githubProblemID, githubProblemExt;
                        assignURLandIDandLang (line, out githubProblemURL, out githubProblemID, out githubProblemExt);
                        check (githubProblemURL, githubProblemID, githubProblemExt, ignore, IDsAddedToTable, table, idToNameMap);
                    }
                    githubStream.Close ();
                    githubReader.Close ();
                }
            }
            // URL end

            string output = "# Kattis Solutions\nSome solutions may be outdated and could be improved.\n\n";
            string other = "";
            int count = 0;
            foreach (KeyValuePair<string, SortedSet<KattisProblem>> pair in table) {
                foreach (KattisProblem p in pair.Value) {
                    other += p.ToString () + "\n";
                    count++;
                }
            }
            output += "| " + count + " Problem" + (count == 1 ? "" : "s") + " | Languages |\n| - | - |\n";
            const string readme = @"README.md";
            StreamWriter dc = new StreamWriter (readme, false, UnicodeEncoding.Default, 1 << 16);
            dc.Write (output + other);
            dc.Close ();
            log.StopTimer ();
            log.Close ();
            Console.WriteLine ("Press any key to exit...");
            Console.ReadKey ();
        }

        private static void check (string githubProblemURL, string githubProblemID, string githubProblemExt, HashSet<string> ignore, HashSet<string> IDsAddedToTable, SortedDictionary<string, SortedSet<KattisProblem>> table, Dictionary<string, string> idToNameMap) {
            log.WriteLine ("Checking: " + githubProblemID + githubProblemExt);
            // check if valid extension
            if (!Extensions.names.ContainsKey (githubProblemExt)) {
                log.WriteLine ("Found invalid extention '" + githubProblemExt + "'");
                return;
            }
            // check if need to ignore the problem
            if (ignore.Contains (githubProblemID) || ignore.Contains (githubProblemExt) || ignore.Contains (githubProblemID + githubProblemExt)) {
                log.WriteLine ("Ignored " + githubProblemID + githubProblemExt);
                return;
            }
            // check if proper formatting 
            if (!Regex.IsMatch (githubProblemID + githubProblemExt, @"^[a-zA-Z\d]+\.[a-zA-Z\d]+$")) {
                log.WriteLine ("Incorrect format found '" + githubProblemID + githubProblemExt + "'");
                return;
            }
            // check if this ID is already in the table
            if (IDsAddedToTable.Contains (githubProblemID)) {
                // use foreach loop since the key value of table is a SortedSet, and you cannot access indexes.
                // could be improved but most problems dont have the same name, so doesn't impact performance enough
                foreach (KattisProblem p in table[idToNameMap[githubProblemID]]) {
                    if (p.id == githubProblemID) {
                        string actualLang = Extensions.names[githubProblemExt];
                        // check if the actual language is already recorded - if not, add it; otherwise check more stuff
                        if (p.langs.ContainsKey (actualLang)) {
                            // check if the extension is already in - if it is, dont re-add it; otherwise add it
                            if (!p.langs[actualLang].ContainsKey (githubProblemExt))
                                p.langs[actualLang].Add (githubProblemExt, githubProblemURL);
                        } else {
                            p.langs.Add (actualLang, new SortedDictionary<string, string> { { githubProblemExt, githubProblemURL } });
                        }
                        break;
                    }
                }
            } else {
                string kattisName = string.Empty;
                // this is true if user hasn't updated their KattisIDNameMapping.txt
                if (!idToNameMap.ContainsKey (githubProblemID)) {
                    Stream kattisStream = getURLStream ("https://open.kattis.com/problems/" + githubProblemID);
                    // this is true if the ID is a nonexistent kattis problem 
                    if (kattisStream == null) {
                        log.WriteLine ("Invalid link found 'https://open.kattis.com/problems/" + githubProblemID + "'");
                        return;
                    }
                    log.WriteLine ("Recommendation: You should update KattisIDNameMapping.txt to ensure fast speeds");
                    CustomReader kattisReader = new CustomReader (kattisStream);
                    string line;
                    while ((line = kattisReader.NextLine ()) != null) {
                        // a line with "headline-wrapper" has the name of the problem in it
                        if (!line.Contains ("headline-wrapper", StringComparison.Ordinal))
                            continue;
                        assignKattisName (line, out kattisName);
                        break;
                    }
                    kattisStream.Close ();
                    kattisReader.Close ();
                    // fix weird html that causes apostrophes to be &#039;
                    if (kattisName.Contains ("&#039;", StringComparison.Ordinal))
                        kattisName = kattisName.Replace ("&#039;", "'");
                } else
                    kattisName = idToNameMap[githubProblemID];
                IDsAddedToTable.Add (githubProblemID);
                SortedDictionary<string, SortedDictionary<string, string>> langs = new SortedDictionary<string, SortedDictionary<string, string>> { { Extensions.names[githubProblemExt], new SortedDictionary<string, string> { { githubProblemExt, githubProblemURL } } } };
                KattisProblem prob = new KattisProblem (githubProblemID, kattisName, langs);
                // check if the name is already in the table since some problems can have the same names but different IDs
                if (table.ContainsKey (kattisName))
                    table[kattisName].Add (prob);
                else
                    table.Add (kattisName, new SortedSet<KattisProblem> { prob });
            }
        }

        private static void assignKattisName (string line, out string name) {
            // example original line: <div class="headline-wrapper"><h1>Akcija</h1></div>
            // "Akcija"
            int startPos = line.IndexOf ("h1", StringComparison.Ordinal) + 3;
            name = line.Substring (startPos, line.LastIndexOf ("h1", StringComparison.Ordinal) - 2 - startPos);
        }

        private static void assignURLandIDandLang (string line, out string url, out string id, out string ext) {
            // example original line: <span class="css-truncate css-truncate-target"><a class="js-navigation-open" title="akcija.cpp" id="baa8247d4440fa3d8f36da9a5a788af2-25c99d2246b7137ab0c4dd7c68adac3354afa97c" href="/MiniDomo/Kattis/blob/master/C%2B%2B/akcija.cpp">akcija.cpp</a></span>
            // "https://github.com/MiniDomo/Kattis/blob/master/C%2B%2B/akcija.cpp" and akcija .cpp
            int startPos = line.IndexOf ("href=\"", StringComparison.Ordinal) + 6;
            int endPos = line.LastIndexOf ("\"", StringComparison.Ordinal);
            url = "https://github.com" + line.Substring (startPos, endPos - startPos);
            startPos = url.LastIndexOf ("/", StringComparison.Ordinal) + 1;
            endPos = url.LastIndexOf (".", StringComparison.Ordinal);
            id = url.Substring (startPos, endPos - startPos);
            ext = url.Substring (endPos);
        }

        private static Stream getURLStream (string url) {
            try {
                WebRequest request = WebRequest.Create (url);
                WebResponse response = request.GetResponse ();
                return response.GetResponseStream ();
            } catch (Exception e) {
                return null;
            }
        }

        private static bool isKattisState (string line, ref KattisState state) {
            if (string.Equals (line, "ignore", StringComparison.OrdinalIgnoreCase))
                state = KattisState.IGNORE;
            else if (string.Equals (line, "url", StringComparison.OrdinalIgnoreCase))
                state = KattisState.URL;
            else if (string.Equals (line, "folder", StringComparison.OrdinalIgnoreCase))
                state = KattisState.FOLDER;
            else
                return false;
            return true;
        }

        private enum KattisState {
            IGNORE,
            URL,
            FOLDER,
            NONE
        }
    }
}