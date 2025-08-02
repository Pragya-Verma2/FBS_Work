#include <stdio.h>

int main() {
    int n, num, temp, digit, fact, i, sum;

    printf("Enter n: ");
    scanf("%d", &n);

    printf("Strong numbers from 1 to %d are:\n", n);

    
    for (num = 1; num <= n; num++) {
        temp = num;
        sum = 0;

  
        while (temp > 0) {
            digit = temp % 10;

            // factorial ???????
            fact = 1;
            for (i = 1; i <= digit; i++) {
                fact = fact * i;
            }

            sum = sum + fact;
            temp = temp / 10;
        }


        if (sum == num) {
            printf("%d ", num);
        }
    }

    return 0;
}
