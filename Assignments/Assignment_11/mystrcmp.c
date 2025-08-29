#include<stdio.h>

int mystrcmp(char*,char*);
int main(){
	char str1[100],str2[100];
	
	
	printf("enter a string:");
	scanf("%s",str1);
	
	printf("enter a string:");
	scanf("%s",str2);
	
    int result= mystrcmp(str1,str2);
     if (result == 0)
        printf("Strings are equal.\n");
    else if (result > 0)
        printf("First string is greater.\n");
    else
        printf("Second string is greater.\n");
	
	
}
int mystrcmp(char* s1,char* s2){
	int i=0;
	while(s1[i]!='\0'&&s2[i]!='\0'){
		if(s1[i]!=s2[i]){
			return s1[i]-s2[i];
		}
		i++;
	}
		return s1[i]-s2[i];	
}