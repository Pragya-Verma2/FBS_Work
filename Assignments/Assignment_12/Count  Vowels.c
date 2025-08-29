#include<stdio.h>
int main(){
	char str[30];
	
	printf("enter a string:");
	scanf("%s",str);
	
	int i=0;
	int count=0;
	while(str[i]!='\0'){
		int ch=str[i];
		if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
			count++;
		}
		i++;
	}
	printf("Number of Vowels:%d",count);
	
}