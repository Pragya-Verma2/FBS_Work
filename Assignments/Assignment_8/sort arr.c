#include<stdio.h>

int main(){
    int arr[50], n, i, j, temp;

    printf("Enter size of array: ");
    scanf("%d", &n);

    printf("Enter %d elements:\n", n);
    for(i = 0; i < n; i++){
        scanf("%d", &arr[i]);
    }
    
    //sorting
    for(i=0;i<n-1;i++){
    	for(j=1;j<n;j++){
    		if(arr[i]>arr[j]){
    			temp=arr[i];
    			arr[i]=arr[j];
    			arr[j]=temp;
			}
		}
	}
	
	printf("sorting arr: ");
	for(i=0;i<n;i++){
		printf("%d ", arr[i]);
	}
}