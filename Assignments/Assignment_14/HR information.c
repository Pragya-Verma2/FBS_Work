#include <stdio.h>
#include <string.h>

struct HR {
    int id;
    char name[50];
    float salary;
    float commission;
};

int main(){
	struct HR h1,h2;
	
	h1.id = 201;
    strcpy(h1.name, "Rahul");
    h1.salary = 45000;
    h1.commission = 3000;
    
    printf("\nid=%d \nname=%s  \nsalary=%f \ncommission=%f",h1.id,h1.name,h1.salary,h1.commission);
    
     printf("\nEnter HR ID: ");
    scanf("%d", &h2.id);

    printf("Enter HR Name: ");
    scanf("%s", h2.name);

    printf("Enter Salary: ");
    scanf("%f", &h2.salary);

    printf("Enter Commission: ");
    scanf("%f", &h2.commission);
    
    printf("\nid=%d \nname=%s  \nsalary=%f \ncommission=%f",h2.id,h2.name,h2.salary,h2.commission);
}