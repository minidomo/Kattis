#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    int n, s;
    cin >> n;
    while (n-- > 0) {
        cin >> s;
        int arr[2 * s + 1][2 * s + 1];
        memset(arr, 10000, sizeof arr);
        int step = 1, r = s, c = s;
        arr[r][c] = 1;
        while (s-- > 0) {
            int pr = r, pc = c;
            char a;
            cin >> a;
            if (a == 'N')
                r--;
            else if (a == 'S')
                r++;
            else if (a == 'W')
                c--;
            else
                c++;
            arr[pr][pc] = min(arr[pr][pc], arr[r][c] + 1);
            arr[r][c] = step = min(arr[r][c], ++step);
        }
        cout << step - 1 << '\n';
    }
    return 0;
}