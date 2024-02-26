public class Dog extends RescueAnimal {

    // Instance variable
    private String breed;

    // Added constructor.
    public Dog() {
        setName(null);
        setBreed(null);
        setGender(null);
        setAge(-1);
        setWeight(-1.0);
        setAcquisitionDate(null);
        setAcquisitionLocation(null);
        setTrainingStatus(null);
        setReserved(false);
        setInServiceCountry(null);
        setAnimalType("dog");
    }

    // Constructor
    public Dog(String name, String breed, String gender, int age,
    double weight, String acquisitionDate, String acquisitionCountry,
	String trainingStatus, boolean reserved, String inServiceCountry) {
        setName(name);
        setBreed(breed);
        setGender(gender);
        setAge(age);
        setWeight(weight);
        setAcquisitionDate(acquisitionDate);
        setAcquisitionLocation(acquisitionCountry);
        setTrainingStatus(trainingStatus);
        setReserved(reserved);
        setInServiceCountry(inServiceCountry);
        setAnimalType("dog");
    }

    // Accessor Method
    public String getBreed() {
        return breed;
    }

    // Mutator Method
    public void setBreed(String dogBreed) {
        breed = dogBreed;
    }

    // Method for printing dog info.
    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Dog name: " + this.getName());
        System.out.println("   Dog breed: " + this.getBreed());
        System.out.println("   Dog aquisition country: " + this.getAcquisitionLocation());
        System.out.println("   Dog service country: " + this.getInServiceLocation());
        System.out.println("   Dog training status: " + this.getTrainingStatus());
        System.out.println("   Dog reserved: " + this.getReserved());
    }

}
