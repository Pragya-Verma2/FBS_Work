#include<stdio.h>

typedef struct{
	char name[50];
	int id;
	char author[50];
	float price;
}book;

int main(){
	book b;
	
	printf("enter book name:");
	scanf("%s",b.name);
	
	printf("enter book id:");
	scanf("%d",&b.id);
	
	printf("enter author name:");
	scanf("%s",b.author);
	
	printf("enter book price:");
	scanf("%f",&b.price);
	
	printf("--------book details---------");
	printf("\nbook name = %s \nbook id = %d \nauthor name = %s \nbook price = %f",b.name,b.id,b.author,b.price);
}