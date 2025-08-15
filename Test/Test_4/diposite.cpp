#include<stdio.h>
float balence=5000.0;

void deposite(float);
void withdraw(float);

void deposite(float amount){
   balence=balence+amount;
  printf("deposite successful!\nupdated balence:%.2f\n",balence);	
}

void withdraw(float amount){
	
	if(balence-amount<3000){
		printf("cant withdraw amount.balence not sufficient");
	}else{
     balence=balence-amount;
     printf("withdraw successful!\nupdated balence:%.2f\n",balence);
 }

	
}

int main(){
	int choice;
	float amount;
	
	printf("initial balence %.2f\n",balence);
	printf("1.deposite\n 2.withdraw\nEnter your choice: ");
	scanf("%d",&choice);
	
	if(choice==1){
		printf("Enter your deposite amount:");
		scanf("%f",&amount);
		deposite(amount);
	}else if(choice==2){
		printf("Enter your withdraw amount:");
		scanf("%f",&amount);
		withdraw(amount);
	}else{
		printf("invalide choice ");
	}
	
	
}