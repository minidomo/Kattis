#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    string s;
    cin >> s;
    int len = s.size() / 3;
    set<string> m;
    auto f = [&]() {
        for (int x = 0; x < s.size(); x += len) {
            string sub = s.substr(x, len);
            if (m.find(sub) != m.end()) {
                cout << sub;
                return;
            } else {
                m.insert(sub);
            }
        }
    };
    f();
    return 0;
}