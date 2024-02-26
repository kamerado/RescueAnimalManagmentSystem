public class Monkey extends RescueAnimal {
    
    private String species;
    private double tailLength, height, bodyLength;
    /*
     * Constructors
     */
    public Monkey() {
        setName(null);
        setGender(null);
        setAge(-1);
        setWeight(-1.0);
        setAcquisitionDate(null);
        setAcquisitionLocation(null);
        setTrainingStatus(null);
        setReserved(false);
        setInServiceCountry(null);
        setTailLength(-1.0);
        setHeight(-1.0);
        setBodyLength(-1.0);
        setSpecies(null);
        setAnimalType("monkey");
    }

    public Monkey(String name, String gender, int age,
    Double weight, String acquisitionDate, String acquisitionCountry,
	String trainingStatus, boolean reserved, String inServiceCountry,
    double tailLength, double height, double bodyLength, String species) {
        setName(name);
        setGender(gender);
        setAge(age);
        setWeight(weight);
        setAcquisitionDate(acquisitionDate);
        setAcquisitionLocation(acquisitionCountry);
        setTrainingStatus(trainingStatus);
        setReserved(reserved);
        setInServiceCountry(inServiceCountry);
        setTailLength(tailLength);
        setHeight(height);
        setBodyLength(bodyLength);
        setSpecies(species);
        setAnimalType("monkey");
    }

    /*
     * Mutators
     */
    public void setTailLength(double tailLength) {
        this.tailLength = tailLength;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setBodyLength(double bodyLength) {
        this.bodyLength = bodyLength;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    /* 
     * Accessors
    */
    public double getTailLength() {
        return this.tailLength;
    }

    public double getHeight() {
        return this.height;
    }

    public double getBodyLength() {
        return this.bodyLength;
    }

    public String getSpecies() {
        return this.species;
    }

    // Method for printing Monke info.
    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Monkey name: " + this.getName());
        System.out.println("   Monkey aquisition country: " + this.getAcquisitionLocation());
        System.out.println("   Monkey training status: " + this.getTrainingStatus());
        System.out.println("   Monkey reserved: " + this.getReserved());
    }
}
