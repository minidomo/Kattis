#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    double a, b, c, i, j, k;
    cin >> a >> b >> c >> i >> j >> k;
    double m = min(a / i, min(b / j, c / k));
    double val = m * i;
    a -= val;
    b -= val = m * j;
    c -= val = m * k;
    cout << setprecision(6) << fixed;
    cout << a << " " << b << " " << c;
    return 0;
}