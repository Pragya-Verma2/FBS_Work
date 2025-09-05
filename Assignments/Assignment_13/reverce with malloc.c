#include <stdio.h>
#include <stdlib.h>

void storeArray(int* arr, int size);
void displayArray(int* arr, int size);
int* reverseArray(int* arr, int size);

int main() {
    int arr[10];

    storeArray(arr, 10);
    printf("Original array: ");
    displayArray(arr, 10);

    int* rev = reverseArray(arr, 10);
    printf("Reversed array: ");
    displayArray(rev, 10);

    free(rev); 
    return 0;
}

void storeArray(int* arr, int size) {
    printf("Enter %d elements: ", size);
    for (int i = 0; i < size; i++) {
        scanf("%d", &arr[i]);
    }
}

void displayArray(int* arr, int size) {
    for (int i = 0; i < size; i++) {
        printf("%d ", arr[i]); 
    }
    printf("\n");
}

int* reverseArray(int* arr, int size) {
    int* rev = (int*) malloc(sizeof(int) * size);
    if (rev == NULL) {
        printf("Memory allocation failed!\n");
        exit(1);
    }

    for (int i = 0; i < size; i++) {
        rev[i] = arr[size - i - 1];
    }
    return rev;
    free(rev);
}
