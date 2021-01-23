#include <stdio.h>
#include <string.h>

int main() {
    int n;
    char a[10], b[10];
    scanf("%d %s", &n, a);
    int ans = 0;
    for (int i = 0; i < n - 1; i++) {
        scanf("%s", b);
        if (strcmp(a, b) == 0) ans++;
        memcpy(a, b, sizeof(char) * 10);
    }
    printf("%d", ans);
    return 0;
}