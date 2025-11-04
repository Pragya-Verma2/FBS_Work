class SalesManager {
    int id;
    String name;
    double salary;
    double incentive;
    double target;

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
} // SalesManager class ends here


class TestSalesManager {
    public static void main(String[] args) {
        SalesManager s1;
        s1 = new SalesManager();
        s1.setId(3);
        s1.setName("Pragya");
        s1.setSalary(30000);
        s1.setIncentive(2500.00);
        s1.setTarget(50000.00);

        System.out.println("Id: " + s1.id);
        System.out.println("Name: " + s1.name);
        System.out.println("Salary: " + s1.salary);
        System.out.println("Incentive: " + s1.incentive);
        System.out.println("Target: " + s1.target);
    } // main class ends
}
