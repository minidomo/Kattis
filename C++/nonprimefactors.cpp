#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    vector<int> fact(2000001, 0);
    vector<bool> primes(2000001, true);
    primes[0] = primes[1] = false;
    for (int x = 2; x * x <= 2000001; x++)
        if (primes[x])
            for (int a = x + x; a < 2000001; a += x)
                primes[a] = false;
    int cases;
    cin >> cases;
    while (cases-- > 0) {
        int num;
        cin >> num;
        if (fact[num] != 0) {
            cout << fact[num] << '\n';
            continue;
        }
        if (primes[num]) {
            cout << 1 << '\n';
            continue;
        }
        int original = num;
        int uniquePrimes = 0, factors = 1;
        if ((num & 1) == 0) {
            uniquePrimes++;
            int count = 0;
            while ((num & 1) == 0) {
                count++;
                num >>= 1;
            }
            factors *= count + 1;
        }
        if (primes[num]) {
            uniquePrimes++;
            factors <<= 1;
        } else {
            for (int x = 3; x <= sqrt(num); x += 2)
                if (num % x == 0) {
                    uniquePrimes++;
                    int count = 0;
                    while (num % x == 0) {
                        count++;
                        num /= x;
                    }
                    factors *= count + 1;
                }
            if (primes[num]) {
                uniquePrimes++;
                factors <<= 1;
            }
        }
        fact[original] = factors - uniquePrimes;
        cout << fact[original] << '\n';
    }
    return 0;
}