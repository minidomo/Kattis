#include <bits/stdc++.h>
#include <ext/pb_ds/tree_policy.hpp>
#include <ext/pb_ds/assoc_container.hpp>

using namespace std;
using namespace __gnu_pbds;

template <class T> using Tree = tree<T, null_type, less<T>, 
    rb_tree_tag, tree_order_statistics_node_update>; 

struct A {
    int t, s, p;

    friend bool operator<(const A &a, const A &b) {
        if (a.s == b.s) {
            if (a.p == b.p)
                return a.t < b.t;
            return a.p < b.p;
        }
        return b.s < a.s;
    }
};

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    Tree<A> tree;
    int n, m;
    cin >> n >> m;
    vector<A> arr(n);
    for (int x = 0; x < n; x++) {
        arr.push_back({x, 0, 0});
        tree.insert({x, 0, 0});
    }
    while (m--) {
        int t, p;
        cin >> t >> p;
        t--;
        tree.erase({t, arr[t].s, arr[t].p});
        arr[t].s++;
        arr[t].p += p;
        tree.insert({t, arr[t].s, arr[t].p});
        cout << tree.order_of_key(arr[0]) + 1 << '\n';
    }
}
