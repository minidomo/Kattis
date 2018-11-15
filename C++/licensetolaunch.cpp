#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    int n;
    cin >> n;
    int d = 0, val;
    cin >> val;
    for (int x = 1, a; x < n; x++) {
        cin >> a;
        if (a < val) {
            d = x;
            val = a;
        }
    }
    cout << d;
    return 0;
}