#include<stdio.h>
int main(){
int arr[100];
int n,x,y;
printf("enter a number:");
scanf("%d",&n);

printf("enter a arr:");
for(int i=0;i<n;i++){
	scanf("%d",&arr[i]);
}	

printf("enter xth position:");
scanf("%d",&x);

printf("enter yth position:");
scanf("%d",&y);

for(int i=0;i<n;i++){
	for(int j=0;j<i;j++)
	if(arr[j]==x && arr[j]==y){
		int temp=x;
		x=y;
		y=temp;
	}
	printf("%d",arr[i]);
}
}