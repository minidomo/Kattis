using System;
using System.Collections.Generic;
using System.Text;

namespace KattisTableGenerator {
    public class KattisProblem : IComparer<KattisProblem>, IComparable, IEquatable<KattisProblem> {
        public string name,
        id,
        link;
        public SortedDictionary<string, SortedDictionary<string, string>> langs;

        public KattisProblem (string id, string name, SortedDictionary<string, SortedDictionary<string, string>> langs) {
            this.id = id;
            this.name = name;
            this.langs = langs;
            link = "https://open.kattis.com/problems/" + id;
        }

        public int Compare (KattisProblem a, KattisProblem b) {
            return a.id.CompareTo (b.id);
        }

        public int CompareTo (Object a) {
            if (a == null)
                return 1;
            if (!a.GetType ().Name.Equals ("KattisProblem", StringComparison.Ordinal))
                return 1;
            return id.CompareTo (((KattisProblem) a).id);
        }

        public bool Equals (KattisProblem other) {
            return id == other.id;
        }

        public override string ToString () {
            string output = "| [" + name + "](" + link + ") | ";
            foreach (KeyValuePair<string, SortedDictionary<string, string>> p1 in langs)
                foreach (KeyValuePair<string, string> p2 in p1.Value)
                    output += "[" + p1.Key + "](" + p2.Value + "), ";
            output = output.Substring (0, output.Length - 2) + " |";
            return output;
        }
    }
}