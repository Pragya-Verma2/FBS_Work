#include <stdio.h>
#include <stdlib.h>


void mergeArrays(int* arr1, int n1, int* arr2, int n2, int* merged) {
    int k = 0;
    for(int i = 0; i < n1; i++) {
        merged[k++] = arr1[i];
    }
    for(int i = 0; i < n2; i++) {
        merged[k++] = arr2[i];
    }
}

int main() {
    int n1, n2;

  
    printf("Enter size of first array: ");
    scanf("%d", &n1);
    printf("Enter size of second array: ");
    scanf("%d", &n2);

   
    int* arr1 = (int*) malloc(n1 * sizeof(int));
    int* arr2 = (int*) malloc(n2 * sizeof(int));
    int* merged = (int*) malloc((n1 + n2) * sizeof(int));

//    if(arr1 == NULL || arr2 == NULL || merged == NULL) {
//        printf("Memory allocation failed!\n");
//        return 1;
//    }

  
    printf("Enter elements of first array:\n");
    for(int i = 0; i < n1; i++) {
        scanf("%d", &arr1[i]);
    }

    printf("Enter elements of second array:\n");
    for(int i = 0; i < n2; i++) {
        scanf("%d", &arr2[i]);
    }

    mergeArrays(arr1, n1, arr2, n2, merged);

   
    printf("Merged Array: ");
    for(int i = 0; i < n1 + n2; i++) {
        printf("%d ", merged[i]);
    }
    printf("\n");


    return 0;
}
