#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    const double pi = acos(-1);
    double diameter, vol;
    while (cin >> diameter >> vol) {
        if (diameter == 0 and vol == 0)
            return 0;
        double d = pow(((diameter * diameter * diameter) * pi - 6 * vol) / pi,
                       1 / 3.0);
        printf("%.9lf\n", d);
    }

    return 0;
}