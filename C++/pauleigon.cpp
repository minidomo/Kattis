#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    int swap, pscore, oppscore;
    cin >> swap >> pscore >> oppscore;
    int current = (pscore + oppscore) / swap;
    cout << ((current & 1) == 1 ? "opponent" : "paul");
    return 0;
}