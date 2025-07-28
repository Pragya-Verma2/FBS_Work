#include <stdio.h>

int main() {
    float radius = 5.0;  
    float pi = 3.14;
    float area;

    area = pi * radius * radius;

    printf("Radius = %.2f\n", radius);
    printf("Area of the circle = %.2f\n", area);

    return 0;
}
