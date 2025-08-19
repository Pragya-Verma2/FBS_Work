#include<stdio.h>


void mergeArrays(int arr[], int n1, int brr[], int n2, int merged[]) {
    int i, j, k=0;

    for(i=0; i<n1; i++) {
        merged[k++] = arr[i];
    }

    for(j=0; j<n2; j++) {
        merged[k++] = brr[j];
    }
}

int main() {
    int arr[10], brr[10], merged[20];
    int n1, n2;

    printf("Enter size of first array: ");
    scanf("%d", &n1);

    printf("Enter elements of first array:\n");
    for(int i=0; i<n1; i++) {
        scanf("%d", &arr[i]);
    }

    printf("Enter size of second array: ");
    scanf("%d", &n2);

    printf("Enter elements of second array:\n");
    for(int i=0; i<n2; i++) {
        scanf("%d", &brr[i]);
    }

    // Function call
    mergeArrays(arr, n1, brr, n2, merged);

    printf("Merged Array: ");
    for(int i=0; i<n1+n2; i++) {
        printf("%d ", merged[i]);
    }

    return 0;
}
