#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    for (int sweet, sour; cin >> sweet >> sour;) {
        if (sweet == 0 && sour == 0)
            break;
        if (sour + sweet == 13)
            cout << "Never speak again."
                 << "\n";
        else if (sour > sweet)
            cout << "Left beehind."
                 << "\n";
        else if (sweet > sour)
            cout << "To the convention."
                 << "\n";
        else
            cout << "Undecided."
                 << "\n";
    }
    return 0;
}