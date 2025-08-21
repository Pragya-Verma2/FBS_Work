#include<stdio.h>
int main(){
	int arr[5];
	int brr[5];
	
	
	printf("enter a arr:");
	for(int i=0;i<5;i++){
		scanf("%d",&arr[i]);
	}
	
	printf("enter a arr:");
	for(int i=0;i<5;i++){
		scanf("%d",&brr[i]);
	}
	
	for(int i=0;i<5;i++){
		for(int j=0;j<5;j++)
		if(arr[i]==brr[j]){
			printf("%d",arr[i]);
			break;
		}
	}
	
}