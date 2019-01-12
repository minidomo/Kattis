#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    int n;
    cin >> n;
    while (n-- > 0) {
        int a, b;
        cin >> a >> b;
        int pos1, pos2;
        pos1 = (a + b) / 2;
        pos2 = a - pos1;

        if (pos1 >= 0 && pos2 >= 0 && pos1 + pos2 == a && abs(pos1 - pos2) == b)
            cout << max(pos1, pos2) << ' ' << min(pos1, pos2) << '\n';
        else
            cout << "impossible" << '\n';
    }
    return 0;
}