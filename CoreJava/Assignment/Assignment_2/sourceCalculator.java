Calculator{

    int add(int a, int b) {
      System.out.println("hi");
    }

    // add three integers
    int add(int a, int b, int c) {
       System.out.println("hello");
    }

    // add two doubles
    double add(double a, double b) {
        System.out.println ("hii-3");
    }

    // add double + int
    double add(double a, int b) {
         System.out.println("hii-4");
    }
}

class TestCal{
 public static void main(String [] args){
    Calculater c1=new Calculater();
    c1.add(5,10);
  c1.add(5,10,15);
  c1.add(5.2,1.7);
 c1.add(5.0,10);
    
    

}

}