#include <bits/stdc++.h>

typedef long long LL;

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    LL a, b;
    while (cin >> a >> b) {
        if (!a && !b)
            break;
        int count = 0, carry = 0;
        while (a || b) {
            int d1 = a % 10, d2 = b % 10;
            int sum = d1 + d2 + carry;
            if (sum > 9) {
                count++;
                carry = 1;
            } else {
                carry = 0;
            }
            a /= 10;
            b /= 10;
        }
        cout << (count ? to_string(count) + " " : "No ") + "carry operation" + (count > 1 ? "s" : "") + "." << '\n';
    }
}