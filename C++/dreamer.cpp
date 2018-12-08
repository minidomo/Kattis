#include <bits/stdc++.h>

using namespace std;

bool isLeapYear(int a) {
    if (a % 4 != 0)
        return false;
    if (a % 400 == 0)
        return true;
    if (a % 100 == 0)
        return false;
    return true;
}

bool isValidDate(int day, int month, int year) {
    if (day == 0 || day > 31 || month == 0 || month > 12 || year < 2000)
        return false;
    switch (month) {
    case 1:
    case 3:
    case 5:
    case 7:
    case 8:
    case 10:
    case 12:
        return day <= 31;
    case 4:
    case 6:
    case 9:
    case 11:
        return day <= 30;
    case 2:
        return day <= (isLeapYear(year) ? 29 : 28);
    default:
        return false;
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    int cases;
    cin >> cases;
    while (cases-- > 0) {
        int digits[8];
        int i = 0;
        for (int x = 0, n = 0; x < 3; x++) {
            cin >> n;
            while (n > 0) {
                digits[i++] = n % 10;
                n /= 10;
            }
        }
        while (i < 8)
            digits[i++] = 0;
        sort(digits, digits + 8);
        int day = digits[0] * 10 + digits[1];
        int month = digits[2] * 10 + digits[3];
        int year =
            digits[4] * 1000 + digits[5] * 100 + digits[6] * 10 + digits[7];
        int count;
        if (!isValidDate(day, month, year)) {
            day = month = year = 10000;
            count = 0;
        } else
            count = 1;
        while (next_permutation(digits, digits + 8)) {
            int d = digits[0] * 10 + digits[1];
            int m = digits[2] * 10 + digits[3];
            int y =
                digits[4] * 1000 + digits[5] * 100 + digits[6] * 10 + digits[7];
            if (!isValidDate(d, m, y))
                continue;
            count++;
            if (y == year) {
                if (m == month) {
                    if (d < day)
                        day = d;
                } else if (m < month) {
                    day = d;
                    month = m;
                }
            } else if (y < year) {
                day = d;
                month = m;
                year = y;
            }
        }
        if (count == 0)
            printf("0\n");
        else
            printf("%d %02d %02d %d\n", count, day, month, year);
    }
    return 0;
}