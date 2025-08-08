#include<stdio.h>
int main(){
	int sum=0;
	for(int i=1;i<=5;i++){
		if(i%2==1){
			sum=sum+i;
			
		}
	}
	printf("%d",sum);
}