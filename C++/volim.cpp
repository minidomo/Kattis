#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    int p, ques, time = 0;
    cin >> p >> ques;
    while (ques-- > 0) {
        int t;
        char c;
        cin >> t >> c;
        time += t;
        if (time > 210)
            break;
        if (c == 'T')
            p = p == 8 ? 1 : p + 1;
    }
    cout << p;
    return 0;
}