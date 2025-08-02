#include <stdio.h>

int main() {
    int n, num, i, isPrime;

    printf("Enter n: ");
    scanf("%d", &n);

    printf("Prime numbers from 1 to %d:\n", n);

    for (num = 2; num <= n; num++) {
        isPrime = 1;  

        for (i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                isPrime = 0; 
                break;
            }
        }

        if (isPrime == 1) {
            printf("%d ", num);
        }
    }

    return 0;
}
