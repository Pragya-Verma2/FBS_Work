#include<stdio.h>
int main(){
	int num = 121;
	
	int firstDigit = num / 100;
	int secondDigit = num % 10;
	
	if( firstDigit == secondDigit){
		printf("%d num is palindrome",num );
	}else{
		printf("%d is not palindrome",num);
	}
}