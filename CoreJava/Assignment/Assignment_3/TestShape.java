package FirstBit;

class Shape{
	 String color;
	  double borderThickness;
	  String name;
	  String type;
	  
	  Shape() {
		     this.color = "not";
		     this.borderThickness = 0;
		     this.name = "not";
		     this.type = "not";
		 }
	  
	  Shape(String color, double borderThickness, String name, String type) {
		     this.color = color;
		     this.borderThickness = borderThickness;
		     this.name = name;
		     this.type = type;
		 }
	  
	 String getColor() {
		return color;
	}
	 void setColor(String color) {
		this.color = color;
	}
	 double getBorderThickness() {
		return borderThickness;
	}
	 void setBorderThickness(double borderThickness) {
		this.borderThickness = borderThickness;
	}
	 String getName() {
		return name;
	}
	 void setName(String name) {
		this.name = name;
	}
	 String getType() {
		return type;
	}
	 void setType(String type) {
		this.type = type;
	}
	  
	 void display() {
	     System.out.println("Shape: " + name);
	     System.out.println("Color: " + color);
	     System.out.println("Border Thickness: " + borderThickness);
	     System.out.println("Type: " + type);
	 }
	  
}//shape class end here

class Circle extends Shape {
	  double radius;
	  
	  public Circle() {
			super();
			this.radius = radius;
		}

	public Circle(String color, double borderThickness, String name, String type,double radius) {
		super( color,  borderThickness,  name,  type);
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	 
	 void display() { 
		 super.display();
	  System.out.println("Radius: " + radius);
	 }
}//circle class end here

class Rectangle extends Shape {
	  double length;
	  double width;

	  Rectangle() {
		     super();
		     this.length = length;
		     this.width = width;
		 }//default constructor
	  
	 // Constructor
	 Rectangle(String color, double borderThickness, boolean filled, double length, double width) {
	     super(color, borderThickness, "Rectangle", "2D");
	     this.length = length;
	     this.width = width;
	 }

	 // Getters and Setters
	 public double getLength() {
	     return length;
	 }

	 public void setLength(double length) {
	     this.length = length;
	 }

	 public double getWidth() {
	     return width;
	 }

	 public void setWidth(double width) {
	     this.width = width;
	 }

	
	 void display() {
	     super.display();
	     System.out.println("Length: " + length);
	     System.out.println("Width: " + width);
	     System.out.println("-------------------------");
	 }
	}//rectangle class end


public class TestShape {
   public static void main(String[] args) {
	   Circle c1 = new Circle("Red", 2.5,"nn","pragya",5.0);
	     Rectangle r1 = new Rectangle("Blue", 1.5, false, 4.0, 6.0);

	     c1.display();
	     r1.display();
   }
}


