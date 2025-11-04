class Car {
    String model;
    String brand;
    double price;
    String color;
    double fuelCapacity;
 
void setModel(String m){
   this.model=m;
}
void setBrand(String b){
   this.brand=b;
}
void setPrice(double p){
   this.price=p;
}
void setColor(String c){
   this.color=c;
}
void setFuelCapacity(double f){
   this.fuelCapacity=f;
}

// getter method
String getModel(){
  return model;
}
String getBrand(){
  return brand;
}
double getPrice(){
  return price;
}
String getColor(){
  return color;
}
double getFuelCapacity(){
  return fuelCapacity;
}
}// car class ends here

class TestCar{
  public static void main(String[] args){
      Car c1;
      c1=new Car();

      c1.setModel("i20");
      c1.setBrand("Hyundai");
      c1.setPrice(800000);
      c1.setColor("Red");
      c1.setFuelCapacity(45.0);

     System.out.println("Model :" + c1.getModel());
     System.out.println("Brand :" + c1.getBrand());
     System.out.println("Price :" + c1.getPrice());
     System.out.println("Color :" + c1.getColor());
     System.out.println("FuelCapacity :" + c1.getFuelCapacity());

}//main class end 
}

 