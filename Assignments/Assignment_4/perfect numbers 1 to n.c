#include <stdio.h>

int main() {
    int n, num, i, sum;

    printf("Enter n: ");
    scanf("%d", &n);

    printf("Perfect numbers from 1 to %d:\n", n);

     for (num = 1; num <= n; num++) {
        sum = 0;

       
        for (i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                sum = sum + i;
            }
        }

        if (sum == num) {
            printf("%d ", num);
        }
    }

    return 0;
}
