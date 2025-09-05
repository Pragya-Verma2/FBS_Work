#include<stdio.h>

typedef struct{
	int hrs;
	int min;
	int sec;
	
}time;

void acceptTime(time *t){
	printf("enter houres:");
	scanf("%d",&t->hrs);
	
	printf("enter minutes:");
	scanf("%d",&t->min);
	
	printf("enter secound:");
	scanf("%d",&t->sec);
}

void displayTime(time t){
	printf("%d:%d:%d",t.hrs,t.min,t.sec);
}

time addTime(time t1,time t2){
	time result;
	
	result.sec=t1.sec+t2.sec;
	result.min=t1.min+t2.min+(result.sec/60);
	result.sec=result.sec%60;
	
	result.hrs=t1.hrs+t2.hrs+(result.min/60);
	result.min=result.min%60;
	
	return result;
}

int convertToSecound(time t){
	return (t.hrs*3600)+(t.min*60)+t.sec;
}

int main(){
	time t1,t2,sum;
	
	printf("enter first time\n");
	acceptTime(&t1);
	
	printf("enter secound time\n");
	acceptTime(&t2);
	
	printf("\nfirst Time:");
	displayTime(t1);
	
	printf("\nsecound Time:");
	displayTime(t2);
	
	sum=addTime(t1,t2);
	
	printf("\nsum times:");
	displayTime(sum);
	
	printf("\nfirst time in secounds:%d",convertToSecound(t1));
	
}