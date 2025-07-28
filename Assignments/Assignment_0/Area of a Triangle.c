#include <stdio.h>

int main() {
    float base, height, area;

    // Take input from user
    printf("Enter the base of the triangle: ");
    scanf("%f", &base);

    printf("Enter the height of the triangle: ");
    scanf("%f", &height);

    // Calculate area
    area = 0.5 * base * height;

    // Output the result
    printf("Area of the triangle = %.2f\n", area);

    return 0;
}