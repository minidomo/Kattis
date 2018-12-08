#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    int row, col, s;
    cin >> row >> col >> s;
    char map[row][col];
    for (int r = 0; r < row; r++)
        for (int c = 0; c < col; c++)
            cin >> map[r][c];
    int max = 0, rc = 0, cc = 0;
    for (int r = 0; r < row - s + 1; r++) {
        for (int c = 0; c < col - s + 1; c++) {
            int count = 0;
            for (int rt = r + 1; rt < r + s - 1; rt++)
                for (int ct = c + 1; ct < c + s - 1; ct++)
                    if (map[rt][ct] == '*')
                        count++;
            if (count > max) {
                max = count;
                rc = r;
                cc = c;
            }
        }
    }
    for (int c = cc; c < cc + s; c++)
        map[rc][c] = map[rc + s - 1][c] = '-';
    for (int r = rc; r < rc + s; r++)
        map[r][cc] = map[r][cc + s - 1] = '|';
    map[rc][cc] = map[rc][cc + s - 1] = map[rc + s - 1][cc] =
        map[rc + s - 1][cc + s - 1] = '+';
    cout << max << "\n";
    for (int r = 0; r < row; r++) {
        for (int c = 0; c < col; c++)
            cout << map[r][c];
        cout << "\n";
    }
    return 0;
}