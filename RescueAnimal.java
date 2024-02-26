import java.lang.String;

public class RescueAnimal {

    // Instance variables
    private String name;
    private String animalType;
    private String gender;
    private int age; // Changed to int
    private double weight;
    private String acquisitionDate;
    private String acquisitionCountry;
	private String trainingStatus;
    private boolean reserved;
	private String inServiceCountry;


    // Constructor
    public RescueAnimal() {
    }

	// Accessors modified to return only implicitly.
	public String getName() {
		return this.name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAnimalType() {
		return this.animalType;
	}


	public void setAnimalType(String animalType) {
		this.animalType = animalType;
	}


	public String getGender() {
		return this.gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}

	// Changed to int
	public int getAge() {
		return this.age;
	}

	// Changed to int
	public void setAge(int age) {
		this.age = age;
	}


	public double getWeight() {
		return this.weight;
	}


	public void setWeight(double weight) {
		this.weight = weight;
	}


	public String getAcquisitionDate() {
		return this.acquisitionDate;
	}


	public void setAcquisitionDate(String acquisitionDate) {
		this.acquisitionDate = acquisitionDate;
	}


	public String getAcquisitionLocation() {
		return this.acquisitionCountry;
	}


	public void setAcquisitionLocation(String acquisitionCountry) {
		this.acquisitionCountry = acquisitionCountry;
	}


	public boolean getReserved() {
		return this.reserved;
	}


	public void setReserved(boolean reserved) {
		this.reserved = reserved;
	}


	public String getInServiceLocation() {
		return this.inServiceCountry;
	}


	public void setInServiceCountry(String inServiceCountry) {
		this.inServiceCountry = inServiceCountry;
	}




	public String getTrainingStatus() {
		return this.trainingStatus;
	}


	public void setTrainingStatus(String trainingStatus) {
		this.trainingStatus = trainingStatus;
	}

	// printInfo to override.
	public void printInfo() {
		System.out.println(""); // Do nothing.
	}
}
