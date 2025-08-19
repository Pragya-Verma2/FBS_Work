#include<stdio.h>
int main(){
	int arr[5];
	int num,sum=0;
	
	printf("enter a 5 num of arr:");
	for(int i=0;i<5;i++){
		scanf("%d",&arr[i]);
	}
	
	for(int i=0;i<5;i++){
	  if(arr[i]%2==0){
	  	printf("even number:%d\n",arr[i]);
	  }
	  if(arr[i]%2 !=0){
	  	printf("odd number:%d\n",arr[i]);
	  }
	}
}