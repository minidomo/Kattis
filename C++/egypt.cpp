#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    int a, b, c;
    while (cin >> a >> b >> c) {
        if (a == b && b == c && a == 0)
            break;
        int big = max(a, max(b, c));
        if (a == big)
            swap(a, c);
        else if (b == big)
            swap(b, c);
        cout << (a * a + b * b == c * c ? "right" : "wrong") << '\n';
    }
    return 0;
}