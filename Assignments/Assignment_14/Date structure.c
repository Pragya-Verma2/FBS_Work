#include <stdio.h>

struct Date {
    int date;
    int month;
    int year;
};
int main(){
	struct Date today,birthday;
	today.date = 25;
    today.month = 8;
    today.year = 2025;
    
     printf("date=%d month=%d year=%d", today.date, today.month, today.year);
     
      printf("\nEnter birthday (date month year): ");
    scanf("%d %d %d", &birthday.date, &birthday.month, &birthday.year);

    printf("date=%d month=%d year=%d", birthday.date, birthday.month, birthday.year);
}