#include<stdio.h>

void areaOfCircle(float * ,float *);

 void areaOfCircle(float *radius ,float *result){
	float pi=3.14;
    *result=pi*(*radius)*(*radius);
}

int main(){
	float r,area;
	printf("enter radius of circle");
	scanf("%f",&r);
	
	areaOfCircle(&r,&area);
	printf("area of circle:%.2f/n",area);
}
