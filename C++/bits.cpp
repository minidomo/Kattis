#include <bits/stdc++.h>

using namespace std;

long nextPowOf(long a, long b) {
    return (long)(log(a) / log(b));
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int cases;
    cin >> cases;
    while (cases-- > 0) {
        long num, max = 0;
        cin >> num;
        long pow10 = (long)pow(10, nextPowOf(num, 10));
        for (; pow10 > 0; pow10 /= 10) {
            long count = 0;
            for (long temp = num / pow10; temp > 0; count++)
                temp -= (long)pow(2, nextPowOf(temp, 2));
            if (count > max)
                max = count;
        }
        cout << max << "\n";
    }
    return 0;
}