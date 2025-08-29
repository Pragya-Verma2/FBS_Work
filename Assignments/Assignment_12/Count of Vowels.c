#include<stdio.h>

int main(){
	char str[50];
    int i=0,count=0;

	printf("enter a string:");
	scanf("%s",str);
	
	while(str[i]!='\0'){
		char ch=str[i];
		if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'||
		ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U'){
			count++;
		}
		i++;
	}
	printf("%d",count);
}