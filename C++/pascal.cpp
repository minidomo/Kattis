#include <bits/stdc++.h>

using namespace std;

int N;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cin >> N;
    if (N == 1)
        cout << 0;
    else if (!(N & 1))
        cout << N - (N >> 1);
    else {
        bool isprime = 1;
        for (int x = 3; x <= sqrt(N); x += 2)
            if (!(N % x)) {
                cout << N - (N / x);
                isprime = 0;
                break;
            }
        if (isprime)
            cout << N - 1;
    }
    return 0;
}