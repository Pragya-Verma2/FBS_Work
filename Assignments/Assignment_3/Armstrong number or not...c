#include <stdio.h>

int main() {
    int n = 153, original, remainder;
    int sum = 0;

    original = n;

  
    while (n != 0) {
        remainder = n % 10;
        sum += remainder * remainder * remainder; // cube of the digit
        n = n / 10;
    }

    
    if (sum == original) {
        printf("Armstrong\n");
    } else {
        printf("Not Armstrong\n");
    }

    return 0;
}
