#include<stdio.h>
char* mystrchar(char*,char);
int main(){
	char str[100],ch;
	
	printf("enter a string:");
	scanf("%s",str);
	
	printf("enter a character to search:");
	scanf(" %c",&ch);
	
    char *result= mystrchar(str,ch);
     if(result!=NULL){
     	printf("Character found at '%d' position:", result-str);
	 }else{
	 		printf("Character '%c'  not found ",ch);
	 }
	
	
}
char* mystrchar(char* str,char ch){
	int i=0;
	while(str[i]!='\0'){
		if(str[i]==ch){
		return &str[i];
	}
	i++;
	}
	return NULL;
		
}