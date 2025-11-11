class Product {
     int pId;
     String pName;
     double price;
     int quantity;

    //  Default Constructor
    Product() {
        System.out.println("Default constructor called");
        this.pId = 0;
        this.pName = "Not Assigned";
        this.price = 0.0;
        this.quantity = 0;
    }

    //  Parameterized Constructor
    Product(int pId, String pName, double price, int quantity) {
        System.out.println("Parameterized constructor called");
        this.pId = pId;
        this.pName = pName;
        this.price = price;
        this.quantity = quantity;
    }

    //  Setter methods
    void setPId(int id) {
        this.pId = id;
    }

    void setPName(String name) {
        this.pName = name;
    }

    void setPrice(double p) {
        this.price = p;
    }

    void setQuantity(int q) {
        this.quantity = q;
    }

    //  Getter methods
    int getPId() {
        return pId;
    }

    String getPName() {
        return pName;
    }

    double getPrice() {
        return price;
    }

    int getQuantity() {
        return quantity;
    }

    //  Display method
    void display() {
        System.out.println("Product Details:");
        System.out.println("Product ID: " + pId);
        System.out.println("Product Name: " + pName);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
    }
} // Product class ends here


class TestProduct {
    public static void main(String[] args) {

        //  Using Default Constructor
        Product p1 = new Product();
        p1.display();

        System.out.println("------------------------------");

        //  Using Parameterized Constructor
        Product p2 = new Product(101, "Laptop", 55000.50, 10);
        p2.display();

        System.out.println("------------------------------");

        //  Using Setters and Getters
        Product p3 = new Product();
        p3.setPId(102);
        p3.setPName("Smartphone");
        p3.setPrice(25000.00);
        p3.setQuantity(15);

        System.out.println("Using Getters:");
        System.out.println("Product ID: " + p3.getPId());
        System.out.println("Product Name: " + p3.getPName());
        System.out.println("Price: " + p3.getPrice());
        System.out.println("Quantity: " + p3.getQuantity());
    }
}
