using System;
using System.Collections;
using System.Collections.Generic;
using System.IO;
using System.Runtime.InteropServices;
using System.Text.RegularExpressions;
using UnityEngine;
using UnityEngine.UI;

public class Main : MonoBehaviour {

    [DllImport ("user32.dll")]
    private static extern bool SetForegroundWindow (IntPtr hWnd);

    public Button button;

    private StreamWriter Log;
    private System.Diagnostics.Stopwatch stopwatch;

    public void Start () {
        Button task = button.GetComponent<Button> ();
        task.onClick.AddListener (Program);
    }

    public void Program () {
        Debug.Log ("Starting");

        Dictionary<string, string> programmingLanguages = addProgrammingLanguages ();
        List<KattisProblem> table = new List<KattisProblem> ();

        stopwatch = new System.Diagnostics.Stopwatch ();
        Log = new StreamWriter ("LatestLog.txt");
        Log.AutoFlush = true;
        StreamReader linkStream = new StreamReader ("GithubLinks.txt");

        string folder;
        stopwatch.Start ();

        while ((folder = linkStream.ReadLine ()) != null) {

            if (folder.IndexOf ('#') == 0 || folder.IndexOf ("//") == 0 || String.IsNullOrEmpty (folder))
                continue;

            WWW site = new WWW (folder);
            while (!site.isDone) { }

            WriteLog ("----- Checking Folder: " + folder + " -----");

            string GithubHTML = site.text;

            int GithubDelimmiterIndex = GithubHTML.IndexOf ("a class=\"js-navigation-open\"", StringComparison.Ordinal);

            // check if link is a correct github page
            if (GithubDelimmiterIndex == -1) {
                WriteLog ("@Error: Invalid URL - " + folder);
                continue;
            }

            WriteLog ("Valid URL - " + folder);

            for (; GithubDelimmiterIndex != -1; GithubDelimmiterIndex = GithubHTML.IndexOf ("a class=\"js-navigation-open\"", GithubDelimmiterIndex + 1, StringComparison.Ordinal)) {

                int begOfHyperLink = GithubHTML.IndexOf ("href", GithubDelimmiterIndex, StringComparison.Ordinal) + 6;
                int endOfHyperLink = GithubHTML.IndexOf (">", begOfHyperLink, StringComparison.Ordinal) - 1;
                string GithubCodeLink = "https://github.com" + GithubHTML.Substring (begOfHyperLink, endOfHyperLink - begOfHyperLink);

                string filename = GithubCodeLink.Substring (GithubCodeLink.LastIndexOf ("/", StringComparison.Ordinal) + 1);
                string[] partsOfFilename = filename.Split ('.');

                if (partsOfFilename.Length != 2 || Regex.IsMatch (partsOfFilename[0], "[^A-Za-z0-9]")) {
                    WriteLog ("@Error: File '" + filename + "' has illegal characters (Must have only letters and/or numbers) or has too many periods (Must only have one)");
                    continue;
                }

                KattisProblem problem = new KattisProblem (partsOfFilename[0]);

                site = new WWW (problem.KattisLink);
                while (!site.isDone) { }

                string KattisHTML = site.text;

                int KattisDelimmiterIndex = KattisHTML.IndexOf ("headline-wrapper", StringComparison.Ordinal);

                if (KattisDelimmiterIndex == -1) {
                    WriteLog ("@Error: Invalid URL - " + problem.KattisLink);
                    continue;
                }

                WriteLog ("Valid URL - " + problem.KattisLink);

                string Language = String.Empty;

                foreach (KeyValuePair<string, string> pair in programmingLanguages) {
                    string[] possible = pair.Key.Split (' ');
                    foreach (string ext in possible) {
                        if (partsOfFilename[1].Equals (ext)) {
                            Language = pair.Value;
                            goto checkLang;
                        }
                    }
                }

                checkLang:
                    // this means the language of the file was not found and cannot proceed to the next step
                    if (String.IsNullOrEmpty (Language)) {
                        WriteLog ("@Error: Language was not found. Either the file extension/language is not supported, or yours may be misspelled.");
                        continue;
                    }

                bool isDuplicate = false;
                foreach (KattisProblem p in table) {
                    if (p.Id.Equals (problem.Id)) {
                        isDuplicate = true;
                        p.LanguageAndLink.Add (Language, GithubCodeLink);
                        break;
                    }
                }

                if (isDuplicate)
                    continue;

                begOfHyperLink = KattisHTML.IndexOf ("h1", KattisDelimmiterIndex, StringComparison.Ordinal) + 3;
                endOfHyperLink = KattisHTML.IndexOf ("<", begOfHyperLink, StringComparison.Ordinal);

                problem.Name = KattisHTML.Substring (begOfHyperLink, endOfHyperLink - begOfHyperLink);
                problem.LanguageAndLink.Add (Language, GithubCodeLink);
                table.Add (problem);
            }
            WriteLog ("----- Stopped Checking Folder: " + folder);
        }
        linkStream.Close ();

        WriteLog ("----- Sorting Table -----");

        // table.Sort ((a, b) => a.Name.CompareTo (b.Name));
        // this one seemed to be slightly faster more often, so I chose this over the one above
        table.Sort (delegate (KattisProblem a, KattisProblem b) {
            return a.Name.CompareTo (b.Name);
        });

        StreamWriter ReadmeFile = new StreamWriter ("README.md");

        WriteLog ("----- Writing to README.md -----");

        ReadmeFile.WriteLine ("# Kattis Solutions");
        ReadmeFile.WriteLine ("Some solutions may be outdated and could be improved.\n\n");

        ReadmeFile.WriteLine ("| Problems | Languages |");
        ReadmeFile.WriteLine ("| - | - |");

        foreach (KattisProblem p in table)
            ReadmeFile.WriteLine (p.GetFormatted ());

        ReadmeFile.Close ();
        stopwatch.Stop ();

        WriteLog ("Runtime: " + stopwatch.Elapsed);

        linkStream.Close ();
        Log.Close ();
        Debug.Log ("Finished");

        SetForegroundWindow (InitialStart.hWnd);
    }

    private void WriteLog (string log) {
        Log.WriteLine ("[" + stopwatch.Elapsed + "] " + log);
    }

    private Dictionary<string, string> addProgrammingLanguages () {
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