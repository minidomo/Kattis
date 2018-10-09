#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    int bites;
    cin >> bites;
    cin.ignore();
    string line;
    for (int x = 1; x <= bites; x++) {
        cin >> line;
        if (line == "mumble")
            continue;
        if (to_string(x) != line) {
            cout << "something is fishy";
            return 0;
        }
    }
    cout << "makes sense";
    return 0;
}