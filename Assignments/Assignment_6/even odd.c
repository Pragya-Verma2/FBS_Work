# include<stdio.h>
int evenodd(int n);
int main(){
	int num;
	
	printf("enter a number: ");
	scanf("%d",&num);
	
  int res=evenodd(num);
	if(res==1){
		printf("even number");
	}else{
		printf("odd number");
	}
	
}

int evenodd(int n){
	if(n % 2==0){
		return 1;
	}else{
	    return 0;
	}
}

