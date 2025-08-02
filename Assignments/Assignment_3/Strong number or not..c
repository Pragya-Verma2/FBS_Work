#include <stdio.h>

int main() {
    int n = 145, original, digit;
    int sum = 0, fact, i;

    original = n;

    // Extract each digit
    while (n != 0) {
        digit = n % 10;

      
        fact = 1;
        i = 1;
        while (i <= digit) {
            fact=fact*i;
            i++;
        }

        sum =sum+ fact;
        n = n / 10;
    }

    // Check if Strong number
    if (sum == original) {
        printf("Strong\n");
    } else {
        printf("Not Strong\n");
    }

    return 0;
}
