#include <stdio.h>

int main() {
    int n;
    scanf("%d", &n);
    while (n--) {
        int k;
        scanf("%d", &k);
        int ans = -k + 1;
        while (k--) {
            int o;
            scanf("%d", &o);
            ans += o;
        }
        printf("%d\n", ans);
    }
    return 0;
}