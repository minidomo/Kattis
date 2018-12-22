#include <bits/stdc++.h>

using namespace std;

int rows, cols, val = 1;
int arr[101][101];
bool change = true;

bool inRange(int r, int c) {
    return r >= 1 && r <= rows && c >= 1 && c <= cols;
}

void flood(int r, int c) {
    if (inRange(r - 1, c) && arr[r - 1][c] == 0) {
        arr[r - 1][c] = val + 1;
        change = true;
    }
    if (inRange(r + 1, c) && arr[r + 1][c] == 0) {
        arr[r + 1][c] = val + 1;
        change = true;
    }
    if (inRange(r, c - 1) && arr[r][c - 1] == 0) {
        arr[r][c - 1] = val + 1;
        change = true;
    }
    if (inRange(r, c + 1) && arr[r][c + 1] == 0) {
        arr[r][c + 1] = val + 1;
        change = true;
    }
}
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    memset(arr, 0, sizeof arr);
    int n;
    cin >> rows >> cols >> n;
    while (n-- > 0) {
        int r, c;
        cin >> r >> c;
        arr[r][c] = val;
    }
    int days = 1;
    while (change) {
        change = false;
        for (int r = 1; r <= rows; r++)
            for (int c = 1; c <= cols; c++)
                if (arr[r][c] == val)
                    flood(r, c);
        if (change) {
            val++;
            days++;
        }
    }
    cout << days;
    return 0;
}