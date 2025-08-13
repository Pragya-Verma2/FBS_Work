#include <stdio.h>

// Function to calculate and print salary details
void calculateSalary(float basic) {
    float da, ta, hra, total;

    if(basic <= 5000) {
        da = basic * 0.10;
        ta = basic * 0.20;
        hra = basic * 0.25;
    } else {
        da = basic * 0.15;
        ta = basic * 0.25;
        hra = basic * 0.30;
    }

    total = basic + da + ta + hra;

    // Output
    printf("DA = %.2f\n", da);
    printf("TA = %.2f\n", ta);
    printf("HRA = %.2f\n", hra);
    printf("Total Salary = %.2f\n", total);
}

int main() {
    float basic;

    printf("Enter your basic salary: ");
    scanf("%f", &basic);

    // Function call with parameter
    calculateSalary(basic);

    return 0;
}
