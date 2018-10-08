#include <bits/stdc++.h>

using namespace std;

int gcd(int a, int b) { return b == 0 ? a : gcd(b, a % b); }

int lcm(int a, int b) { return a * b / gcd(a, b); }

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    int first, second, max;
    cin >> first >> second >> max;
    cout << (lcm(first, second) <= max ? "yes" : "no");
    return 0;
}