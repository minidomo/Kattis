#include <bits/stdc++.h>

typedef unsigned long long ull;

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    ull cases, left, right;
    cin >> cases;
    while (cases-- > 0) {
        cin >> left >> right;
        // use gauss formula
        // 1 + (left * (left + 1)) / 2
        // (right * (left + left + right + 3)) / 2
        ull val1 = 1 + (left * (left + 1)) / 2;
        ull val2 = (right * (left + left + right + 3)) / 2;
        cout << val1 + val2 << "\n";
    }
    return 0;
}