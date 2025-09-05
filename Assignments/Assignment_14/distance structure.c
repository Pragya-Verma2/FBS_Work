#include <stdio.h>

struct Distance {
    int feet;
    float inch;
};

int main() {
    struct Distance d1, d2;

    d1.feet = 5;
    d1.inch = 8.5;

    printf("Distance 1: %d feet %.2f inch\n", d1.feet, d1.inch);


    printf("Enter distance 2 (feet inch): ");
    scanf("%d %f", &d2.feet, &d2.inch);

    printf("Distance 2: %d feet %.2f inch\n", d2.feet, d2.inch);

    return 0;
}
