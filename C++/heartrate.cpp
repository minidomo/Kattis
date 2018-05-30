#include <iostream>

using namespace std;

int main()
{
    int cases;
    scanf("%d", &cases);
    while (cases-- > 0)
    {
        double beats, seconds;
        scanf("%lf %lf", &beats, &seconds);
        double unacc = (60 * beats) / seconds,
               acc = 60 / seconds;
        printf("%lf %lf %lf\n", unacc - acc, unacc, unacc + acc);
    }
    return 0;
}