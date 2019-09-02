#include <bits/stdc++.h>

using namespace std;

int bottles(int has, int needs, int count, int extra) {
    if (has == 0)
        return count;
    int a = (has + extra) / needs;
    return bottles(a, needs, a + count, (has + extra) % needs);
}

int main() {
    ios_base::sync_with_stdio(false);
    int start, found, require;
    cin >> start >> found >> require;
    cout << bottles(start + found, require, 0, 0);
    return 0;
}