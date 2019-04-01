#include <bits/stdc++.h>

using namespace std;

struct point {
    int r, c, count;
};

const int MAX = 500, INF = 250000;
int R, C;
int grid[MAX][MAX], A[MAX][MAX];
int dx[] = {0, 0, 1, -1}, dy[] = {1, -1, 0, 0};

void bfs(int r = 0, int c = 0) {
    queue<point> q;
    A[r][c] = 0;
    q.push(point{r, c, 0});
    while (!q.empty()) {
        point cur = q.front();
        q.pop();
        if (cur.r == R - 1 && cur.c == C - 1)
            continue;
        int val = grid[cur.r][cur.c];
        for (int x = 0; x < 4; x++) {
            r = cur.r + val * dx[x];
            c = cur.c + val * dy[x];
            if (r < 0 || c < 0 || r >= R || c >= C)
                continue;
            if (cur.count + 1 < A[r][c])
                q.push(point{r, c, A[r][c] = cur.count + 1});
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cin >> R >> C;
    for (int r = 0; r < R; r++) {
        string a;
        cin >> a;
        for (int c = 0; c < C; c++) {
            grid[r][c] = a[c] - '0';
            A[r][c] = INF;
        }
    }
    bfs();
    cout << (A[R - 1][C - 1] == INF ? -1 : A[R - 1][C - 1]);
    return 0;
}