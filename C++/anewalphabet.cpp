#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    string arr[] = {"@",   "8",      "(",   "|)", "3", "#",       "6",
                    "[-]", "|",      "_|",  "|<", "1", "[]\\/[]", "[]\\[]",
                    "0",   "|D",     "(,)", "|Z", "$", "\'][\'",  "|_|",
                    "\\/", "\\/\\/", "}{",  "`/", "2"};
    string line;
    getline(cin, line);
    for (int x = 0; x < line.length(); x++) {
        int c = line[x];
        if (isalpha(line[x])) {
            if (c >= 'A' && c <= 'Z')
                c += 32;
            cout << arr[c - 'a'];
        } else
            cout << line[x];
    }
    return 0;
}