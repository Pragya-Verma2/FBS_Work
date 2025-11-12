package FirstBit;

class Defence{
	String nameOfHead;
	int nooFProops;
	double budget;
	int noOfVehicle;
	String locationOfHeadquater;
	String countryName;
	int manPowerCount;
	int noOfCasulatie;
	int noOfFmissionPerformed;
	
	public Defence() {
		this.nameOfHead = "not";
		this.nooFProops = 0;
		this.budget = 0;
		this.noOfVehicle = 0;
		this.locationOfHeadquater = "not";
		this.countryName = "not";
		this.manPowerCount = 0;
		this.noOfCasulatie = 0;
		this.noOfFmissionPerformed = 0;
	}// constructor
	
	public Defence(String nameOfHead, int nooFProops, double budget, int noOfVehicle, String locationOfHeadquater,
			String countryName, int manPowerCount, int noOfCasulatie, int noOfFmissionPerformed) {
		this.nameOfHead = nameOfHead;
		this.nooFProops = nooFProops;
		this.budget = budget;
		this.noOfVehicle = noOfVehicle;
		this.locationOfHeadquater = locationOfHeadquater;
		this.countryName = countryName;
		this.manPowerCount = manPowerCount;
		this.noOfCasulatie = noOfCasulatie;
		this.noOfFmissionPerformed = noOfFmissionPerformed;
	}// constructor
	
	//setter and getter
	public String getNameOfHead() {
		return nameOfHead;
	}
	public void setNameOfHead(String nameOfHead) {
		this.nameOfHead = nameOfHead;
	}
	public int getNooFProops() {
		return nooFProops;
	}
	public void setNooFProops(int nooFProops) {
		this.nooFProops = nooFProops;
	}
	public double getBudget() {
		return budget;
	}
	public void setBudget(double budget) {
		this.budget = budget;
	}
	public int getNoOfVehicle() {
		return noOfVehicle;
	}
	public void setNoOfVehicle(int noOfVehicle) {
		this.noOfVehicle = noOfVehicle;
	}
	public String getLocationOfHeadquater() {
		return locationOfHeadquater;
	}
	public void setLocationOfHeadquater(String locationOfHeadquater) {
		this.locationOfHeadquater = locationOfHeadquater;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public int getManPowerCount() {
		return manPowerCount;
	}
	public void setManPowerCount(int manPowerCount) {
		this.manPowerCount = manPowerCount;
	}
	public int getNoOfCasulatie() {
		return noOfCasulatie;
	}
	public void setNoOfCasulatie(int noOfCasulatie) {
		this.noOfCasulatie = noOfCasulatie;
	}
	public int getNoOfFmissionPerformed() {
		return noOfFmissionPerformed;
	}
	public void setNoOfFmissionPerformed(int noOfFmissionPerformed) {
		this.noOfFmissionPerformed = noOfFmissionPerformed;
	}
	
	void display() {
		System.out.println("nameOfHead :" + nameOfHead);
		System.out.println("nooFProops :" + nooFProops);
		System.out.println("budget :" + budget);
		System.out.println("noOfVehicle :" + noOfVehicle);
		System.out.println("locationOfHeadquater :" + locationOfHeadquater);
		System.out.println("countryName :" + countryName);
		System.out.println("manPowerCount :" + manPowerCount);
		System.out.println("noOfCasulatie :" + noOfCasulatie);
		System.out.println("noOfFmissionPerformed :" + noOfFmissionPerformed);
	}
	
}// class defence

class Army extends Defence {
	int noOfTanks;
	int noOfGuns;
	int noOfGranits;
	int noOfBatalin;
	
	 Army() {
	 super();
		this.noOfTanks = 0;
		this.noOfGuns = 0;
		this.noOfGranits = 0;
		this.noOfBatalin = 0;
	}//constructor
	
	 Army(String nameOfHead, int nooFProops, double budget, int noOfVehicle, String locationOfHeadquater,
			String countryName, int manPowerCount, int noOfCasulatie, int noOfFmissionPerformed,int noOfTanks, int noOfGuns, int noOfGranits, int noOfBatalin) {
		super( nameOfHead,  nooFProops,  budget,  noOfVehicle,  locationOfHeadquater,
				 countryName,  manPowerCount,  noOfCasulatie,  noOfFmissionPerformed);
		this.noOfTanks = noOfTanks;
		this.noOfGuns = noOfGuns;
		this.noOfGranits = noOfGranits;
		this.noOfBatalin = noOfBatalin;
	}//constructor
	
