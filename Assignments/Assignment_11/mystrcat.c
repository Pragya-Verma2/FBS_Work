#include<stdio.h>

void mystrcat(char*,char*);
int main(){
	char str1[100],str2[100];
	
	
	printf("enter a string:");
	scanf("%s",str1);
	
	printf("enter a string:");
	scanf("%s",str2);

     mystrcat(str1,str2);
    printf("After concatenation: %s\n", str1);
	
	
}
void mystrcat(char* s1,char* s2){
	int i=0,j=0;
	while(s1[i]!='\0'){
		i++;
	}
	
	while(s2[j]!='\0'){
		s1[i]=s2[j];
		i++;
		j++;
	}
    s1[i]='\0';
}