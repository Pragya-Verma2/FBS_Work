#include<stdio.h>
 void swap(int*,int*);
int main(){
	int a=10,b=20;
	printf("before a=%d and b=%d",a,b);
	swap(&a,&b);
	printf("after a=%d and b=%d",a,b);
	
}
void swap(int* x,int* y){
	int temp=*x;
	*x=*y;
	*y=temp;
}