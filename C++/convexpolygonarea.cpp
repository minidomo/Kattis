#include <bits/stdc++.h>

using namespace std;

typedef pair<int, int> pi;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    int cases;
    cin >> cases;
    while (cases-- > 0) {
        int points;
        cin >> points;
        pi arr[points];
        for (int x = 0; x < points; x++)
            cin >> arr[x].first >> arr[x].second;
        double sum = 0;
        for (int x = 0; x < points; x++) {
            sum += arr[x].first * arr[x + 1 == points ? 0 : x + 1].second;
            sum -= arr[x].second * arr[x + 1 == points ? 0 : x + 1].first;
        }
        cout << sum / 2 << '\n';
    }
    return 0;
}