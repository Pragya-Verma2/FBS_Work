#include<stdio.h>
int main(){
	int num ;
	int fact = 1;
	printf("enter a num:");
	scanf("%d",&num);
	
	int i=num;
	while(i>0){
		fact = fact*i;
		i--;
	}
	    printf("Factorial = %d\n", fact);
}