#include<stdio.h>
int mystrlen(char*);
int main(){
	char str[100];
	
	printf("enter a string:");
	scanf("%s",str);
	
    int len = mystrlen(str);
     printf("%d\n",len);
	
	
}
int mystrlen(char* str){
	int i=0;
	while(str[i]!='\0'){
		i++;
	}
	return i;
		
}