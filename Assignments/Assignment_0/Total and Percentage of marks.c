#include <stdio.h>

int main() {
    int m1, m2, m3, m4, m5, total;
    float percentage;

    // Input marks of 5 subjects
    printf("Enter marks of Subject 1: ");
    scanf("%d", &m1);

    printf("Enter marks of Subject 2: ");
    scanf("%d", &m2);

    printf("Enter marks of Subject 3: ");
    scanf("%d", &m3);

    printf("Enter marks of Subject 4: ");
    scanf("%d", &m4);

    printf("Enter marks of Subject 5: ");
    scanf("%d", &m5);

    // Calculate total
    total = m1 + m2 + m3 + m4 + m5;

    // Calculate percentage
    percentage = (total / 5.0);  // dividing by 5.0 to get float result

    // Output results
    printf("Total Marks = %d\n", total);
    printf("Percentage = %.2f%%\n", percentage);

    return 0;
}