class admin{
int id;
String name;
double salary;
double allowance;

void setId(int i){
  this.id=i;
}
void setName(String n){
  this.name=n;
}
void setSalary(double s){
   this.salary=s;
}
void setAllowance(double a){
  this.allowance=a;
}
}

class TestAdmin{
public static void main(String[] args){
  admin a1;
   a1=new admin();
   a1.setId(1);
   a1.setName("pragya");
   a1.setSalary(20000);
   a1.setAllowance(500.00);

   System.out.println("Id:" + a1.id );
   System.out.println("Name:" + a1.name );
   System.out.println("Salary:" + a1.salary );
   System.out.println("Allowance:" + a1.allowance );
}
}
