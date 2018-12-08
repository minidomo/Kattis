#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    int vic[][2] = {{8, 6}, {5, 3}, {2, 1}};
    int tre[][2] = {{6, 3}, {3, 2}, {0, 1}};
    int g, s, c, val;
    cin >> g >> s >> c;
    val = g * tre[0][1] + s * tre[1][1] + c * tre[2][1];
    string tcard =
        val >= tre[0][0] ? "Gold" : (val >= tre[1][0] ? "Silver" : "Copper");
    string vcard =
        val >= vic[0][0]
            ? "Province"
            : (val >= vic[1][0] ? "Duchy" : (val >= vic[2][0] ? "Estate" : ""));
    if (vcard.length() == 0)
        cout << tcard;
    else
        cout << vcard << " or " << tcard;
    return 0;
}