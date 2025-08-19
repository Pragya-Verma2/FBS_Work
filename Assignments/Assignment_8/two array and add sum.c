#include<stdio.h>
int main(){
	int arr[5];
	int brr[5];
	int crr[5];
	
	printf("enter a 5 num of arr:");
	for(int i=0;i<5;i++){
		scanf("%d",&arr[i]);
	}
	printf("enter a secound  5 num of arr:");
	for(int i=0;i<5;i++){
		scanf("%d",&brr[i]);
	}

   printf("sum of two arr:");
	for(int i=0;i<5;i++){
	  crr[i]=arr[i]+brr[i];
	  printf("%d",crr[i]);
	}
}