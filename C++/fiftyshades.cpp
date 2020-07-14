#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    int n, c;
    string s;
    cin >> n;
    while (n--) {
        cin >> s;
        transform(s.begin(), s.end(), s.begin(), ::tolower);
        if (s.find("pink") != string::npos || s.find("rose") != string::npos)
            c++;
    }
    if (c == 0)
        cout << "I must watch Star Wars with my daughter";
    else
        cout << c;
    return 0;
}