#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    int arr[26] = {2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6,
                   6, 6, 7, 7, 7, 7, 8, 8, 8, 9, 9, 9, 9};
    int n;
    cin >> n;
    string words[n];
    for (int x = 0; x < n; x++)
        cin >> words[x];
    string key;
    cin >> key;
    int count = 0;
    for (int x = 0; x < n; x++) {
        if (words[x].length() != key.length())
            continue;
        string word = words[x];
        bool valid = true;
        for (int a = 0; a < key.length(); a++)
            if (arr[word[a] - 'a'] != key[a] - '0') {
                valid = false;
                break;
            }
        if (valid)
            count++;
    }
    cout << count;
    return 0;
}