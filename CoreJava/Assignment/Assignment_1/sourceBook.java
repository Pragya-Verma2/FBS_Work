class Book {
    int isbn;
    String bName;
    String category;
    double price;

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
} // Book class ends here


class TestBook {
    public static void main(String[] args) {
        Book b1;
        b1 = new Book();
        b1.setIsbn(12345);
        b1.setBName("Java Programming");
        b1.setCategory("Education");
        b1.setPrice(499.99);

        System.out.println("ISBN: " + b1.isbn);
        System.out.println("Book Name: " + b1.bName);
        System.out.println("Category: " + b1.category);
        System.out.println("Price: " + b1.price);
    } // main ends
}
