#include<stdio.h>
int main(){
	int hours=1, minutes = 20 ,seconds =15 ,totalSeconds;
	
	totalSeconds= (hours * 3600)+(minutes * 60) + seconds;
	printf("Total Seconds: %d",totalSeconds);
	
	
}