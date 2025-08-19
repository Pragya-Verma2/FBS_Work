#include <stdio.h>

void printAlternate(int arr[], int n) {
    printf("Alternate elements: ");
    for (int i = 0; i < n; i += 2) {
        printf("%d ", arr[i]);
    }
    printf("\n");
}

int main() {
    int arr[5];
    int n = 5;

    printf("Enter 5 numbers for array: ");
    for (int i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
    }

    printAlternate(arr, n);

    return 0;
}
