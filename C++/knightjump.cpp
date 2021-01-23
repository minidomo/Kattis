#include <bits/stdc++.h>

using namespace std;

struct A {
    int r, c, m;
};

int dx[] = {2, 2, -2, -2, 1, 1, -1, -1}, dy[] = {1, -1, 1, -1, 2, -2, 2, -2};

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);

    int n, R, C;
    cin >> n;
    string arr[n];
    for (int r = 0; r < n; r++) {
        cin >> arr[r];
        for (int c = 0; c < arr[r].size(); c++)
            if (arr[r][c] == 'K')
                R = r, C = c;
    }
    auto solve = [&]() {
        vector<vector<int>> minc(n, vector<int>(n, 10000));
        queue<A> q;
        q.push({R, C, minc[R][C] = 0});
        while (!q.empty()) {
            A cur = q.front();
            q.pop();
            for (int x = 0; x < 8; x++) {
                int r = cur.r + dx[x];
                int c = cur.c + dy[x];
                if (r < 0 || c < 0 || r >= n || c >= n || arr[r][c] == '#')
                    continue;
                if (cur.m + 1 < minc[r][c])
                    q.push({r, c, minc[r][c] = cur.m + 1});
            }
        }

        if (minc[0][0] == 10000)
            cout << -1;
        else
            cout << minc[0][0];
    };
    solve();
    return 0;
}
