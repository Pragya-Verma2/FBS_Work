#include<stdio.h>

int main(){
	char str[50];
    int i=0;

	printf("enter a string:");
	scanf("%s",str);
	
	while(str[i]!='\0'){
		if(str[i]==' '){
			str[i]='&';
		}
		i++;
	}
	printf("%s",str);
}