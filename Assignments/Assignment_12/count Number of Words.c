#include<stdio.h>
int main(){
  char str[20];
  int count=0;
  
  printf("enter a string:");
	scanf("%s",str);
	
  int i=0;
  while(str[i]!='\0'){
  	count++;
	  i++;
  }
  printf("%d",count);
}