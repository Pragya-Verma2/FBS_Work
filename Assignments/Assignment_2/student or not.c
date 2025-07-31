#include <stdio.h>

int main() {
    float price, discount = 0.0;
    char student;

   
    printf("Enter the price: ");
    scanf("%f", &price);

    printf("Are you a student? (y/n): ");
    scanf(" %c", &student); 

    
    if (student == 'y' || student == 'Y') {
        if (price > 500) {
            discount = price * 0.20;
        } else {
            discount = price * 0.10;
        }
    } else {
        if (price > 600) {
            discount = price * 0.15;
        } else {
            discount = 0.0;
        }
    }


    printf("Discount: %.2f\n", discount);
    printf("Final Price after discount: %.2f\n", price - discount);

    return 0;
}
