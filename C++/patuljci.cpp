#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    int g[9];
    int idx[100];
    memset(idx, -1, sizeof(idx));
    for (int x = 0; x < 9; x++) {
        cin >> g[x];
        idx[g[x]] = x;
    }
    sort(g, g + 9);
    int sum = g[0] + g[1] + g[2] + g[3] + g[4] + g[5] + g[6];
    while (sum != 100) {
        next_permutation(g, g + 9);
        sum = g[0] + g[1] + g[2] + g[3] + g[4] + g[5] + g[6];
    }
    for (int a = 0; a < 7; a++) {
        int gIndex = 0;
        for (int x = 0, min = 10; x < 7; x++)
            if (idx[g[x]] < min) {
                min = idx[g[x]];
                gIndex = x;
            }
        idx[g[gIndex]] = 10;
        cout << g[gIndex] << "\n";
    }
    return 0;
}