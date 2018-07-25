using System;
using System.Collections.Generic;

public struct KattisProblem {
    
    public string Name, Id, KattisLink;
    public SortedDictionary<string, string> LanguageAndLink;

    public KattisProblem (string Id) {
        Id = Id.ToLower (); // shouldn't be needed but some people put capitals in their file names
        this.Id = Id;
        KattisLink = "https://open.kattis.com/problems/" + Id;
        Name = "";
        LanguageAndLink = new SortedDictionary<string, string> ();
    }

    public string GetFormatted () {
        string output = "| [" + Name + "](" + KattisLink + ") | ";
        foreach (KeyValuePair<string, string> pair in LanguageAndLink) {
            output += "[" + pair.Key + "](" + pair.Value + "), ";
        }
        output = output.Substring (0, output.LastIndexOf (',')) + " |";
        return output;
    }
}