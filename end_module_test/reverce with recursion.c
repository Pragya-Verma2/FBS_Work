#include <stdio.h>

int reverse(int num) {
    static int rev = 0;   
    if (num > 0) {
        int digit = num % 10;
        rev = rev * 10 + digit;  
        reverse(num / 10);      
    }
    return rev;
}

int main() {
    int num;

    printf("Enter a number: ");
    scanf("%d", &num);

    printf("Reverse of %d is %d\n", num, reverse(num));
    return 0;
}
