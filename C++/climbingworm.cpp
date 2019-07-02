#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    int a, b, h;
    cin >> a >> b >> h;
    int ans = max(0, (int)ceil(h / (double)(a - b)) - 5);
    int height = ans * (a - b);
    while (1) {
        height += a;
        ans++;
        if (height >= h)
            break;
        height -= b;
    }
    cout << ans;
    return 0;
}