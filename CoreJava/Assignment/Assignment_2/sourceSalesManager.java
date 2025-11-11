class SalesManager {
     int id;
     String name;
     double salary;
     double incentive;
     double target;

    //  Default Constructor
    SalesManager() {
        System.out.println("Default constructor called");
        this.id = 0;
        this.name = "Not Assigned";
        this.salary = 0.0;
        this.incentive = 0.0;
        this.target = 0.0;
    }

    //  Parameterized Constructor
    SalesManager(int id, String name, double salary, double incentive, double target) {
        System.out.println("Parameterized constructor called");
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.incentive = incentive;
        this.target = target;
    }

    //  Setter methods
    void setId(int i) {
        this.id = i;
    }

    void setName(String n) {
        this.name = n;
    }

    void setSalary(double s) {
        this.salary = s;
    }

    void setIncentive(double inc) {
        this.incentive = inc;
    }

    void setTarget(double t) {
        this.target = t;
    }

    //  Getter methods
    int getId() {
        return id;
    }

    String getName() {
        return name;
    }

    double getSalary() {
        return salary;
    }

    double getIncentive() {
        return incentive;
    }

    double getTarget() {
        return target;
    }

    //  Display method
    void display() {
        System.out.println("Sales Manager Details:");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
        System.out.println("Incentive: " + incentive);
        System.out.println("Target: " + target);
    }
} // SalesManager class ends here


class TestSalesManager {
    public static void main(String[] args) {

         SalesManager sarr[]=new SalesManager[3];
          sarr[0]=new SalesManager();
          sarr[1]=new SalesManager(1,"harshu",400.0,40.0,1000);
          sarr[2]=new SalesManager(1,"harshu",400.0,40.0,1000);
           for(int i=0;i<3;i++){
            System.out.println(sarr[i]);
             //sarr[i].display();
            }

        //  Using default constructor
        SalesManager s1 = new SalesManager();
        s1.setId(3);
        s1.setName("Pragya");
        s1.setSalary(30000);
        s1.setIncentive(2500.00);
        s1.setTarget(50000.00);

        s1.display();

        System.out.println("\nUsing Getters:");
        System.out.println("ID: " + s1.getId());
        System.out.println("Name: " + s1.getName());
        System.out.println("Salary: " + s1.getSalary());
        System.out.println("Incentive: " + s1.getIncentive());
        System.out.println("Target: " + s1.getTarget());

        System.out.println("------------------------------");

        //  Using parameterized constructor
        SalesManager s2 = new SalesManager(4, "Ananya", 40000, 3000, 60000);
        s2.display();
    }
}
