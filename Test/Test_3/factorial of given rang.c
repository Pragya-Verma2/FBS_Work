#include<stdio.h>
int main() {
    for(int num = 10; num <= 15; num++) {
        int fact = 1;
        for(int j = 1; j <= num; j++) {
            fact = fact * j;
        }
        printf("Factorial of %d = %d\n", num, fact);
    }
    return 0;
}
