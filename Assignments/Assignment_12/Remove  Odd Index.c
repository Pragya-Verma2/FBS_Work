#include<stdio.h>
int main(){
	char str[20];
	char newstr[100];
	
	printf("enter a string:");
	scanf("%s",str);
	
	int i=0;
	int j=0;

	while(str[i]!='\0'){
		if(i%2!=0){
		 newstr[j]=str[i];
          j++;
		}
		i++;
	}
  newstr[j]='\0';
	printf("%s",newstr);
}