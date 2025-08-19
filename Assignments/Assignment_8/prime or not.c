#include<stdio.h>
int main(){
	int arr[5];
	
	printf("enter a 5 num of arr:");
	for(int i=0;i<5;i++){
		scanf("%d",&arr[i]);
	}
	
	printf("prime num in arr: ");
	for(int i=0;i<5;i++){
		int isPrime=1;
		
		if(arr[i]<=1){
			isPrime=0;
		}else{
			for(int j=2;j<arr[i];j++){
				if(arr[i]%j==0){
					isPrime=0;
					break;
				}
			}
		}
		if(isPrime){
		printf("%d ",arr[i]);
}
	}
}