#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    int n;
    cin >> n;
    int arr[n];
    int low = 0, high = (int)1e10, ans;
    for (int x = 0; x < n; x++)
        cin >> arr[x];
    while (low < high) {
        int mid = (low + high) / 2;
        int count = 0;
        for (int x : arr)
            if (x >= mid)
                count++;
        if (count < mid)
            high = mid;
        else {
            ans = mid;
            low = mid + 1;
        }
    }
    cout << ans;
    return 0;
}