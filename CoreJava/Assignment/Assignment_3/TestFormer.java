package FirstBit;

class Former{
	int formerId;
	String formerName;
	String landArea;
	String city;
	double annualIncome;
	
	
	public Former(int formerId, String formerName, String landArea, String city, double annualIncome) {
		this.formerId = formerId;
		this.formerName = formerName;
		this.landArea = landArea;
		this.city = city;
		this.annualIncome = annualIncome;
	}
	
	public int getFormerId() {
		return formerId;
	}
	public void setFormerId(int formerId) {
		this.formerId = formerId;
	}
	public String getFormerName() {
		return formerName;
	}
	public void setFormerName(String formerName) {
		this.formerName = formerName;
	}
	public String getLandArea() {
		return landArea;
	}
	public void setLandArea(String landArea) {
		this.landArea = landArea;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public double getAnnualIncome() {
		return annualIncome;
	}
	public void setAnnualIncome(double annualIncome) {
		this.annualIncome = annualIncome;
	}
	
	void display() {
		System.out.println("formerId :" + formerId);
		System.out.println("formerName :" + formerName);
		System.out.println("landArea :" + landArea);
		System.out.println("city :" + city);
		System.out.println("annualIncome :" + annualIncome);
	}
	
	
}// class former

class DairyFormer extends Former{
	int noOfCattles;
	int dairyLicenceNo;
	
	public DairyFormer(int formerId, String formerName, String landArea, String city, double annualIncome,
			int noOfCattles, int dairyLicenceNo) {
		super(formerId, formerName, landArea, city, annualIncome);
		this.noOfCattles = noOfCattles;
		this.dairyLicenceNo = dairyLicenceNo;
	}
	
	public int getNoOfCattles() {
		return noOfCattles;
	}
	public void setNoOfCattles(int noOfCattles) {
		this.noOfCattles = noOfCattles;
	}
	public int getDairyLicenceNo() {
		return dairyLicenceNo;
	}
	public void setDairyLicenceNo(int dairyLicenceNo) {
		this.dairyLicenceNo = dairyLicenceNo;
	}
	
	void display() {
		super.display();
		System.out.println("noOfCattles :" + noOfCattles);
		System.out.println("dairyLicenceNo :" + dairyLicenceNo);
	}
	
}// dairy former end

class poultryFormer extends Former{
	int noOfHens;
	int noOfShadCapacity;
	String eagsProduceDay;
	
	
	
	public poultryFormer(int formerId, String formerName, String landArea, String city, double annualIncome,
			int noOfHens, int noOfShadCapacity, String eagsProduceDay) {
		super(formerId, formerName, landArea, city, annualIncome);
		this.noOfHens = noOfHens;
		this.noOfShadCapacity = noOfShadCapacity;
		this.eagsProduceDay = eagsProduceDay;
	}
	
	public int getNoOfHens() {
		return noOfHens;
	}
	public void setNoOfHens(int noOfHens) {
		this.noOfHens = noOfHens;
	}
	public int getNoOfShadCapacity() {
		return noOfShadCapacity;
	}
	public void setNoOfShadCapacity(int noOfShadCapacity) {
		this.noOfShadCapacity = noOfShadCapacity;
	}
	public String getEagsProduceDay() {
		return eagsProduceDay;
	}
	public void setEagsProduceDay(String eagsProduceDay) {
		this.eagsProduceDay = eagsProduceDay;
	}
	
	void display() {
		super.display();
		System.out.println("noOfHens :" + noOfHens);
		System.out.println("noOfShadCapacity :" + noOfShadCapacity);
		System.out.println("eagsProduceDay :" + eagsProduceDay);
	}
}//class end

class orgenicFormer extends Former{
	int organicId;
	String cropType;
	String fertilizorUsed;
	
	public orgenicFormer(int formerId, String formerName, String landArea, String city, double annualIncome,
			int organicId, String cropType, String fertilizorUsed) {
		super(formerId, formerName, landArea, city, annualIncome);
		this.organicId = organicId;
		this.cropType = cropType;
		this.fertilizorUsed = fertilizorUsed;
	}
	
	public int getOrganicId() {
		return organicId;
	}
	public void setOrganicId(int organicId) {
		this.organicId = organicId;
	}
	public String getCropType() {
		return cropType;
	}
	public void setCropType(String cropType) {
		this.cropType = cropType;
	}
	public String getFertilizorUsed() {
		return fertilizorUsed;
	}
	public void setFertilizorUsed(String fertilizorUsed) {
		this.fertilizorUsed = fertilizorUsed;
	}
	
	void display() {
		super.display();
		System.out.println("organicId :" + organicId);
		System.out.println("cropType :" + cropType);
		System.out.println("fertilizorUsed :" + fertilizorUsed);
	}
}

public class TestFormer {
   public static void main(String[] args) {
	   DairyFormer d1=new DairyFormer(1,"js","wl2o","pune",20000,1,12345);
	   d1.display();
	   
	   System.out.println();
	   
	   orgenicFormer o1=new orgenicFormer(2,"js","wl2o","pune",20000,1,"kd","wd");
	   o1.display();
   }
}
