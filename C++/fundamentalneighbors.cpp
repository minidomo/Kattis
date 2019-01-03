#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    int n;
    while (cin >> n) {
        cout << n << ' ';
        int neighbor = 1;
        int c = 0;
        if ((n & 1) == 0) {
            while ((n & 1) == 0) {
                n >>= 1;
                c++;
            }
            neighbor *= (int)pow(c, 2);
        }
        for (int x = 3; x < sqrt(n) + 1; x += 2) {
            c = 0;
            while (n % x == 0) {
                n /= x;
                c++;
            }
            if (c > 0)
                neighbor *= (int)pow(c, x);
        }
        cout << neighbor << '\n';
    }
    return 0;
}