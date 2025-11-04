class Student {
    int rollno;
    String name;
    double marks;

    void setRollno(int r) {
        this.rollno = r;
    }

    void setName(String n) {
        this.name = n;
    }

    void setMarks(double m) {
        this.marks = m;
    }
} // Student class ends here


class TestStudent {
    public static void main(String[] args) {
        Student s1;
        s1 = new Student();
        s1.setRollno(101);
        s1.setName("Pragya");
        s1.setMarks(89.5);

        System.out.println("Roll No: " + s1.rollno);
        System.out.println("Name: " + s1.name);
        System.out.println("Marks: " + s1.marks);
    } // main ends
}
