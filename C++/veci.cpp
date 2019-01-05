#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    int a;
    cin >> a;
    int num = a;
    int digs = (int)log10(a) + 1;
    int arr[digs];
    for (int x = 0; x < digs; x++) {
        arr[x] = a % 10;
        a /= 10;
    }
    sort(arr, arr + digs);
    int MIN = 1000000;
    do {
        int s = 0;
        for (int x = digs - 1; x >= 0; x--)
            s = s * 10 + arr[x];
        if (s > num && s < MIN)
            MIN = s;
    } while (next_permutation(arr, arr + digs));
    cout << (MIN == 1000000 ? 0 : MIN);
    return 0;
}