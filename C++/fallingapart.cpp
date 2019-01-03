#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    int n;
    cin >> n;
    int arr[n];
    for (int x = 0; x < n; x++)
        cin >> arr[x];
    sort(arr, arr + n, greater<int>());
    int a = 0, b = 0;
    for (int x = 0; x < n; x++)
        if ((x & 1) == 0)
            a += arr[x];
        else
            b += arr[x];
    cout << a << ' ' << b;
    return 0;
}