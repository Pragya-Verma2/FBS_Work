#include<stdio.h>
int main(){
	int arr[5];
	int i ,s1;

	printf("enter a size of arr:");
	scanf("%d",&s1);
	printf("enter  element of arr:");
	for(int i=0;i<s1;i++){
		scanf("%d",&arr[i]);
	}
	
    printf("enter Reverse arr:");
	for(int j=s1;j>i;j--){
		printf("%d ",j);
	}
}