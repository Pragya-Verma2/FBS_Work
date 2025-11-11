import java.util.Scanner;
class Book {
     int isbn;
     String bName;
     String category;
     double price;

    //  Default Constructor
    Book() {
        System.out.println("Default constructor called");
        this.isbn = 1;
        this.bName = "Not Assigned";
        this.category = "Unknown";
        this.price = 400.0;
    }

    //  Parameterized Constructor
    Book(int isbn, String bName, String category, double price) {
        System.out.println("Parameterized constructor called");
        this.isbn = isbn;
        this.bName = bName;
        this.category = category;
        this.price = price;
    }

    //  Setter methods
    void setIsbn(int i) {
        this.isbn = i;
    }

    void setBName(String n) {
        this.bName = n;
    }

    void setCategory(String c) {
        this.category = c;
    }

    void setPrice(double p) {
        this.price = p;
    }

    //  Getter methods
    int getIsbn() {
        return isbn;
    }

    String getBName() {
        return bName;
    }

    String getCategory() {
        return category;
    }

    double getPrice() {
        return price;
    }

    // Display method
    void display() {
        System.out.println("Book Details:");
        System.out.println("ISBN: " + isbn);
        System.out.println("Book Name: " + bName);
        System.out.println("Category: " + category);
        System.out.println("Price: " + price);
    }
} // Book class ends here


class TestBook {
    public static void main(String[] args) {
     
         
        System.out.println("------------------------------");

        // Using parameterized constructor
        Book b2 = new Book(12345, "Java Programming", "Education", 499.99);
        b2.display();

        System.out.println("------------------------------");

        //  Using setters and getters
        Book b3 = new Book();
        b3.setIsbn(67890);
        b3.setBName("Data Structures");
        b3.setCategory("Computer Science");
        b3.setPrice(599.50);

        System.out.println("Using getters:");
        System.out.println("ISBN: " + b3.getIsbn());
        System.out.println("Book Name: " + b3.getBName());
        System.out.println("Category: " + b3.getCategory());
        System.out.println("Price: " + b3.getPrice());
    } // main ends
}
