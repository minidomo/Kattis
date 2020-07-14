#include <bits/stdc++.h>

using namespace std;

void getLPS(int arr[], int size, string a) {
    arr[0] = 0;
    int x = 1, len = 0;
    while (x < size) {
        if (a[x] == a[len]) {
            arr[x++] = ++len;
        } else {
            if (len)
                len = arr[len - 1];
            else
                arr[x++] = len;
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    while (cin) {
        string a, b;
        getline(cin, b);
        getline(cin, a);
        int lps[b.size()];
        getLPS(lps, b.size(), b);
        int i = 0, j = 0;
        while (i < a.size()) {
            if (a[i] == b[j])
                i++, j++;
            if (j == b.size()) {
                cout << i - j << ' ';
                j = lps[j - 1];
            } else if (i < a.size() && a[i] != b[j]) {
                if (j)
                    j = lps[j - 1];
                else
                    i++;
            }
        }
        cout << '\n';
    }
    return 0;
}