#include <stdio.h>
int main() {
    int n;
    int first, last, sum;

    printf("Enter a number: ");
    scanf("%d", &n);  

    last = n % 10;
    printf("Last Digit: %d", last);

    while (n >= 10) {
        n = n / 10;
    }

    first = n;
    printf("\nFirst Digit: %d", first);

    sum = first + last;
    printf("\nSum = %d\n", sum);

    return 0;
}
