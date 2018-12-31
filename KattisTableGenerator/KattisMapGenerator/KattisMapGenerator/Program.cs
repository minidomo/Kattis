using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.IO;
using System.Net;
using System.Text;

namespace KattisMapGenerator {
    public class Program {
        public static void Main (string[] args) {
            Stopwatch watch = new Stopwatch ();
            watch.Start ();
            // doesnt matter whether or not we have id or name as key since the link will be in order of name
            SortedList<string, string> map = new SortedList<string, string> (2500);
            const string file = @"KattisIDNameMapping.txt";
            if (!File.Exists (file)) {
                Console.WriteLine ("[" + watch.Elapsed + "] Created KattisIDNameMapping.txt");
                File.Create (file).Close ();
            }
            CustomReader sc = new CustomReader (file);
            string line;
            while ((line = sc.NextLine ()) != null) {
                string id = line;
                string name = sc.NextLine ();
                if (name == null)
                    throw new EndOfStreamException ("Missing name for ID '" + id + "'. To fix this, you could delete KattisIDNameMapping.txt and run this program, or manually fix it by editing KattisIDNameMapping.txt.");
                map.Add (id, name);
            }
            sc.Close ();
            StreamWriter dc = new StreamWriter (file, false, UnicodeEncoding.Default, 1 << 16);
            bool stillMore = true;
            int i = 0;
            string current = "https://open.kattis.com/problems?page=0&order=name";
            while (stillMore) {
                stillMore = false;
                if (!Uri.IsWellFormedUriString (current, UriKind.Absolute))
                    continue;
                Stream kattisStream = getURLStream (current);
                if (kattisStream == null)
                    continue;
                CustomReader kattisReader = new CustomReader (kattisStream);
                while ((line = kattisReader.NextLine ()) != null) {
                    if (line.Contains ("\"problem_list_next\"", StringComparison.Ordinal)) {
                        // the last page read wont have the next button enabled, resulting in the outer while loop to stop
                        if (line.Contains ("class=\"enabled\" role=\"button\" id=\"problem_list_next\"", StringComparison.Ordinal)) {
                            current = "https://open.kattis.com/problems?page=" + ++i + "&order=name";
                            stillMore = true;
                        }
                        // break since nothing lower at this point is important for the purpose of this program
                        break;
                    }
                    // a line that has 'class="name_column"' has the information we want
                    if (!line.Contains ("class=\"name_column\"", StringComparison.Ordinal))
                        continue;
                    int startPos = line.IndexOf ("/", line.IndexOf ("prob", StringComparison.Ordinal), StringComparison.Ordinal) + 1;
                    int endPos = line.IndexOf ("\"", startPos, StringComparison.Ordinal);
                    string id = line.Substring (startPos, endPos - startPos);
                    if (!map.ContainsKey (id)) {
                        startPos = endPos + 2;
                        endPos = line.IndexOf ("<", startPos, StringComparison.Ordinal);
                        string name = line.Substring (startPos, endPos - startPos);
                        if (name.Contains ("&#039;", StringComparison.Ordinal))
                            name = name.Replace ("&#039;", "'");
                        map.Add (id, name);
                    }
                    Console.WriteLine ("[" + watch.Elapsed + "] Added " + map[id] + " (" + id + ")");
                    dc.WriteLine (id + "\n" + map[id]);
                }
                kattisStream.Close ();
                kattisReader.Close ();
            }
            dc.Close ();
            watch.Stop ();
            Console.WriteLine ("[" + watch.Elapsed + "] " + map.Count + " Problems Counted");
            Console.WriteLine ("Press any key to exit...");
            Console.ReadKey ();
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
    }
}