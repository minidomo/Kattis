#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    int r, c;
    cin >> r >> c;
    char map[r][c];
    for (int a = 0; a < r; a++)
        for (int s = 0; s < c; s++)
            cin >> map[a][s];
    int arr[5] = {0, 0, 0, 0, 0};
    for (int row = 0; row < r - 1; row++) {
        for (int col = 0; col < c - 1; col++) {
            int num = 0;
            char tl = map[row][col], tr = map[row][col + 1];
            char bl = map[row + 1][col], br = map[row + 1][col + 1];
            if (tl == '#' || tr == '#' || bl == '#' || br == '#')
                continue;
            if (tl == 'X')
                num++;
            if (tr == 'X')
                num++;
            if (bl == 'X')
                num++;
            if (br == 'X')
                num++;
            arr[num]++;
        }
    }
    cout << arr[0] << "\n"
         << arr[1] << "\n"
         << arr[2] << "\n"
         << arr[3] << "\n"
         << arr[4];
    return 0;
}