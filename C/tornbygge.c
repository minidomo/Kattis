#include <stdio.h>

int main() {
    int n;
    scanf("%d", &n);
    int prev, cur;
    scanf("%d", &prev);
    int ans = 1;
    for (int i = 0; i < n - 1; i++) {
        scanf("%d", &cur);
        if (cur > prev) ans++;
        prev = cur;
    }
    printf("%d", ans);
    return 0;
}