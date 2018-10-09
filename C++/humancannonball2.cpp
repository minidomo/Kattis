#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    int cases;
    double vel, angle, deltaX, h1, h2, toRadians = acos(-1) / 180;
    cin >> cases;
    while (cases-- > 0) {
        cin >> vel >> angle >> deltaX >> h1 >> h2;
        double time = deltaX / vel / cos(angle * toRadians);
        double deltaY =
            vel * time * sin(angle * toRadians) - .5 * 9.81 * time * time;
        cout << (deltaY >= h1 + 1 and deltaY <= h2 - 1 ? "Safe\n"
                                                       : "Not Safe\n");
    }

    return 0;
}