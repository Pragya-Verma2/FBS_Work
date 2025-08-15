#include<stdio.h>
float calculateSellingPrice(float ,float );
float calculateSellingPrice(float costPrice,float discount ){
	return costPrice-(costPrice*discount/100);
}

int main(){
	float costPrice,sellingPrice,discount;
	
	printf("enter cost price of the book:");
	scanf("%f",&costPrice);
	
	printf("enter discount percentage:");
	scanf("%f",&discount);
	
	sellingPrice=calculateSellingPrice(costPrice,discount);
	  printf("Selling Price of the book = %.2f\n", sellingPrice);
}