#include <bits/stdc++.h>

using namespace std;

bool isPrime(int x) {
    if (x == 2 || x == 3)
        return true;
    if (x % 2 == 0 || x % 3 == 0)
        return false;
    for (int a = 6; a * a <= x; a += 6)
        if (x % (a - 1) == 0 || x % (a + 1) == 0)
            return false;
    return true;
}

int nextPrime(double diff) {
    int min = (int)ceil(pow(10, diff));
    int start = (int)ceil(min / 6.0) * 6;
    for (int x = start;; x += 6)
        if (x - 1 > min && isPrime(x - 1))
            return x - 1;
        else if (x + 1 > min && isPrime(x + 1))
            return x + 1;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    string arr[1001];
    arr[1] = "5";
    double val = log10(5);
    for (int x = 2; x < 1001; x++) {
        int prime = nextPrime(x - 1 - val);
        val += log10(prime);
        arr[x] = arr[x - 1] + " " + to_string(prime);
    }
    int cases;
    cin >> cases;
    while (cases-- > 0) {
        int x;
        cin >> x;
        cout << arr[x] << "\n";
    }
    return 0;
}