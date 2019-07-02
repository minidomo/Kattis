#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    int cases, tb = 0, lr = 0;
    cin >> cases;
    while (cases-- > 0) {
        char c;
        for (int x = 0; x < 2; x++) {
            cin >> c;
            if (c == '0')
                tb++;
        }
        for (int x = 0; x < 2; x++) {
            cin >> c;
            if (c == '0')
                lr++;
        }
    }
    int swords = min(tb / 2, lr / 2);
    int dsword = swords * 2;
    cout << swords << ' ' << tb - dsword << ' ' << lr - dsword;
    return 0;
}