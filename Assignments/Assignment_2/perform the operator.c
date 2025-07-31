#include <stdio.h>

int main() {
    int num1, num2;
    char op;

    
    printf("Enter first number: ");
    scanf("%d", &num1);

    printf("Enter second number: ");
    scanf("%d", &num2);

    
    printf("Enter operator (+, -, *, /, %%): ");
    scanf(" %c", &op);  

   
    if (op == '+') {
        printf("Result: %d\n", num1 + num2);
    } else if (op == '-') {
        printf("Result: %d\n", num1 - num2);
    } else if (op == '*') {
        printf("Result: %d\n", num1 * num2);
    } else if (op == '/') {
        if (num2 != 0) {
            printf("Result: %d\n", num1 / num2);
        } else {
            printf(" Division by zero not allowed!\n");
        }
    } else if (op == '%') {
        if (num2 != 0) {
            printf("Result %d\n", num1 % num2);
        } else {
            printf(" Modulus by zero not allowed!\n");
        }
    } else {
        printf("Invalid operator!\n");
    }

    return 0;
}
