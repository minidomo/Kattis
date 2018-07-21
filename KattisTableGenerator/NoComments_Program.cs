using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.IO;
using System.Net;
using System.Text.RegularExpressions;

public class NoComments_Program {

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

            if (lineFromStream.IndexOf ('#') == 0 || lineFromStream.IndexOf ("//") == 0 || String.IsNullOrEmpty (lineFromStream))
                continue;

            Stream stream = getStreamFromUrl (lineFromStream);

            if (stream == null)
                continue;

            StreamReader githubFolderStream = new StreamReader (stream);
            string folder = lineFromStream;

            WriteLog ("----- Checking Folder: " + folder + " -----");

            while ((lineFromStream = githubFolderStream.ReadLine ()) != null) {

                
                if (fastCheck (lineFromStream, "modal-backdrop")) {
                    WriteLog ("----- Stopped Checking Folder: " + folder + " -----");
                    break;
                }

                
                if (!fastCheck (lineFromStream, "a class=\"js-navigation-open\""))
                    continue;

                string GithubCodeLink = formatToGithubLink (lineFromStream);

                string filename = GithubCodeLink.Substring (GithubCodeLink.LastIndexOf ('/') + 1);

                string[] parts = filename.Split ('.');

                if (parts.Length != 2 || Regex.IsMatch (parts[0], "[^A-Za-z0-9]")) {
                    WriteLog ("@Error: File '" + filename + "' has illegal characters (Must have only letters and/or numbers) or has too many periods (Must only have one)");
                    continue;
                }

                Problem problem = new Problem (parts[0]);

                stream = getStreamFromUrl (problem.KattisLink);

                if (stream == null)
                    continue;

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
                    if (String.IsNullOrEmpty (language)) {
                        WriteLog ("@Error: Language was not found. Either the file extension/language is not supported, or yours may be misspelled.");
                        continue;
                    }

                bool isDuplicate = false;
                foreach (Problem p in table) {
                    if (p.Id.Equals (problem.Id)) {
                        isDuplicate = true;
                        p.LanguageAndLink.Add (language, GithubCodeLink);
                        break;
                    }
                }

                if (isDuplicate)
                    continue;

                StreamReader kattisHTMLStream = new StreamReader (stream);

                while ((lineFromStream = kattisHTMLStream.ReadLine ()) != null) {

                    if (!fastCheck (lineFromStream, "headline-wrapper"))
                        continue;

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
        int startingPosition = line.IndexOf ("h1") + 3;
        return line.Substring (startingPosition, line.LastIndexOf ("h1") - 2 - startingPosition);
    }

    private static string formatToGithubLink (string line) {
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