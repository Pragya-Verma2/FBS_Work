#include<stdio.h>
#include<string.h>

struct student{
		int rollno;
		char name[20];
		int marks;
	};
	
int main(){
	struct student s1,s2;
	
	s1.rollno=10;
	strcpy(s1.name,"pragya");
	s1.marks=98;
	
	printf("student s1 information");
	printf("\nrollno=%d \nname=%s  \nmarks=%d",s1.rollno,s1.name,s1.marks);
	printf("\n");
	
	printf("\nenter rollno:");
	scanf("%d",&s2.rollno);
	
	printf("enter name:");
	scanf("%s",s2.name);
	
	printf("enter marks:");
	scanf("%d",&s2.marks);
	
//	printf("student s1 information");
	printf("\nrollno=%d name=%s marks=%d",s2.rollno,s2.name,s2.marks);
}