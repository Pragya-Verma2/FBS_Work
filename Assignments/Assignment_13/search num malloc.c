#include <stdio.h>
#include <stdlib.h>

int searchElement(int* arr, int size, int num);

int main() {
    int n, num, pos;

    printf("Enter size of array: ");
    scanf("%d", &n);

    // Allocate memory dynamically
    int* arr = (int*) malloc(n * sizeof(int));
    if (arr == NULL) {
        printf("Memory allocation failed!\n");
        return 1;
    }

    printf("Enter %d numbers for array:\n", n);
    for (int i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
    }

    printf("Enter a number to search: ");
    scanf("%d", &num);

    pos = searchElement(arr, n, num);

    if (pos != -1) {
        printf("Number %d found at position %d\n", num, pos);
    } else {
        printf("Number %d not found in the array.\n", num);
    }

    free(arr);  // Free allocated memory
    return 0;
}

int searchElement(int* arr, int size, int num) {
    for (int i = 0; i < size; i++) {
        if (arr[i] == num) {
            return i;  // Return index if found
        }
    }
    return -1;  // Not found
}
