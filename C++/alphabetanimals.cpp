#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    string s;
    int n;
    cin >> s >> n;
    string arr[n];
    for (int x = 0; x < n; x++)
        cin >> arr[x];
    auto solve = [&]() {
        char last = s[s.size() - 1];
        int count['z' + 1] = {0};
        vector<string> v;
        for (int x = 0; x < n; x++) {
            string a = arr[x];
            count[a[0]]++;
            if (a[0] == last)
                v.push_back(a);
        }
        if (v.empty()) {
            cout << '?';
            return;
        }
        for (string a : v) {
            if (!count[a[a.size() - 1]] ||
                a[0] == a[a.size() - 1] && count[a[0]] == 1) {
                cout << a << '!';
                return;
            }
        }
        cout << v[0];
    };
    solve();
    return 0;
}