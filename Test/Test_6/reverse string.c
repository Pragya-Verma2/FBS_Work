#include<stdio.h>
#include<string.h>
int main(){
	char str[40];
	char rev[50];
	
	printf("enter a string:");
	scanf("%s",str);
	
	int len=strlen(str);
	
	int i=0;
	while(str[i]!='\0'){
		rev[i]=str[len-i-1];
		i++;
	}
	printf("%s",rev);
}