	//setter and gatter
	public int getNoOfTanks() {
		return noOfTanks;
	}
	public void setNoOfTanks(int noOfTanks) {
		this.noOfTanks = noOfTanks;
	}
	public int getNoOfGuns() {
		return noOfGuns;
	}
	public void setNoOfGuns(int noOfGuns) {
		this.noOfGuns = noOfGuns;
	}
	public int getNoOfGranits() {
		return noOfGranits;
	}
	public void setNoOfGranits(int noOfGranits) {
		this.noOfGranits = noOfGranits;
	}
	public int getNoOfBatalin() {
		return noOfBatalin;
	}
	public void setNoOfBatalin(int noOfBatalin) {
		this.noOfBatalin = noOfBatalin;
	}
	
	void display() {
		super.display();
		System.out.println("noOfTanks :" + noOfTanks);
		System.out.println("noOfGuns :" + noOfGuns);
		System.out.println("noOfGranits :" + noOfGranits);
		System.out.println("noOfBatalin :" + noOfBatalin);
	}
	
}// army class end

class Navy extends Defence{
	int noOfShips;
	int noOfSubmaries;
	int noOfTorpedos;
	
	public Navy() {
		super();
		this.noOfShips = 0;
		this.noOfSubmaries = 0;
		this.noOfTorpedos = 0;
	}
	
	public Navy(String nameOfHead, int nooFProops, double budget, int noOfVehicle, String locationOfHeadquater,
			String countryName, int manPowerCount, int noOfCasulatie, int noOfFmissionPerformed,int noOfShips, int noOfSubmaries, int noOfTorpedos) {
		super( nameOfHead,  nooFProops,  budget,  noOfVehicle,  locationOfHeadquater,
				 countryName,  manPowerCount,  noOfCasulatie,  noOfFmissionPerformed);
		this.noOfShips = noOfShips;
		this.noOfSubmaries = noOfSubmaries;
		this.noOfTorpedos = noOfTorpedos;
	}
	
	// setter and getter
	public int getNoOfShips() {
		return noOfShips;
	}
	public void setNoOfShips(int noOfShips) {
		this.noOfShips = noOfShips;
	}
	public int getNoOfSubmaries() {
		return noOfSubmaries;
	}
	public void setNoOfSubmaries(int noOfSubmaries) {
		this.noOfSubmaries = noOfSubmaries;
	}
	public int getNoOfTorpedos() {
		return noOfTorpedos;
	}
	public void setNoOfTorpedos(int noOfTorpedos) {
		this.noOfTorpedos = noOfTorpedos;
	}
	
	void display() {
		super.display();
		System.out.println("noOfShips :" + noOfShips);
		System.out.println("noOfSubmaries :" + noOfSubmaries);
		System.out.println("noOfTorpedos :" + noOfTorpedos);
	}
	
}

class air extends Defence {
	int noOfFmissies;
	String airCraft;
	int noOfSquadron;
	
	public air() {
		super();
		//noOfMissile
		this.noOfFmissies = 0;
		this.airCraft = "k";
		this.noOfSquadron = 0;
	}//constructor
	
	public air(String nameOfHead, int nooFProops, double budget, int noOfVehicle, String locationOfHeadquater,
			String countryName, int manPowerCount, int noOfCasulatie, int noOfFmissionPerformed,int noOfFmissies, String airCraft, int noOfSquadron) {
		super( nameOfHead,  nooFProops,  budget,  noOfVehicle,  locationOfHeadquater,
				 countryName,  manPowerCount,  noOfCasulatie,  noOfFmissionPerformed);
		this.noOfFmissies = noOfFmissies;
		this.airCraft = airCraft;
		this.noOfSquadron = noOfSquadron;
	}//constructor
	
	public int getNoOfFmissies() {
		return noOfFmissies;
	}
	public void setNoOfFmissies(int noOfFmissies) {
		this.noOfFmissies = noOfFmissies;
	}
	public String getAirCraft() {
		return airCraft;
	}
	public void setAirCraft(String airCraft) {
		this.airCraft = airCraft;
	}
	public int getNoOfSquadron() {
		return noOfSquadron;
	}
	public void setNoOfSquadron(int noOfSquadron) {
		this.noOfSquadron = noOfSquadron;
	}
	
	void display() {
		super.display();
		System.out.println("noOfFmissies :" + noOfFmissies);
		System.out.println("airCraft :" + airCraft);
		System.out.println("noOfSquadron :" + noOfSquadron);
	}
	
}

public class TestDefence {
	public static void main(String[]args) {
	Army a1=new Army();
	a1.display();
	
	Navy n1=new Navy();
	n1.display();
}
}
