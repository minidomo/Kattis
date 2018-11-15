#include <bits/stdc++.h>

using namespace std;

bool pass(int n) {
    int sub = n;
    int arr[10];
    memset(arr, 0, sizeof(arr));
    while (sub > 0) {
        int dig = sub % 10;
        if (dig == 0)
            return false;
        if (arr[dig] > 0)
            return false;
        if (n % dig != 0)
            return false;
        arr[dig]++;
        sub /= 10;
    }
    return true;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    int lb, ub, count = 0;
    cin >> lb >> ub;
    for (int x = lb; x <= ub; x++)
        if (pass(x))
            count++;
    cout << count;
    return 0;
}