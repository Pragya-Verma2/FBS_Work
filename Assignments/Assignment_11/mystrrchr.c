#include<stdio.h>
#include<string.h>
char* mystrrchar(char*,char);
int main(){
	char str[100],ch;
	
	printf("enter a string:");
	scanf("%s",str);
	
	printf("enter a character to search:");
	scanf(" %c",&ch);
	
	
    char *result= mystrrchar(str,ch);
      if(result!=NULL){
     	printf("Character found at '%d' position:", result-str);
	 }else{
	 		printf("Character '%c'  not found ",ch);
	 }
	
	
}
char* mystrrchar(char* str,char ch){
	int length=strlen(str);
	int i=length-1;
	while(str[i]!='\0'){
		if(str[i]==ch){
		return &str[i];
	}
	i--;
	}
	return NULL;
		
}