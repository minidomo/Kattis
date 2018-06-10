#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int nums;
    for (int a = 1; cin >> nums; a++) {
        int min = 1000001, max = -1000001;
        for (int x = 0; x < nums; x++) {
            int num;
            cin >> num;
            if (num < min)
                min = num;
            if (num > max)
                max = num;
        }
        cout << "Case " << a << ": " << min << " " << max << " " << max - min << "\n";
    }
    return 0;
}