#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    string a, b;
    cin >> a >> b;
    int row = -1, col = -1;
    for (int c = 0; c < a.length(); c++) {
        for (int r = 0; r < b.length(); r++) {
            if (b[r] == a[c]) {
                row = r;
                col = c;
                break;
            }
        }
        if (row != -1 && col != -1)
            break;
    }
    for (int r = 0; r < b.length(); r++) {
        for (int c = 0; c < a.length(); c++) {
            if (c == col)
                cout << b[r];
            else if (r == row)
                cout << a[c];
            else
                cout << '.';
        }
        cout << '\n';
    }
    return 0;
}