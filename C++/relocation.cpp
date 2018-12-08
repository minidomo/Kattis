#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    int companies, queries;
    cin >> companies >> queries;
    int arr[companies];
    for (int x = 0; x < companies; x++)
        cin >> arr[x];
    while (queries-- > 0) {
        int type, a, b;
        cin >> type >> a >> b;
        if (type == 1)
            arr[a - 1] = b;
        else
            cout << abs(arr[a - 1] - arr[b - 1]) << "\n";
    }
    return 0;
}