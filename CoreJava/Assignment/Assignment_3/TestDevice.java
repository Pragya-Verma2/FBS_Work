package FirstBit;


class Device {
String brand;
double price;
String operatingSystem;

//Constructor
Device() {
 this.brand = "not";
 this.price = 000;
 this.operatingSystem = "0'";
}

// Constructor
Device(String brand, double price, String operatingSystem) {
    this.brand = brand;
    this.price = price;
    this.operatingSystem = operatingSystem;
}

 String getBrand() {
	return brand;
}
 void setBrand(String brand) {
	this.brand = brand;
}
 double getPrice() {
	return price;
}
 void setPrice(double price) {
	this.price = price;
}
 String getOperatingSystem() {
	return operatingSystem;
}
public void setOperatingSystem(String operatingSystem) {
	this.operatingSystem = operatingSystem;
}

void display() {
    System.out.println("Brand: " + brand);
    System.out.println("Operating System: " + operatingSystem);
    System.out.println("Price: $" + price);
}

}//class device end

class Laptop extends Device {
	 int ramSize;
	 String processor;
	 
		 Laptop() {
		     super(); 
		     this.ramSize = 0;
		     this.processor = "not";
		 }

	 // Constructor using super()
	 Laptop(String brand, double price, String operatingSystem, int ramSize, String processor) {
	     super(brand, price, operatingSystem); // call parent constructor
	     this.ramSize = ramSize;
	     this.processor = processor;
	 }
	 

	  int getRamSize() {
		return ramSize;
	}
	 void setRamSize(int ramSize) {
		this.ramSize = ramSize;
	}
	 String getProcessor() {
		return processor;
	}
	 void setProcessor(String processor) {
		this.processor = processor;
	}

	void display() {
	     super.display(); 
	     System.out.println("RAM: " + ramSize + "GB");
	     System.out.println("Processor: " + processor);
	     System.out.println("-----------------------------");
	 }
	}//class Laptop end

class Smartphone extends Device {
	 double screenSize;
	 int batteryCapacity;

	 Smartphone() {
	     super();
	     this.screenSize = 0;
	     this.batteryCapacity = 0;
	 }
	 
	 Smartphone(String brand, double price, String operatingSystem, double screenSize, int batteryCapacity) {
	     super(brand, price, operatingSystem);
	     this.screenSize = screenSize;
	     this.batteryCapacity = batteryCapacity;
	 }
	 

	 double getScreenSize() {
		return screenSize;
	}
	 void setScreenSize(double screenSize) {
		this.screenSize = screenSize;
	}
	 int getBatteryCapacity() {
		return batteryCapacity;
	}
	 void setBatteryCapacity(int batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}
	 
	void display() {
	     super.display();
	     System.out.println("Screen Size: " + screenSize + " inches");
	     System.out.println("Battery: " + batteryCapacity + " mAh");
	     System.out.println("-----------------------------");
	 }
	}



public class TestDevice {
	public static void main(String[] args) {
	     Laptop laptop = new Laptop("Dell", 1200, "Windows 11", 16, "Intel i7");
	     Smartphone phone = new Smartphone("Samsung", 999, "Android 14", 6.7, 5000);

	     laptop.display();
	     phone.display();
}

}