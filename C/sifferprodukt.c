#include <stdio.h>

int main() {
    int x;
    scanf("%d", &x);
    while (x >= 10) {
        int temp = x;
        int mul = 1;
        while (temp) {
            int d = temp % 10;
            temp /= 10;
            if (d) mul *= d;
        }
        x = mul;
    }
    printf("%d", x);
    return 0;
}