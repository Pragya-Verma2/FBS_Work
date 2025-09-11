#include <stdio.h>
#include <string.h>


struct product {
    int id;
    char name[20];
    float price;
} ;  
float calculateTotalPrice() {
    float dis, totalprice, gst, finalprice;

    if (p.price >= 500) {
        dis = p.price * 0.20;  
    } else {
        dis = p.price * 0.05; 
    }

    printf("Discount: %.2f\n", dis);

    totalprice = p.price - dis;
    printf("Price after discount: %.2f\n", totalprice);

    gst = totalprice * 0.18;
    printf("GST: %f\n", gst);

    finalprice = totalprice + gst;
    return finalprice;
}

void display() {
    printf("Id: %d\n", p.id);
    printf("Name: %s\n", p.name);
    printf("Final Price: %f\n", calculateTotalPrice());
}

int main() {
	struct product p;
    printf("Enter Id: ");
    scanf("%d", &p.id);

    printf("Enter name: ");
    scanf("%s", p.name);

    printf("Enter price: ");
    scanf("%f", &p.price);  
    display();

    return 0;
}