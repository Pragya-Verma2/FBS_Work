class Car {
     String model;
     String brand;
     double price;
     String color;
     double fuelCapacity;

    //  Default Constructor
    Car() {
        System.out.println("Default constructor called");
        this.model = "Unknown";
        this.brand = "Not Assigned";
        this.price = 0.0;
        this.color = "White";
        this.fuelCapacity = 0.0;
    }

    //  Parameterized Constructor
    Car(String model, String brand, double price, String color, double fuelCapacity) {
        System.out.println("Parameterized constructor called");
        this.model = model;
        this.brand = brand;
        this.price = price;
        this.color = color;
        this.fuelCapacity = fuelCapacity;
    }

    //  Setter methods
    void setModel(String m) {
        this.model = m;
    }

    void setBrand(String b) {
        this.brand = b;
    }

    void setPrice(double p) {
        this.price = p;
    }

    void setColor(String c) {
        this.color = c;
    }

    void setFuelCapacity(double f) {
        this.fuelCapacity = f;
    }

    //  Getter methods
    String getModel() {
        return model;
    }

    String getBrand() {
        return brand;
    }

    double getPrice() {
        return price;
    }

    String getColor() {
        return color;
    }

    double getFuelCapacity() {
        return fuelCapacity;
    }

    //  Display method
    void display() {
        System.out.println("Car Details:");
        System.out.println("Model: " + model);
        System.out.println("Brand: " + brand);
        System.out.println("Price: ₹" + price);
        System.out.println("Color: " + color);
        System.out.println("Fuel Capacity: " + fuelCapacity + " liters");
    }
} // Car class ends here


class TestCar {
    public static void main(String[] args) {

        //  Using Default Constructor
        Car c1 = new Car();
        c1.display();

        System.out.println("------------------------------");

        //  Using Parameterized Constructor
        Car c2 = new Car("i20", "Hyundai", 800000, "Red", 45.0);
        c2.display();

        System.out.println("------------------------------");

        //  Using Setters & Getters
        Car c3 = new Car();
        c3.setModel("Creta");
        c3.setBrand("Hyundai");
        c3.setPrice(1500000);
        c3.setColor("Black");
        c3.setFuelCapacity(50.0);

        System.out.println("Using Getters:");
        System.out.println("Model: " + c3.getModel());
        System.out.println("Brand: " + c3.getBrand());
        System.out.println("Price: ₹" + c3.getPrice());
        System.out.println("Color: " + c3.getColor());
        System.out.println("Fuel Capacity: " + c3.getFuelCapacity() + " liters");
    }
}
