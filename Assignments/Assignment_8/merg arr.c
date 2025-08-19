#include<stdio.h>
int main(){
	int arr[5];
	int brr[5];
	int merged[10];
	int i, n1,n2;
	
	
	printf("enter size of first arr: ");
	scanf("%d",&n1);
	printf("enter element of first arr:\n");
	for( i=0;i<n1;i++){
		scanf("%d",&arr[i]);
	}
	
	printf("enter size of secount arr: ");
	scanf("%d",&n2);
	printf("enter element of secound arr:\n");
	for( i=0;i<n2;i++){
		scanf("%d",&brr[i]);
	}
	
   for( i=0;i<n1;i++){
   	merged[i]=arr[i];
   }
   
   for(int j=0;j<n2;j++){
   	merged[i]=brr[j];
   	i++;
   }
   
   printf("merged arr:");
   for(int i=0;i<n1+n2;i++){
   	printf("%d",merged[i]);
   }
}