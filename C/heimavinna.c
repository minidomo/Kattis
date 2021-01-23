#include <stdbool.h>
#include <stdio.h>

bool is_num(char c) { return c >= '0' && c <= '9'; }

char read_num(int *a) {
    int cur = 0;
    while (1) {
        char c;
        scanf("%c", &c);
        if (is_num(c)) {
            cur = cur * 10 + c - '0';
        } else {
            *a = cur;
            return c;
        }
    }
}

int main() {
    int ans = 0;
    while (1) {
        int a, b;
        char sep = read_num(&a);
        if (sep == '-') {
            read_num(&b);
            ans += b - a + 1;
        } else if (a != 0) {
            ans++;
        } else {
            break;
        }
    }
    printf("%d", ans);
    return 0;
}