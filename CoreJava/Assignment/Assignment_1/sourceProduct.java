class Product {
    int pId;
    String pName;
    double price;
    int quantity;

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
} // Product class ends here


class TestProduct {
    public static void main(String[] args) {
        Product p1;
        p1 = new Product();
        p1.setPId(101);
        p1.setPName("Laptop");
        p1.setPrice(55000.50);
        p1.setQuantity(10);

        System.out.println("Product ID: " + p1.pId);
        System.out.println("Product Name: " + p1.pName);
        System.out.println("Price: " + p1.price);
        System.out.println("Quantity: " + p1.quantity);
    } // main ends
}
