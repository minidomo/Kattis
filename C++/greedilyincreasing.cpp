#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    int n, max = -1, count = 0;
    string s = "";
    cin >> n;
    while (n-- > 0) {
        int a;
        cin >> a;
        if (a > max) {
            max = a;
            s += to_string(a) + " ";
            count++;
        }
    }
    cout << count << '\n' << s;
    return 0;
}