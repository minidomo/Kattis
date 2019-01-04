#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    int n, y;
    cin >> n >> y;
    bool arr[n];
    int count = 0;
    memset(arr, 1, sizeof arr);
    while (y-- > 0) {
        int a;
        cin >> a;
        if (arr[a]) {
            count++;
            arr[a] = false;
        }
    }
    for (int x = 0; x < n; x++)
        if (arr[x])
            cout << x << '\n';
    cout << "Mario got " << count << " of the dangerous obstacles.";
    return 0;
}