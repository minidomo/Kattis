#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    int cases;
    while (cin >> cases) {
        if (cases == 0)
            break;
        char arr[32];
        memset(arr, '?', sizeof arr);
        while (cases-- > 0) {
            string action;
            cin >> action;
            if (action == "SET") {
                int idx;
                cin >> idx;
                arr[31 - idx] = '1';
            } else if (action == "CLEAR") {
                int idx;
                cin >> idx;
                arr[31 - idx] = '0';
            } else if (action == "OR") {
                int a, b;
                cin >> a >> b;
                a = 31 - a;
                b = 31 - b;
                if (arr[a] == '1' || arr[b] == '1')
                    arr[a] = '1';
                else if (arr[a] == '?' || arr[b] == '?')
                    arr[a] = '?';
            } else {
                int a, b;
                cin >> a >> b;
                a = 31 - a;
                b = 31 - b;
                if (arr[a] == '0' || arr[b] == '0')
                    arr[a] = '0';
                else if (arr[a] == '1' && arr[b] == '1')
                    arr[a] = '1';
                else if (arr[a] == '?' || arr[b] == '?')
                    arr[a] = '?';
            }
        }
        for (char c : arr)
            cout << c;
        cout << '\n';
    }
    return 0;
}