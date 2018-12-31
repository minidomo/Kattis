using System;
using System.Diagnostics;
using System.IO;
using System.Text;

namespace KattisTableGenerator {
    public class LogWriter {
        private StreamWriter dc;
        private StreamWriter file;
        private Stopwatch watch;

        public LogWriter () {
            dc = new StreamWriter (Console.OpenStandardOutput (1 << 16), UnicodeEncoding.Default);
            file = new StreamWriter (@"Log.txt", false, UnicodeEncoding.Default, 1 << 16);
            watch = new Stopwatch ();
        }

        public void WriteLine (Object a) {
            dc.WriteLine ("[" + watch.Elapsed + "] " + a);
            file.WriteLine ("[" + watch.Elapsed + "] " + a);
            dc.Flush ();
            file.Flush ();
        }

        public void Write (Object a) {
            dc.Write ("[" + watch.Elapsed + "] " + a);
            file.Write ("[" + watch.Elapsed + "] " + a);
            dc.Flush ();
            file.Flush ();
        }

        public void StartTimer () {
            watch.Start ();
        }

        public void StopTimer () {
            watch.Stop ();
        }

        public void WriteLineTimer () {
            dc.WriteLine (watch.Elapsed);
            file.WriteLine (watch.Elapsed);
        }

        public void Close () {
            dc.Close ();
            file.Close ();
        }
    }
}