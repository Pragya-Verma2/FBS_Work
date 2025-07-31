#include<stdio.h>
int main(){
	int num;
	int i =2;
	int isPrime=1;
	printf("Enter a number:");
	scanf("%d",&num);
	
	if(i<=1){
		printf("%d is not prime",i);
	}
	while(i<=num/2){
		if(num%i ==0){
			isPrime=0;
	     break;
	}
	i++;
	
}
 if (isPrime == 1)
        printf("%d is prime\n", num);
    else
        printf("%d is not prime\n", num);

}