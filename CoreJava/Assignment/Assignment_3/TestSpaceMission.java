package FirstBit;

//🔹 Superclass
class SpaceMission {
 String missionName;
 String launchDate;
 String launchSite;
 double budget;
 String missionStatus;

 SpaceMission(String missionName, String launchDate, String launchSite, double budget, String missionStatus) {
     this.missionName = missionName;
     this.launchDate = launchDate;
     this.launchSite = launchSite;
     this.budget = budget;
     this.missionStatus = missionStatus;
 }
 
 // setter and getter
 public String getMissionName() {
	return missionName;
}
public void setMissionName(String missionName) {
	this.missionName = missionName;
}
public String getLaunchDate() {
	return launchDate;
}
public void setLaunchDate(String launchDate) {
	this.launchDate = launchDate;
}
public String getLaunchSite() {
	return launchSite;
}
public void setLaunchSite(String launchSite) {
	this.launchSite = launchSite;
}
public double getBudget() {
	return budget;
}
public void setBudget(double budget) {
	this.budget = budget;
}
public String getMissionStatus() {
	return missionStatus;
}
public void setMissionStatus(String missionStatus) {
	this.missionStatus = missionStatus;
}


void display() {
     System.out.println("Mission Name: " + missionName);
     System.out.println("Launch Date: " + launchDate);
     System.out.println("Launch Site: " + launchSite);
     System.out.println("Budget: $" + budget + " million");
     System.out.println("Mission Status: " + missionStatus);
 }
}

//🔹 Subclass 1: Satellite Mission
class SatelliteMission extends SpaceMission {
 String orbitType;
 int satelliteCount;

 SatelliteMission(String missionName, String launchDate, String launchSite, double budget, String missionStatus,
                  String orbitType, int satelliteCount) {
     super(missionName, launchDate, launchSite, budget, missionStatus);
     this.orbitType = orbitType;
     this.satelliteCount = satelliteCount;
 }
 //setter and getter
 public String getOrbitType() {
	return orbitType;
}
public void setOrbitType(String orbitType) {
	this.orbitType = orbitType;
}
public int getSatelliteCount() {
	return satelliteCount;
}
public void setSatelliteCount(int satelliteCount) {
	this.satelliteCount = satelliteCount;
}


void display() {
     super.display();
     System.out.println("Orbit Type: " + orbitType);
     System.out.println("Number of Satellites: " + satelliteCount);
     System.out.println("-----------------------------------");
 }
}

//🔹 Subclass 2: Rover Mission
class RoverMission extends SpaceMission {
 String targetPlanet;
 boolean hasDrillingUnit;

 RoverMission(String missionName, String launchDate, String launchSite, double budget, String missionStatus,
              String targetPlanet, boolean hasDrillingUnit) {
     super(missionName, launchDate, launchSite, budget, missionStatus);
     this.targetPlanet = targetPlanet;
     this.hasDrillingUnit = hasDrillingUnit;
 }

//setter and getter 
 public String getTargetPlanet() {
	return targetPlanet;
}
public void setTargetPlanet(String targetPlanet) {
	this.targetPlanet = targetPlanet;
}
public boolean isHasDrillingUnit() {
	return hasDrillingUnit;
}
public void setHasDrillingUnit(boolean hasDrillingUnit) {
	this.hasDrillingUnit = hasDrillingUnit;
}


void display() {
     super.display();
     System.out.println("Target Planet: " + targetPlanet);
     System.out.println("Has Drilling Unit: " + (hasDrillingUnit ? "Yes" : "No"));
     System.out.println("-----------------------------------");
 }
}

//🔹 Subclass 3: Space Telescope Mission
class SpaceTelescopeMission extends SpaceMission {
 double mirrorDiameter;
 String wavelengthRange;

 SpaceTelescopeMission(String missionName, String launchDate, String launchSite, double budget, String missionStatus,
                       double mirrorDiameter, String wavelengthRange) {
     super(missionName, launchDate, launchSite, budget, missionStatus);
     this.mirrorDiameter = mirrorDiameter;
     this.wavelengthRange = wavelengthRange;
 }

 //setter and getter
 public double getMirrorDiameter() {
	return mirrorDiameter;
}
public void setMirrorDiameter(double mirrorDiameter) {
	this.mirrorDiameter = mirrorDiameter;
}
public String getWavelengthRange() {
	return wavelengthRange;
}
public void setWavelengthRange(String wavelengthRange) {
	this.wavelengthRange = wavelengthRange;
}



void display() {
     super.display();
     System.out.println("Mirror Diameter: " + mirrorDiameter + " meters");
     System.out.println("Wavelength Range: " + wavelengthRange);
     System.out.println("-----------------------------------");
 }
}

//🔹 Subclass 4: Space Station Mission
class SpaceStationMission extends SpaceMission {
 int modulesCount;
 boolean internationalCollaboration;

 SpaceStationMission(String missionName, String launchDate, String launchSite, double budget, String missionStatus,
                     int modulesCount, boolean internationalCollaboration) {
     super(missionName, launchDate, launchSite, budget, missionStatus);
     this.modulesCount = modulesCount;
     this.internationalCollaboration = internationalCollaboration;
 }

 //setter and getter
 
 public int getModulesCount() {
	return modulesCount;
}
public void setModulesCount(int modulesCount) {
	this.modulesCount = modulesCount;
}
public boolean isInternationalCollaboration() {
	return internationalCollaboration;
}
public void setInternationalCollaboration(boolean internationalCollaboration) {
	this.internationalCollaboration = internationalCollaboration;
}


void display() {
     super.display();
     System.out.println("Modules Count: " + modulesCount);
     System.out.println("International Collaboration: " + (internationalCollaboration ? "Yes" : "No"));
     System.out.println("-----------------------------------");
 }
}

//🔹 Main Class
public class TestSpaceMission {
 public static void main(String[] args) {
     SatelliteMission sat = new SatelliteMission("StarLink", "2025-06-12", "Cape Canaveral", 1200.0, "Active", "Low Earth Orbit", 60);
     RoverMission rov = new RoverMission("Mars Explorer", "2024-08-15", "ISRO Launch Pad", 2500.0, "Success", "Mars", true);
     SpaceTelescopeMission tel = new SpaceTelescopeMission("DeepView", "2027-11-10", "Vandenberg AFB", 2800.0, "Under Construction", 6.5, "Infrared");
     SpaceStationMission sta = new SpaceStationMission("Lunar Base Alpha", "2028-09-30", "Cape Canaveral", 5000.0, "Design Phase", 8, true);

     sat.display();
     rov.display();
     tel.display();
     sta.display();
 }
}