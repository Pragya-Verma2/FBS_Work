#include <stdio.h>
#include <stdlib.h>


int isPrime(int num) {
    if (num <= 1) return 0; 
    for (int i = 2; i * i <= num; i++) {
        if (num % i == 0) {
            return 0; 
        }
    }
    return 1; 
}


void printPrimes(int* arr, int size) {
    printf("Prime numbers in the array: ");
    for (int i = 0; i < size; i++) {
        if (isPrime(arr[i])) {
            printf("%d ", arr[i]);
        }
    }
    printf("\n");
}

int main() {
    int n;

    printf("Enter size of the array: ");
    scanf("%d", &n);


    int* arr = (int*) malloc(n * sizeof(int));

    printf("Enter %d elements: ", n);
    for (int i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
    }

 
    printPrimes(arr, n);

  
}
