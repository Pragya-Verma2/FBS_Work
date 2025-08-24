#include <stdio.h>
#include <string.h>  

int main() {
	char str1[]="hello";
	char str2[20];
	
	strcpy(str2,str1);
	printf("%s", str2);   
}