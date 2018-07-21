using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.IO;
using System.Net;
using System.Text.RegularExpressions;

public class Program {

    private static StreamWriter ConsoleOutput = new StreamWriter (Console.OpenStandardOutput ());
    private static StreamWriter Log = new StreamWriter ("LatestLog.txt");
    private static Stopwatch stopwatch = new Stopwatch ();

    public static void Main (string[] args) {
        ServicePointManager.SecurityProtocol = (SecurityProtocolType) 3072;
        Dictionary<string, string> programmingLanguages = addProgrammingLanguages ();
        List<Problem> table = new List<Problem> ();

        StreamReader linkStream = new StreamReader ("GithubLinks.txt");

        stopwatch.Start ();

        ConsoleOutput.AutoFlush = true;
        ConsoleOutput.WriteLine ("Running program.");

        string lineFromStream;

        while ((lineFromStream = linkStream.ReadLine ()) != null) {

            // # or // at the beginning of a line indicates a comment and ignores blank lines
            if (lineFromStream.IndexOf ('#') == 0 || lineFromStream.IndexOf ("//") == 0 || String.IsNullOrEmpty (lineFromStream))
                continue;

            Stream stream = getStreamFromUrl (lineFromStream);

            if (stream == null)
                continue;

            StreamReader githubFolderStream = new StreamReader (stream);
            string folder = lineFromStream;

            WriteLog ("----- Checking Folder: " + folder + " -----");

            while ((lineFromStream = githubFolderStream.ReadLine ()) != null) {

                // if it reaches that class "modal-backdrop js-touch-events", then it finished checking all the files of the folder
                if (fastCheck (lineFromStream, "modal-backdrop")) {
                    WriteLog ("----- Stopped Checking Folder: " + folder + " -----");
                    break;
                }

                // for a line to contain a link to a file, it must be of class = js-navigation-open
                if (!fastCheck (lineFromStream, "a class=\"js-navigation-open\""))
                    continue;

                // ex: https://github.com/MiniDomo/Kattis/blob/master/C%2B%2B/akcija.cpp
                string GithubCodeLink = formatToGithubLink (lineFromStream);

                // ex: akcija.cpp
                string filename = GithubCodeLink.Substring (GithubCodeLink.LastIndexOf ('/') + 1);

                // ex: parts[0] = akcija, parts[1] = cpp
                string[] parts = filename.Split ('.');

                // must be two parts otherwise not valid filename
                // it can only have numbers and letters, if not it is invalid
                if (parts.Length != 2 || Regex.IsMatch (parts[0], "[^A-Za-z0-9]")) {
                    WriteLog ("@Error: File '" + filename + "' has illegal characters (Must have only letters and/or numbers) or has too many periods (Must only have one)");
                    continue;
                }

                // creates a new Problem with the Id as akcija
                Problem problem = new Problem (parts[0]);

                stream = getStreamFromUrl (problem.KattisLink);

                if (stream == null)
                    continue;

                // identify the programming language
                string language = String.Empty;

                foreach (KeyValuePair<string, string> pair in programmingLanguages) {
                    string[] possible = pair.Key.Split (' ');
                    foreach (string ext in possible) {
                        if (parts[1].Equals (ext)) {
                            language = pair.Value;
                            goto checkLang;
                        }
                    }
                }

                checkLang:
                    // this means the language of the file was not found and cannot proceed to the next step
                    if (String.IsNullOrEmpty (language)) {
                        WriteLog ("@Error: Language was not found. Either the file extension/language is not supported, or yours may be misspelled.");
                        continue;
                    }

                // check to see if the Id of the current problem is already in the table 
                bool isDuplicate = false;
                foreach (Problem p in table) {
                    if (p.Id.Equals (problem.Id)) {
                        isDuplicate = true;
                        p.LanguageAndLink.Add (language, GithubCodeLink);
                        break;
                    }
                }

                // if the Id is in the table, go to the next iteration
                if (isDuplicate)
                    continue;

                StreamReader kattisHTMLStream = new StreamReader (stream);

                // iterate through the stream to find the name of the problem
                while ((lineFromStream = kattisHTMLStream.ReadLine ()) != null) {

                    // the line with the name of the kattis problem has the class headline-wrapper
                    if (!fastCheck (lineFromStream, "headline-wrapper"))
                        continue;

                    // ex: Akcija
                    problem.Name = formatToKattisName (lineFromStream);
                    break;
                }

                kattisHTMLStream.Close ();
                problem.LanguageAndLink.Add (language, GithubCodeLink);
                table.Add (problem);
            }
            githubFolderStream.Close ();
        }
        linkStream.Close ();

        WriteLog ("----- Sorting Table -----");

        // table.Sort ((a, b) => a.Name.CompareTo (b.Name));
        // this one seemed to be slightly faster more often, so I chose this over the one above
        table.Sort (delegate (Problem a, Problem b) {
            return a.Name.CompareTo (b.Name);
        });

        StreamWriter ReadmeFile = new StreamWriter ("README.md");

        WriteLog ("----- Writing to README.md -----");

        ReadmeFile.WriteLine ("# Kattis Solutions");
        ReadmeFile.WriteLine ("Some solutions may be outdated and could be improved.\n\n");

        ReadmeFile.WriteLine ("| Problems | Languages |");
        ReadmeFile.WriteLine ("| - | - |");

        foreach (Problem p in table)
            ReadmeFile.WriteLine (p.GetFormatted ());

        ReadmeFile.Close ();

        stopwatch.Stop ();

        WriteLog ("Runtime: " + stopwatch.Elapsed);
        ConsoleOutput.WriteLine ("Press any key to exit the program...");
        Log.Close ();
        ConsoleOutput.Close ();
        Console.ReadKey ();
    }

