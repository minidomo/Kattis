#include <stdio.h>

int main() {
    int n;
    scanf("%d", &n);
    int nums[n];
    for (int i = 0; i < n; i++) {
        scanf("%d", &nums[i]);
    }
    for (int i = n - 1; i >= 0; i--) {
        printf("%d\n", nums[i]);
    }
    return 0;
}