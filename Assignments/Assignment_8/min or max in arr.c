#include<stdio.h>
int main(){
	int arr[5];
	
	int min,max;
	
	printf("enter a 5 num of arr:");
	for(int i=0;i<5;i++){
		scanf("%d",&arr[i]);
	}
	 min=arr[0];
	 max=arr[0];
	
	for(int i=0;i<5;i++){
		if(arr[i]<min){
			min=arr[i];
		}
	   if(arr[i]>max){
	   	max=arr[i];
	   }	
	}
	
	printf("Minimum number = %d\n", min);
    printf("Maximum number = %d\n", max);
	
}