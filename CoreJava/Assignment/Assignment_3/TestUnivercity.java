package FirstBit;


class University {
	 String universityName;
	 String location;

	 // Constructor
	 University() {
	     this.universityName = "not";
	     this.location = "not";
	 }
	 
	 // Constructor
	 University(String universityName, String location) {
	     this.universityName = universityName;
	     this.location = location;
	 }

	 
	  String getUniversityName() {
		return universityName;
	}

	 void setUniversityName(String universityName) {
		this.universityName = universityName;
	}

	 String getLocation() {
		return location;
	}

	 void setLocation(String location) {
		this.location = location;
	}

	void display() {
	     System.out.println("University: " + universityName);
	     System.out.println("Location: " + location);
	 }
	}//class univercity end
class Student extends University {
	 String studentName;
	 String course;

	 // Constructor using super()
	 Student() {
	     super();  // call parent constructor
	     this.studentName = studentName;
	     this.course = course;
	 }
	 
	 // Constructor using super()
	 Student(String universityName, String location, String studentName, String course) {
	     super(universityName, location);  // call parent constructor
	     this.studentName = studentName;
	     this.course = course;
	 }

	  String getStudentName() {
		return studentName;
	}

	 void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	 String getCourse() {
		return course;
	}

	 void setCourse(String course) {
		this.course = course;
	}

	void display() {
	     super.display(); // inherited method
	     System.out.println("Student Name: " + studentName);
	     System.out.println("Course: " + course);
	     System.out.println("-----------------------------");
	 }
	}


public class TestUnivercity {
	public static void main() {
	Student s = new Student("Oxford University", "UK", "Emma Watson", "Computer Science");
	s.display();
}
}




