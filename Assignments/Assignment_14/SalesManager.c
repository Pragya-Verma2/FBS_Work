#include <stdio.h>
#include <string.h>

struct SalesManager {
    int id;
    char name[50];
    float salary;
    float incentive;
    float target;
};

int main(){
	struct SalesManager sm;
	
	sm.id = 301;
    strcpy(sm.name, "Amit");
    sm.salary = 60000;
    sm.incentive = 10000;
    sm.target = 500000;
    
    printf("\nid=%d \nname=%s  \nsalary=%f \nincentive=%f \ntarget=%f",sm.id,sm.name,sm.salary,sm.incentive,sm.target);
}