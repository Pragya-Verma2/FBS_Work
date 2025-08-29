#include<stdio.h>
int main(){
	char str[20];
	
	printf("enter a string:");
	scanf("%s",str);
	
	int n=strlen(str);

	char temp=str[0];
	str[0]=str[n-1];
	str[n-1]=temp;
	
	printf("%s",str);
}