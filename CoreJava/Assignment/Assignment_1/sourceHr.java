class HR {
    int id;
    String name;
    double salary;
    double commission;

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
} // HR class ends here


class TestHR {
    public static void main(String[] args) {
        HR h1;
        h1 = new HR();
        h1.setId(2);
        h1.setName("Pragya");
        h1.setSalary(25000);
        h1.setCommission(1500.00);

        System.out.println("Id: " + h1.id);
        System.out.println("Name: " + h1.name);
        System.out.println("Salary: " + h1.salary);
        System.out.println("Commission: " + h1.commission);
    } // main class ends
}
