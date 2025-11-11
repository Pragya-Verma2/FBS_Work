class Distance {
    private int km;
    private int m;

    //default constructor
    Distance(){
     System.out.println("default constructor");
     this.km=2;
     this.m=200;
    }

    //peramiteraized constructor
    Distance(int k,int m){
      System.out.println("peramiteraized constructor");
      this.km=k;
      this.m=m;
    }

    // Setter methods
    void setKm(int k) {
        this.km = k;
    }

    void setM(int m) {
        this.m = m;
    }

    // Getter methods
    int getKm() {
        return km;
    }

    int getM() {
        return m;
    }

    // Display method
    void display() {
        System.out.println("Distance: " + km + " km " + m + " meters");
    }
} // Distance class ends here


class TestDistance {
    public static void main(String[] args) {

       //default constructor
        Distance d1 = new Distance();
        d1.display();

         System.out.println("--------------------------");
         //perameteraized constructor
         Distance d2 = new Distance(9,400);
        d1.display();
        
        System.out.println("--------------------------");
        // Display using method
        d1.display();

         System.out.println("--------------------------");
         // setter
         d1.setKm(5);
        d1.setM(350);

        // Or display using getters
        System.out.println("\nUsing Getters:");
        System.out.println("Kilometers: " + d1.getKm());
        System.out.println("Meters: " + d1.getM());
    } // main ends
}
