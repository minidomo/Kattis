#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    int arr[1000001];
    long a = 1;
    for (int x = 1; x <= 1000000; x++) {
        a *= x;
        while (a % 10 == 0)
            a /= 10;
        arr[x] = a % 10;
        a %= 10000000;
    }
    for (;;) {
        int num;
        cin >> num;
        if (num == 0)
            break;
        cout << arr[num] << "\n";
    }
    return 0;
}