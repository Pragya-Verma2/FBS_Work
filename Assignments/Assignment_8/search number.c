#include<stdio.h>
int main(){
	int arr[5];
	int num,found=0;
	
	printf("enter a 5 num of arr:");
	for(int i=0;i<5;i++){
		scanf("%d",&arr[i]);
	}
	
	printf("enter a search number:");
	scanf("%d",&num);
	
	for(int i=0;i<5;i++){
		if(arr[i]==num){
			printf("number %d found at position %d",num,i);
			found=1;
			break;
		}
	}
	
	if (!found) {
        printf("Number %d not found in the array.\n", num);
    }

	
}
	
	