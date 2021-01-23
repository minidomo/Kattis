#include <stdio.h>
#include <string.h>

int main() {
    char s[2000];
    scanf("%s", s);
    int ecount = 0;
    int len = strlen(s);
    for (int i = 0; i < len; i++) {
        char c = s[i];
        if (c == 'e') ecount++;
    }
    printf("h");
    for (int i = 0; i < ecount * 2; i++) {
        printf("e");
    }
    printf("y");
    return 0;
}