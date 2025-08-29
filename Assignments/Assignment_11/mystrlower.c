#include<stdio.h>
void mystrlower(char*);
int main(){
	char str[100];
	
	printf("enter a string:");
	scanf("%s",str);
	
     mystrlower(str);
     printf("Lowercase string: %s\n", str);
	
	
}
void mystrlower(char* str){
	int i=0;
	while(str[i]!='\0'){
		if(str[i]>='A'&&str[i]<='Z'){
		str[i]=str[i]+32;
	}
	i++;
	}
	return i;
		
}