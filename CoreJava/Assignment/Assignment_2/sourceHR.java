class HR {
     int id;
     String name;
     double salary;
     double commission;

    //  Default Constructor
    HR() {
        System.out.println("Default constructor called");
        this.id = 0;
        this.name = "Not Assigned";
        this.salary = 0.0;
        this.commission = 0.0;
    }

    //  Parameterized Constructor
    HR(int id, String name, double salary, double commission) {
        System.out.println("Parameterized constructor called");
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.commission = commission;
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

    void setCommission(double c) {
        this.commission = c;
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

    double getCommission() {
        return commission;
    }

    //  Display method
    void display() {
        System.out.println("HR Employee Details:");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
        System.out.println("Commission: " + commission);
    }
} // HR class ends here


class TestHR {
    public static void main(String[] args) {

          HR arr[]=new HR[3];
          arr[0]=new HR();
          arr[1]=new HR(7,"harshu",4000,400);
          arr[2]=new HR(8,"harshu",4000,400);
           for(int i=0;i<3;i++){
           // System.out.println(arr[i]);
             arr[i].display();
            }

         System.out.println("------------------------------");

           
        // Using Default Constructor
        HR h1 = new HR();
        h1.display();

        System.out.println("------------------------------");

        // Using Parameterized Constructor
        HR h2 = new HR(2, "Pragya", 25000, 1500.00);
        h2.display();

        System.out.println("------------------------------");

        //  Using Setters and Getters
        HR h3 = new HR();
        h3.setId(3);
        h3.setName("Ananya");
        h3.setSalary(30000);
        h3.setCommission(2000.00);

        System.out.println("Using Getters:");
        System.out.println("ID: " + h3.getId());
        System.out.println("Name: " + h3.getName());
        System.out.println("Salary: " + h3.getSalary());
        System.out.println("Commission: " + h3.getCommission());
    }
}
