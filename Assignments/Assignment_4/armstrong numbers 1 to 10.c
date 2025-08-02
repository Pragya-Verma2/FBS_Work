#include <stdio.h>

int main() {
    int n, num, temp, digit, count, power, sum, i;

    printf("Enter n: ");
    scanf("%d", &n);

    printf("Armstrong numbers from 1 to %d:\n", n);

   
    for (num = 1; num <= n; num++) {
        temp = num;
        count = 0;
        sum = 0;

        
        for (int x = temp; x > 0; x = x / 10) {
            count++;
        }

        
        for (int x = temp; x > 0; x = x / 10) {
            digit = x % 10;

            power = 1;
            for (i = 1; i <= count; i++) {
                power = power * digit;
            }

            sum = sum + power;
        }

        
        if (sum == num) {
            printf("%d ", num);
        }
    }

    return 0;
}
