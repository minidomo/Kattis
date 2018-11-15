#include <bits/stdc++.h>

using namespace std;

int x, y;

double dist(int x1, int y1) {
    int xd = x - x1;
    int yd = y - y1;
    return sqrt(xd * xd + yd * yd);
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    int x1, y1, x2, y2;
    cin >> x >> y >> x1 >> y1 >> x2 >> y2;
    double d;
    if (x >= x1 && x <= x2)
        d = y < y1 ? y1 - y : y - y2;
    else if (y >= y1 && y <= y2)
        d = x < x1 ? x1 - x : x - x2;
    else if (x < x1)
        d = dist(x1, y < y1 ? y1 : y2);
    else
        d = dist(x2, y < y1 ? y1 : y2);
    cout << d;
    return 0;
}