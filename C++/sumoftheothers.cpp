#include <bits/stdc++.h>

using namespace std;

int getInt(string &s) {
    int size = s.size();
    int x = 0;
    char c = s[x++];
    while (!(c >= '0' && c <= '9' || c == '+' || c == '-') && x < size)
        c = s[x++];
    bool neg;
    if ((neg = c == '-') || c == '+')
        c = s[x++];
    int res = 0;
    if (!neg) {
        while (c >= '0' && c <= '9' && x < size) {
            res = res * 10 + (c - '0');
            c = s[x++];
        }
        if (c >= '0' && c <= '9') {
            res = res * 10 + (c - '0');
            if (x < size)
                c = s[x++];
        }
    } else {
        while (c >= '0' && c <= '9' && x < size) {
            res = res * 10 - (c - '0');
            c = s[x++];
        }
        if (c >= '0' && c <= '9') {
            res = res * 10 - (c - '0');
            if (x < size)
                c = s[x++];
        }
    }
    s = s.substr(x, size - x);
    return res;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    string line;
    while (getline(cin, line)) {
        vector<int> arr;
        int total = 0;
        while (line.size() > 0) {
            int a = getInt(line);
            arr.push_back(a);
            total += a;
        }
        for (int x = 0; x < arr.size(); x++)
            if (arr[x] == total - arr[x]) {
                cout << arr[x] << '\n';
                break;
            }
    }
    return 0;
}