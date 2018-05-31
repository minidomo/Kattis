#include <bits/stdc++.h>
#include <algorithm>
#include <cstddef>
#include <string>
#include <vector>

using namespace std;

vector<string> words;

void getWords(string s) {
    size_t i = s.find_first_of('#');
    size_t start = 0;
    if (i != string::npos) {
        while (i != string::npos) {
            string temp = s.substr(start, i - start);
            if (temp.size() > 1)
                words.push_back(temp);
            start = i + 1;
            i = s.find_first_of('#', start);
        }
        if (s.size() - start > 1)
            words.push_back(s.substr(start));
        return;
    }
    words.push_back(s);
}

int main() {
    ios_base::sync_with_stdio(false);
    int rows, cols;
    cin >> rows >> cols;
    vector<string> arr;
    for (int r = 0; r < rows; r++) {
        string s;
        cin >> s;
        arr.push_back(s);
        getWords(s);
    }

    for (int c = 0; c < cols; c++) {
        string s = "";
        for (int r = 0; r < rows; r++)
            s += arr[r][c];
        getWords(s);
    }

    sort(words.begin(), words.end());

    cout << words[0];
    return 0;
}