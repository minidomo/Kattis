#include <bits/stdc++.h>

using namespace std;

int sumDig(int n) {
    int sum = 0;
    while (n > 0) {
        sum += n % 10;
        n /= 10;
    }
    return sum;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    int n;
    cin >> n;
    while (n % sumDig(n) != 0)
        n++;
    cout << n << "\n";
    return 0;
}