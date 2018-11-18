#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    int g[4];
    int e[4];
    cin >> g[0] >> g[1] >> g[2] >> g[3];
    cin >> e[0] >> e[1] >> e[2] >> e[3];
    int sum1 = g[0] + g[1] + g[2] + g[3];
    int sum2 = e[0] + e[1] + e[2] + e[3];
    cout << (sum1 > sum2 ? "Gunnar" : (sum2 > sum1 ? "Emma" : "Tie"));
    return 0;
}