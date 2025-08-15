//#include <stdio.h>
//
//void findAverage(float *avg) {
//    int i;
//    float num, sum = 0;
//
//    printf("Enter 5 numbers:\n");
//    for (i = 1; i <= 5; i++) {
//        printf("Number %d: ", i);
//        scanf("%f", &num);  // directly take input
//        sum += num;         // accumulate sum
//    }
//
//    *avg = sum / 5;  // store result using pointer
//}
//
//int main() {
//    float average;
//
//    findAverage(&average); // pass address to function
//
//    printf("Average = %.2f\n", average);
//
//    return 0;
//}

#include<stdio.h>
void findAverage(float*);
	void findAverage(float *avg){
		float num,sum=0;
		printf("enter a 5 number\n:");
		for(int i=1;i<=5;i++){
			printf("number %d: ",i);
			scanf("%f",&num);
			sum=sum+num;
		}
		*avg=sum/5;
	}

int main(){
	float average;
	findAverage(&average);
	printf("Average = %.2f\n", average);
}