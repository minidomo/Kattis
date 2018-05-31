#include <bits/stdc++.h>

using namespace std;

int gcm(int a, int b)
{
    return b == 0 ? a : gcm(b, a % b);
}

int main()
{
    ios_base::sync_with_stdio(false);
    int cases, first;
    cin >> cases >> first;
    while (cases-- > 1)
    {
        int num;
        cin >> num;
        int div = gcm(first, num);
        cout << first / div << "/" << num / div << "\n";
    }
    return 0;
}