#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    int n, sum = 0;
    cin >> n;
    while (n--) {
        int v;
        cin >> v;
        sum += v;
    }
    cout << sum;
    return 0;
}