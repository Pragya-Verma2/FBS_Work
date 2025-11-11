package FirstBit;

class Vehicle{
	String brand;
    String model;
    int year;
    double price;
    String color;
    
    public Vehicle() {
		this.brand = "not";
		this.model = "not";
		this.year = 0000;
		this.price = 0000;
		this.color = "red";
	}// default constructor
    
    public Vehicle(String brand, String model, int year, double price, String color) {
		this.brand = brand;
		this.model = model;
		this.year = year;
		this.price = price;
		this.color = color;
	}// parameterized constructor
    
	// setter and getters
	 String getBrand() {
		return brand;
	}
	 void setBrand(String brand) {
		this.brand = brand;
	}
	 String getModel() {
		return model;
	}
	 void setModel(String model) {
		this.model = model;
	}
	 int getYear() {
		return year;
	}
	 void setYear(int year) {
		this.year = year;
	}
	 double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getColor() {
		return color;
	}
	 void setColor(String color) {
		this.color = color;
	}

void display() {
	System.out.println("brand name is :" +brand );
	System.out.println("model is : " + model);
	System.out.println("year is :" + year);
	System.out.println("price is : " +price);
	System.out.println("colore is : " +color);
}
        
}//class vehicle end here

class Car extends Vehicle {
    int numberOfDoors;

    Car() {
        super();
        this.numberOfDoors = numberOfDoors;
    }//default constructor
    
    Car(String brand, String model, int year, double price, String color, int numberOfDoors) {
        super(brand, model, year, price, color);
        this.numberOfDoors = numberOfDoors;
    }//parameterized constructor

    
    
     int getNumberOfDoors() {
		return numberOfDoors;
	}

	 void setNumberOfDoors(int numberOfDoors) {
		this.numberOfDoors = numberOfDoors;
	}

	void display() {
        super.display();
        System.out.println("Number of Doors: " + numberOfDoors);
        System.out.println("----------------------------");
    }
}

class Bike extends Vehicle {
    String type; 

    public Bike() {
		super();
		this.type = type;
	}

	 public Bike(String brand, String model, int year, double price, String color,String type) {
		super( brand,  model,  year,  price,  color);
		this.type = type;
	}

	void setType(String type) {
		this.type = type;
	} 
	
	 String getType() {
		return type;
	}

	void display() {
        super.display();
        System.out.println("type is:" + type);
	}
}
        
public class TestVehical {
  public static void main(String [] args) {
	  Vehicle v1=new Vehicle();
	  v1.display();
	  
	  Car c1=new Car("oyota", "Camry", 2023, 32000,"White",4);
	  c1.display();
  }
}
