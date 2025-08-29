#include<stdio.h>

int mystrncmp(char*,char*,int);
int main(){
	char str1[100],str2[100];
	int n;
	
	printf("enter a string:");
	scanf("%s",str1);
	
	printf("enter a string:");
	scanf("%s",str2);
	
    printf("Enter number of characters to compare: ");
    scanf("%d", &n);

	
    int result= mystrncmp(str1,str2,n);
     printf("%d",result);
	
	
}
int mystrncmp(char* s1,char* s2,int n){
	int i=0;
	while(i<n){
		if(s1[i]!=s2[i]){
			if(s1[i]>s2[i]){
				return 1;
			}else{
				return -1;
			}
		}
		i++;
	}
		return 0;	
}