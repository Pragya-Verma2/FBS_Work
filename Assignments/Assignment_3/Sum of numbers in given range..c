#include<stdio.h>
int main(){
	int start = 1;
	int end = 5;
	int sum=0;
	
	while(start<=end){
		printf("%d ",start);
		sum = sum+ start;
		start++;
	}
	printf("\n sum =%d",sum);
	
	
	
}