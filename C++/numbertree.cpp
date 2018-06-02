#include <bits/stdc++.h>
#include <math.h>
#include <string>

using namespace std;

int solve(string s, int index, int dist, int num) {
    if (index == s.size())
        return num;
    if ((s[index] == 'L' && (num & 1) == 0) || (s[index] == 'R' && (num & 1) == 1))
        return solve(s, ++index, dist * 2, num - (dist * 2));
    if (s[index] == 'L')
        return solve(s, ++index, dist * 2 - 1, num - (dist * 2 - 1));
    else
        return solve(s, ++index, dist * 2 + 1, num - (dist * 2 + 1));
}

/* 

x = previous distance

         odd
        /   \
     2x-1    2x
      /       \
    even      odd
    
        even
        /   \
      2x    2x+1
      /       \
    even      odd
    
*/

int main() {
    ios_base::sync_with_stdio(false);
    int height;
    string path;
    cin >> height >> path;
    int num = (int)pow(2, height + 1) - 1;
    if (path.size() == 0) {
        cout << num;
        return 0;
    }
    int dist = path[0] == 'L' ? 1 : 2;
    num -= dist;
    cout << solve(path, 1, dist, num);
    return 0;
}