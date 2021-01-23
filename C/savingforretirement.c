#include <stdio.h>

int main() {
    int b, br, bs, a, as;
    scanf("%d %d %d %d %d", &b, &br, &bs, &a, &as);
    int bobmoney = (br - b) * bs;
    int years = (int)(1.0 * bobmoney / as) + 1;
    printf("%d", a + years);
    return 0;
}