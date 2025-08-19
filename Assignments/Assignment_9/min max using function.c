#include <stdio.h>

int findMin(int arr[], int n) {
    int min = arr[0];
    for (int i = 1; i < n; i++) {
        if (arr[i] < min) {
            min = arr[i];
        }
    }
    return min;
}

int findMax(int arr[], int n) {
    int max = arr[0];
    for (int i = 1; i < n; i++) {
        if (arr[i] > max) {
            max = arr[i];
        }
    }
    return max;
}

int main() {
    int arr[5];
    int n = 5;
    
    printf("Enter 5 numbers for array: ");
    for (int i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
    }
    
    int min = findMin(arr, n);
    int max = findMax(arr, n);
    
    printf("Minimum number = %d\n", min);
    printf("Maximum number = %d\n", max);
    
    return 0;
}
