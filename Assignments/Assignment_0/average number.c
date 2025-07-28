#include<stdio.h>
int main(){
	
	int num1,num2,num3,num4,num5;
	int sum;
	int average;
	
	printf("enter five num :\n");
	scanf("%d %d %d %d %d", &num1, &num2, &num3, &num4, &num5);
	
	sum = num1 + num2 + num3 + num4 + num5;
	average = sum/5;
	
	printf("average=%d",average);


}