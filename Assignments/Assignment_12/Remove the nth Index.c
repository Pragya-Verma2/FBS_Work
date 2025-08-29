#include<stdio.h>
#include <string.h>
int main(){
	char str[50];
	int n;

	printf("enter a string:");
	scanf("%s",str);
	
	printf("enter index to remove:");
	scanf(" %d",&n);
	
	int size=strlen(str);
	
	if(n < 0 || n >= size) {
        printf("Invalid index!\n");
        return 0;
    }

	
	for(int i=n;i<size;i++){
	   str[i]=str[i+1];
		}
	
    printf("Modified string: %s\n", str);

}