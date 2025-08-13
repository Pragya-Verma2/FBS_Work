int main(){
	int a=20,b=10;
	addition(a+b,a,b);
	multiplication(30*b,a*b);
}

addition(int a,int b,int sum){
	printf("sum=%d,a=%d,b=%d",a,b,sum);
}

multiplication(int x,int y){
	printf("\nmultiplication:30*b=%d, a*b=%d",x,y);
}