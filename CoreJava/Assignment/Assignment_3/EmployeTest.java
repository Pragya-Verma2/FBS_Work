package FirstBit;

//Base class
class Employee {
int id;
String name;
String department;
double salary;
String position;

Employee() {
	   this.id = 0;
	   this.name = "not assign";
	   this.department = "not";
	   this.salary = 4000;
	   this.position = "not";
	}

// Constructor
Employee(int id, String name, String department, double salary, String position) {
   this.id = id;
   this.name = name;
   this.department = department;
   this.salary = salary;
   this.position = position;
}

// Display info method
void display() {
   System.out.println("Employee ID: " + id);
   System.out.println("Name: " + name);
   System.out.println("Department: " + department);
   System.out.println("Position: " + position);
   System.out.println("Salary: $" + salary);
}
}

//Subclass 1: Manager
class Manager extends Employee {
int teamSize;

Manager() {
	   super(); // Call parent constructor
	   this.teamSize = 0;
	}

 Manager(int id, String name, String department, double salary, String position, int teamSize) {
   super(id, name, department, salary, position); // Call parent constructor
   this.teamSize = teamSize;
}


void display() {
   super.display();
   System.out.println("Team Size: " + teamSize);
   System.out.println("----------------------------");
}

}

//Subclass 2: Developer
class Developer extends Employee {
String programmingLanguage;

Developer() {
	   super();
	   this.programmingLanguage = "not assign";
	}

Developer(int id, String name, String department, double salary, String position, String programmingLanguage) {
   super(id, name, department, salary, position);
   this.programmingLanguage = programmingLanguage;
}

void display() {
   super.display();
   System.out.println("Programming Language: " + programmingLanguage);
   System.out.println("----------------------------");
}

}


public class EmployeTest {
	public static void main(String[] args) {
	     Manager m1 = new Manager(101, "Alice", "HR", 80000, "Manager", 5);
	     Developer d1 = new Developer(102, "Bob", "IT", 60000, "Software Developer", "Java");

	     m1.display();
	     

	     System.out.println();

	     d1.display();
	    
	 }
}


