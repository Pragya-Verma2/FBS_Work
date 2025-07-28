#include<stdio.h>
int main(){
	float length,width,perimeter;
	
	printf("enter the length of rectengle:");
	scanf("%f",&length);
	
	printf("enter the width of rectengle:");
	scanf("%f",&width);
	
	perimeter = 2*(length+width);
	
	printf("Perimeter of the rectangle = %.2f\n", perimeter);
}