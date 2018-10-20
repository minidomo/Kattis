#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    int cases;
    cin >> cases;
    while (cases-- > 0) {
        string line;
        cin >> line;
        int sum = 0;
        for (int x = line.size() - 1, a = 1; x >= 0; x--, a++) {
            int dig = line[x] - '0';
            if ((a & 1) == 0) {
                dig <<= 1;
                if (dig > 9)
                    dig = dig % 10 + dig / 10 % 10;
            }
            sum += dig;
        }
        cout << (sum % 10 == 0 ? "PASS" : "FAIL") << "\n";
    }
    return 0;
}