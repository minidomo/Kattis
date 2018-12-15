#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    bool food[366];
    memset(food, 0, sizeof(food));
    int cases;
    cin >> cases;
    int mmin = 400, mmax = -1;
    while (cases-- > 0) {
        int a, b;
        cin >> a >> b;
        mmin = min(mmin, a);
        mmax = max(mmax, b);
        for (; a <= b; a++)
            food[a] = true;
    }
    int days = 0;
    for (; mmin <= mmax; mmin++)
        if (food[mmin])
            days++;
    cout << days;
    return 0;
}