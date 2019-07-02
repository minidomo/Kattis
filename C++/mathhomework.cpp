#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    int legs[3];
    int total, count = 0;
    cin >> legs[0] >> legs[1] >> legs[2] >> total;
    for (int a = 0; a <= total / legs[0]; a++)
        for (int b = 0; b <= total / legs[1]; b++)
            for (int c = 0; c <= total / legs[2]; c++)
                if (a * legs[0] + b * legs[1] + c * legs[2] == total) {
                    cout << a << " " << b << " " << c << "\n";
                    count++;
                }
    if (count == 0)
        cout << "impossible\n";
    return 0;
}