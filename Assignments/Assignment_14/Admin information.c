#include<stdio.h>
#include<string.h>
 struct admin{
 	int id;
	char name[50];
	float salary;
	 float allowance;
 };
 
int main(){
	struct admin a1,a2;
	
	a1.id=101;
	strcpy(a1.name,"pragya");
	a1.salary=40000;
	a1.allowance=5000;
	

	printf("\nid=%d \nname=%s  \nsalary=%f \nallowance=%f",a1.id,a1.name,a1.salary,a1.allowance);
	printf("\n");
	
	printf("\nenter id:");
	scanf("%d",&a2.id);
	
	printf("enter name:");
	scanf("%s",a2.name);
	
	printf("Enter Salary: ");
    scanf("%f", &a2.salary);

    printf("Enter Allowance: ");
    scanf("%f", &a2.allowance);
	
	printf("\nid=%d \nname=%s  \nsalary=%f \nallowance=%f",a2.id,a2.name,a2.salary,a2.allowance);
}