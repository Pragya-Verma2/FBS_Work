#include <stdio.h>


int searchElement(int arr[], int size, int num);

int main() {
    int arr[5];
    int num, pos;

    printf("Enter 5 numbers for array:\n");
    for (int i = 0; i < 5; i++) {
        scanf("%d", &arr[i]);
    }

    printf("Enter a number to search: ");
    scanf("%d", &num);

    pos = searchElement(arr, 5, num);

    if (pos != -1) {
        printf("Number %d found at position %d\n", num, pos);
    } else {
        printf("Number %d not found in the array.\n", num);
    }

    return 0;
}


int searchElement(int arr[], int size, int num) {
    for (int i = 0; i < size; i++) {
        if (arr[i] == num) {
            return i;  // position return karega
        }
    }
    return -1;  
}
