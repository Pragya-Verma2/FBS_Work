#include<stdio.h>
int main(){
	int arr[5];
	int brr[5];
	
	
	printf("enter a arr:");
	for(int i=0;i<5;i++){
		scanf("%d",&arr[i]);
	}
	
	int max=arr[0];
	int secmax=arr[0];
	for(int i=0;i<5;i++){
		if(arr[i]>arr[i+1]){
			max=arr[i];
		}
		if(arr[i]>max){
		secmax=arr[i];
		}
	}
	printf("max=%d",max);
	printf("\nsecoundMax=%d",secmax);

}
	
	
	
	