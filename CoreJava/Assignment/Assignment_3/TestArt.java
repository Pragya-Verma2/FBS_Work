package FirstBit;

//🔹 Superclass
class ArtProject {
 String title;
 String artist;
 int yearCreated;
 String medium;
 double estimatedValue;

 ArtProject(String title, String artist, int yearCreated, String medium, double estimatedValue) {
     this.title = title;
     this.artist = artist;
     this.yearCreated = yearCreated;
     this.medium = medium;
     this.estimatedValue = estimatedValue;
 }

 // setter and getter
 
public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getArtist() {
	return artist;
}

public void setArtist(String artist) {
	this.artist = artist;
}

public int getYearCreated() {
	return yearCreated;
}

public void setYearCreated(int yearCreated) {
	this.yearCreated = yearCreated;
}

public String getMedium() {
	return medium;
}

public void setMedium(String medium) {
	this.medium = medium;
}

public double getEstimatedValue() {
	return estimatedValue;
}

public void setEstimatedValue(double estimatedValue) {
	this.estimatedValue = estimatedValue;
}

void display() {
    System.out.println("Title: " + title);
    System.out.println("Artist: " + artist);
    System.out.println("Year Created: " + yearCreated);
    System.out.println("Medium: " + medium);
    System.out.println("Estimated Value: $" + estimatedValue);
}

}

//🔹 Subclass 1: Painting
class Painting extends ArtProject {
 String paintType;
 String style; // 🎨 new unique attribute

 Painting(String title, String artist, int yearCreated, String medium, double estimatedValue,
          String paintType, String style) {
     super(title, artist, yearCreated, medium, estimatedValue);
     this.paintType = paintType;
     this.style = style;
 }

// setter getter
 public String getPaintType() {
	return paintType;
}
public void setPaintType(String paintType) {
	this.paintType = paintType;
}
public String getStyle() {
	return style;
}
public void setStyle(String style) {
	this.style = style;
}

void display() {
     super.display();
     System.out.println("Paint Type: " + paintType);
     System.out.println("Style: " + style);
     System.out.println("----------------------------");
 }
}

//🔹 Subclass 2: DigitalArt
class DigitalArt extends ArtProject {
 String softwareUsed;
 String resolution; 

 DigitalArt(String title, String artist, int yearCreated, String medium, double estimatedValue,
            String softwareUsed, String resolution) {
     super(title, artist, yearCreated, medium, estimatedValue);
     this.softwareUsed = softwareUsed;
     this.resolution = resolution;
 }
 
 //setter and getter
 public String getSoftwareUsed() {
	return softwareUsed;
}
public void setSoftwareUsed(String softwareUsed) {
	this.softwareUsed = softwareUsed;
}
public String getResolution() {
	return resolution;
}
public void setResolution(String resolution) {
	this.resolution = resolution;
}


void display() {
     super.display();
     System.out.println("Software Used: " + softwareUsed);
     System.out.println("Resolution: " + resolution);
     System.out.println("----------------------------");
 }
}

//🔹 Subclass 3: Photography
class Photography extends ArtProject {
 String cameraModel;
 String location; 
 
 Photography(String title, String artist, int yearCreated, String medium, double estimatedValue,
         String cameraModel, String location) {
 super(title, artist, yearCreated, medium, estimatedValue);
 this.cameraModel = cameraModel;
 this.location = location;
}

 
 //setter and getter
 public String getCameraModel() {
	return cameraModel;
}
public void setCameraModel(String cameraModel) {
	this.cameraModel = cameraModel;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}

 
 void display() {
     super.display();
     System.out.println("Camera Model: " + cameraModel);
     System.out.println("Location: " + location);
     System.out.println("----------------------------");
 }
}

//🔹 Subclass 4: InstallationArt
class InstallationArt extends ArtProject {
 double areaCovered;
 String materialUsed; 

 InstallationArt(String title, String artist, int yearCreated, String medium, double estimatedValue,
                 double areaCovered, String materialUsed) {
     super(title, artist, yearCreated, medium, estimatedValue);
     this.areaCovered = areaCovered;
     this.materialUsed = materialUsed;
 }
 
 //setter and getter
 
 public double getAreaCovered() {
	return areaCovered;
}
public void setAreaCovered(double areaCovered) {
	this.areaCovered = areaCovered;
}
public String getMaterialUsed() {
	return materialUsed;
}
public void setMaterialUsed(String materialUsed) {
	this.materialUsed = materialUsed;
}

void display() {
     super.display();
     System.out.println("Area Covered: " + areaCovered + " sq. meters");
     System.out.println("Material Used: " + materialUsed);
     System.out.println("----------------------------");
 }
}

//🔹 Main Class
public class TestArt {
 public static void main(String[] args) {
     Painting p = new Painting("Sunset Glow", "Ava Smith", 2022, "Canvas", 5000, "Oil", "Impressionism");
     DigitalArt d = new DigitalArt("Cyber Dreams", "Maya Chen", 2023, "Digital", 3000, "Procreate", "4K");
     Photography ph = new Photography("City Reflections", "Noah Patel", 2021, "Photo Paper", 2000, "Canon EOS R6", "New York City");
     InstallationArt i = new InstallationArt("Forest Lights", "Sophia Lee", 2019, "Mixed Media", 15000, 25.5, "LED & Fabric");

     p.display();
     d.display();
     ph.display();
     i.display();
 }
}