    private static string formatToKattisName (string line) {
        // example original line: <div class="headline-wrapper"><h1>Akcija</h1></div>
        // returns "Akcija"
        int startingPosition = line.IndexOf ("h1") + 3;
        return line.Substring (startingPosition, line.LastIndexOf ("h1") - 2 - startingPosition);
    }

    private static string formatToGithubLink (string line) {
        // example original line: <span class="css-truncate css-truncate-target"><a class="js-navigation-open" title="akcija.cpp" id="baa8247d4440fa3d8f36da9a5a788af2-25c99d2246b7137ab0c4dd7c68adac3354afa97c" href="/MiniDomo/Kattis/blob/master/C%2B%2B/akcija.cpp">akcija.cpp</a></span>
        // returns "https://github.com/MiniDomo/Kattis/blob/master/C%2B%2B/akcija.cpp"
        int lastDoubleQuote = line.LastIndexOf ('\"');
        int startingPosition = line.LastIndexOf ('\"', lastDoubleQuote - 1) + 1;
        line = "https://github.com" + line.Substring (startingPosition, lastDoubleQuote - startingPosition);
        return line;
    }

    private static Stream getStreamFromUrl (string url) {
        WebRequest request = WebRequest.Create (url);
        WebResponse response;
        try {
            response = request.GetResponse ();
            WriteLog ("Valid URL - " + url);
        } catch (System.Exception) {
            WriteLog ("@Error: Invalid URL - " + url);
            response = null;
        }
        return response == null ? null : response.GetResponseStream ();
    }

    private static void WriteLog (string log) {
        ConsoleOutput.WriteLine ("[" + stopwatch.Elapsed + "] " + log);
        Log.WriteLine ("[" + stopwatch.Elapsed + "] " + log);
    }

    private static bool fastCheck (string strToSearch, string strKeyToLookFor) {
        // http://cc.davelozinski.com/c-sharp/fastest-way-to-check-if-a-string-occurs-within-a-string
        return (strToSearch.Length - strToSearch.Replace (strKeyToLookFor, String.Empty).Length) / strKeyToLookFor.Length == 1 ? true : false;
    }

    private static Dictionary<string, string> addProgrammingLanguages () {
        Dictionary<string, string> dict = new Dictionary<string, string> ();
        dict.Add ("c h", "C");
        dict.Add ("cs", "C#");
        dict.Add ("C cc cpp cxx c++ h hh hpp hxx h++", "C++");
        dict.Add ("go", "Go");
        dict.Add ("hs lhs", "Haskell");
        dict.Add ("java", "Java");
        dict.Add ("js", "Javascript");
        dict.Add ("kt kts", "Kotlin");
        dict.Add ("h m mm M", "Objective-C");
        dict.Add ("pp pas inc", "Pascal");
        dict.Add ("php phtml php3 php4 php5 php7 phps php-s", "PHP");
        dict.Add ("pl pro P", "Prolog");
        dict.Add ("py pyc pyd pyo pyw pyz", "Python");
        dict.Add ("rb", "Ruby");
        dict.Add ("scala", "Scala");
        return dict;
    }
}