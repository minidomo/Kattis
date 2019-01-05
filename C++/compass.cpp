#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    int cur, goal;
    cin >> cur >> goal;
    int cw = cur > goal ? 360 - cur + goal : goal > cur ? goal - cur : 0;
    int ccw = cur > goal ? cur - goal : goal > cur ? 360 - goal + cur : 0;
    if (cw == 180)
        cout << 180;
    else
        cout << (cw < ccw ? cw : -ccw);
    return 0;
}