#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    string n, m;
    cin >> n >> m;
    if (m == "1")
        cout << n;
    else if (n.size() == m.size()) {
        string front(1, n[0]);
        int x = n.size() - 1;
        while (x > 0 && n[x] == '0')
            x--;
        string back = n.substr(1, x);
        if (back.size() == 0)
            cout << front;
        else
            cout << front + "." + back;
    } else if (n.size() > m.size()) {
        int zeros = m.size() - 1;
        string front = n.substr(0, n.size() - zeros);
        string tempback = n.substr(n.size() - zeros, zeros);
        int x = tempback.size() - 1;
        while (x >= 0 && tempback[x] == '0')
            x--;
        string back = tempback.substr(0, x + 1);
        if (back.size() == 0)
            cout << front;
        else
            cout << front + "." + back;
    } else {
        int zeros = m.size() - n.size() - 1;
        string s = "0.";
        for (int x = 0; x < zeros; x++)
            s += '0';
        int x = n.size() - 1;
        while (x >= 0 && n[x] == '0')
            x--;
        string back = n.substr(0, x + 1);
        cout << s + back;
    }
    return 0;
}