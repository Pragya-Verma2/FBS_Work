#include<stdio.h>
int main(){
	int arr[5];
	int num,sum=0;
	
	printf("enter a 5 num of arr:");
	for(int i=0;i<5;i++){
		scanf("%d",&arr[i]);
	}
	
	for(int i=0;i<5;i++){
		sum=sum+arr[i];
	}
	printf("sum=%d",sum);
	
}
	