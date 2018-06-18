#include <bits/stdc++.h>
#include <algorithm>
#include <vector>

using namespace std;

bool opposite(int a, int b) {
    return a > b;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int cases;
    cin >> cases;
    long total = 0;
    vector<int> arr;
    while (cases-- > 0) {
        int num;
        cin >> num;
        arr.push_back(num);
    }
    sort(arr.begin(), arr.end(), opposite);
    for (int x = 0; x < arr.size(); x++)
        if (x % 3 != 2)
            total += arr[x];
    cout << total;
    return 0;
}