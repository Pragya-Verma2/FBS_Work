#include<stdio.h>
int main(){
	int arr[5];
	
	printf("enter a 5 num of arr:");
	for(int i=0;i<5;i++){
		scanf("%d",&arr[i]);
	}
	
	printf("Alternate elements: ");
	for(int i=0;i<5;i+=2){
		printf("%d ",arr[i]);
	}
	
}
	