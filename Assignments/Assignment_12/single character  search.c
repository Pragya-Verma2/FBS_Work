#include<stdio.h>
int main(){
	char str[50], ch;
	int found=0;

	printf("enter a string:");
	scanf("%s",str);
	
	printf("enter a single character:");
	scanf("%c",&ch);
	
	int size=strlen(str);
	
	for(int i=0;i<size;i++){
		if(str[i]==ch){
			printf("character %c found at position:%d",ch,i);
			found=1;
		}
	}
	if(!found){
		 printf("Character '%c' not found in the string.\n", ch);
	}
}