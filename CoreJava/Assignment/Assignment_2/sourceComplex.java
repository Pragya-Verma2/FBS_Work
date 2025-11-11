class Complex {
    private double real;
    private double imaginary;


    // default constructor
    Complex(){
      System.out.println("default constructor");
      this.real=1.2;
      this.imaginary=9.0;
    }

    // perameter constructor
    Complex(double r,double i){
       System.out.println("perameteraized constructor");
       this.real=r;
       this.imaginary=i;
     }

    // Setter methods
    void setReal(double r) {
        this.real = r;
    }

    void setImaginary(double i) {
        this.imaginary = i;
    }

    // Getter methods
    double getReal() {
        return real;
    }

    double getImaginary() {
        return imaginary;
    }

    // Display method
    void display() {
        System.out.println("Complex Number: " + real + " + " + imaginary + "i");
    }
}

class TestComplex {
    public static void main(String[] args) {

        // display default constructor
        Complex c1 = new Complex();
        c1.display();

        System.out.println("-----------------------------------");

       // display perameteraized constructor
       Complex c2=new Complex(2.3,5.0);
       c2.display();
        
         System.out.println("-----------------------------------");

        // Using display method
        c1.display();

         System.out.println("-----------------------------------");

        // setter
        c1.setReal(4.5);
        c1.setImaginary(3.2);

        // Using getters
        System.out.println("\nUsing Getters:");
        System.out.println("Real Part: " + c1.getReal());
        System.out.println("Imaginary Part: " + c1.getImaginary());
    }
}
