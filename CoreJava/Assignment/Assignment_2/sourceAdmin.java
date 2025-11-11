import java.util.Scanner;
class Admin {
     int id;
     String name;
     double salary;
     double allowance;

    // Default Constructor
    Admin() {
        System.out.println("Default constructor called");
        this.id = 0;
        this.name = "Not Assigned";
        this.salary = 0.0;
        this.allowance = 0.0;
    }

    //  Parameterized Constructor
    Admin(int id, String name, double salary, double allowance) {
        System.out.println("Parameterized constructor called");
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.allowance = allowance;
    }

    // Setter methods
    void setId(int i) {
        this.id = i;
    }

    void setName(String n) {
        this.name = n;
    }

    void setSalary(double s) {
        this.salary = s;
    }

    void setAllowance(double a) {
        this.allowance = a;
    }

    // Getter methods
    int getId() {
        return this.id;
    }

    String getName() {
        return this.name;
    }

    double getSalary() {
        return this.salary;
    }

    double getAllowance() {
        return this.allowance;
    }

    //  Display method
    void display() {
        System.out.println("Admin Details:");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
        System.out.println("Allowance: " + allowance);
    }
}

class TestAdmin {
    public static void main(String[] args) {
         Admin arr[]=new Admin[3];
          arr[0]=new Admin();
          arr[1]=new Admin(1,"mahi",20000,400);
          arr[2]=new Admin();
           for(i=0;i<3;i++){
            System.out.println(arr[i]);
             //arr[i].display();
            }


        //  Using default constructor
        Admin a1 = new Admin();
        a1.display();

        System.out.println("------------------------------");

        // Using parameterized constructor
        Admin a2 = new Admin(1, "Pragya", 20000, 500.00);
        a2.display();

        System.out.println("------------------------------");

        // Using setters and getters
        Admin a3 = new Admin();
        a3.setId(2);
        a3.setName("Ananya");
        a3.setSalary(25000);
        a3.setAllowance(1000.00);

        System.out.println("Using getters:");
        System.out.println("ID: " + a3.getId());
        System.out.println("Name: " + a3.getName());
        System.out.println("Salary: " + a3.getSalary());
        System.out.println("Allowance: " + a3.getAllowance());
    }
}
