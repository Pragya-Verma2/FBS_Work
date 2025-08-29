#include<stdio.h>
void mystrcpy(char* ,char*);
int main(){
	char source[100],destination[100];
	
	printf("enter a string:");
	scanf("%s",source);
	
    mystrcpy(source,destination);
     printf("Copied string: %s\n", destination);
	
	
}
void mystrcpy(char* s,char* d){
	int i=0;
	while(s[i]!='\0'){
		d[i]=s[i];
		i++;
	}
	d[i]='\0';
		
}