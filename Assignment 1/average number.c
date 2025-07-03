#include<stdio.h>
int main(){
	/*int num1 = 10;
	int num2 = 20;
	int num3 = 30;
	int num4 = 40;
	int num5 = 50;
	
	int sum = num1+num2+num3+num4+num5;
	int avg = sum/5;
	
	printf("average of number: %d",avg);*/
	
	int num1,num2,num3,num4,num5;
	int sum;
	int average;
	
	printf("enter five num :\n");
	scanf("%d %d %d %d %d", &num1, &num2, &num3, &num4, &num5);
	
	sum = num1 + num2 + num3 + num4 + num5;
	average = sum/5;
	
	printf("average=%d",average);


}