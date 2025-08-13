#include<stdio.h>
int prime(int num);
int main(){
	int num;
//	int i =2;
//	int isPrime=1;
	printf("Enter a number:");
	scanf("%d",&num);
	prime(num);
	if(return==1){
		printf("num is prime");
	}else{
		printf("num is not prime");
	}
}
	


int prime(int num){
	int i =2;
	int isPrime=1;
//	if(i<=1){
//		printf("%d is not function"); 
//	}
	while(i<=num/2){
		if(num%i ==0){
			isPrime=0;
	     break;
	}
	i++;
}
if (isPrime == 1)
        return 1;
    else
        return 0;

}

