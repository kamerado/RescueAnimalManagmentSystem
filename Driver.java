import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    private static ArrayList<Dog> dogList = new ArrayList<Dog>();
    private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>();

    // Method to clear screen
    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    // Main driver.
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        InputValidator userInput = new InputValidator();

        initializeDogList();
        initializeMonkeyList();

        String input = "\0";
        while (!input.equals("q")) {
            displayMenu();
            input = scnr.next();
            switch (input) { // Using a switch to define decision behavior.
                case "1": // define intake dog case.
                    scnr.nextLine(); // These appear to ensure no text is remainging in the input buffer when calling another nextLine.
                    intakeNewDog(scnr); // call intake dog method.
                    break;
                case "2": // define intake monkey case.
                    scnr.nextLine();
                    intakeNewMonkey(scnr); // call intake monkey method
                    break;
                case "3": // define reserve animal case.
                    scnr.nextLine();    
                    reserveAnimal(scnr, userInput);
                    break;
                case "4": // define print dogs case.
                    clearScreen();
                    printAnimals(dogList, scnr);
                    break;
                case "5": // define print monkeys case.
                    clearScreen();
                    printAnimals(monkeyList, scnr);
                    break;
                case "6": // define print available case.
                    clearScreen();
                    printAnimals(scnr);
                    break;
                case "q": // quits application.
                    clearScreen();
                    System.out.println("Thank you for using the Rescue Animal System.");
                    break;
                default: // defaults and loops again.
                    break;
            }
        }
        scnr.close();
    }

    // Add a loop that displays the menu, accepts the users input
    // and takes the appropriate action.

	// For the project submission you must also include input validation
    // and appropriate feedback to the user.
    
    // Hint: create a Scanner and pass it to the necessary methods. 
	// Hint: Menu options 4, 5, and 6 should all connect to the printAnimals() method.

    // This method prints the menu options
    public static void displayMenu() {
        clearScreen(); // added for formatting.
        System.out.println("\t\t\t\tRescue Animal System Menu");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are not reserved");
        System.out.println("[q] Quit application");
        System.out.println();
        System.out.println("Enter a menu selection");

    }


    // Adds dogs to a list for testing
    public static void initializeDogList() {
        // Test examples.
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", 1, 25.6, "05-12-2019", "United States", "intake", false, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", 3, 35.2, "02-03-2020", "United States", "Phase I", false, "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", 4, 25.6, "12-12-2019", "Canada", "in-service", true, "Canada");

        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
    }


    // Adds monkeys to a list for testing
    // For testing.
    public static void initializeMonkeyList() {
        // Test examples.
        Monkey monkey1 = new Monkey("Sammy", "Male", 6, 8.4, "02-23-2023", "Brazil", "Phase II", false, "United States", 14.5, 25.4, 15.3, "Capuchin");
        Monkey monkey2 = new Monkey("Tommy", "Male", 12, 5.7, "10-13-2003", "Brazil", "in-service", true, "United States", 23.5, 13.4, 17.5, "Guenon");
        Monkey monkey3 = new Monkey("RandomName", "Female", 5, 8.3, "07-13-2003", "Brazil", "intake", false, "United States", 3.5, 5.4, 5.1, "Macaque");

        monkeyList.add(monkey1);
        monkeyList.add(monkey2);
        monkeyList.add(monkey3);
    }

    // A method to get inputs without repeating the same code multiple times.
    public static <T extends RescueAnimal> void getInput(String animalType, T animal, ArrayList<T> animalList, Scanner scnr, InputValidator userInput) {
        
        // Variables to store user inputs.
        String inputString;
        int inputInt;

        // Get aniaml name.
        clearScreen();
        inputString = userInput.getAnimalName(animalType, animalList, scnr);
        animal.setName(inputString);

        // Get animal gender.
        clearScreen();
        inputString = userInput.getAnimalGender(animalType, animalList, scnr);
        animal.setGender(inputString);

        // Get animal age.
        clearScreen();
        inputInt = userInput.getAnimalAge(animalType, animalList, scnr);
        animal.setAge(inputInt);

        // Get animal weight.
        clearScreen();
        double weight = userInput.getAnimalWeight(animalType, animalList, scnr);
        animal.setWeight(weight);

        // Get animal acquisition date.
        clearScreen();
        String acquisitionDate = userInput.getAnimalAcquisitionDate(animalType, animalList, scnr);
        animal.setAcquisitionDate(acquisitionDate);

        // Get animal acquisition country.
        clearScreen();
        String acquisitionCountry = userInput.getAnimalCountry(animalType, animalList, scnr);
        animal.setAcquisitionLocation(acquisitionCountry);
        
        // Get animal training status.
        clearScreen();
        String trainingStatus = userInput.getAnimalTrainingStatus(animalType, animalList, scnr);
        animal.setTrainingStatus(trainingStatus);

        // check if animal is "in-service" and ask for additional service country and reserve status.
        if (trainingStatus == "in-service") {

            // Get animal reserved status.
            clearScreen();
            boolean reserved = userInput.getAnimalReservedStatus(animalType, animalList, scnr);
            animal.setReserved(reserved);

            // Get animal service country.
            clearScreen();
            String inServiceCountry = userInput.getAnimalCountry(animalType, animalList, scnr);
            animal.setInServiceCountry(inServiceCountry);
        }
    }

    // Complete the intakeNewDog method
    // The input validation to check that the dog is not already in the list
    // is done for you
    public static void intakeNewDog(Scanner scnr) {
        Dog newDog = new Dog();
        InputValidator userInput = new InputValidator();

        // Get unique variable breed for new dog.        
        getInput("dog", newDog, dogList, scnr, userInput);

        // Get dog breed
        clearScreen();
        String breed = userInput.getDogBreed("dog", dogList, scnr);
        newDog.setBreed(breed); // Set dog breed.
        newDog.setAnimalType("dog"); // Set animal type.

        dogList.add(newDog);
    }


        // Complete intakeNewMonkey
	//Instantiate and add the new monkey to the appropriate list
        // For the project submission you must also  validate the input
	// to make sure the monkey doesn't already exist and the species type is allowed
    public static void intakeNewMonkey(Scanner scnr) {
        Monkey newMonkey = new Monkey(); // New monkey
        InputValidator userInput = new InputValidator(); // For user input and validation.

        getInput("monkey", newMonkey, monkeyList, scnr, userInput); // getting common input
        
        // Get unique variables for new monkey.
        // Get tail length.
        clearScreen();
        double tailLength = -1.0;
        tailLength = userInput.getTailLength("monkey", monkeyList, scnr);
        newMonkey.setTailLength(tailLength); // Set tail length
        
        // Get height.
        clearScreen();
        double height = -1.0;
        height = userInput.getHeight("monkey", monkeyList, scnr);
        newMonkey.setHeight(height); // Set height

        // Get bodyLength
        clearScreen();
        double bodyLength = -1.0;
        bodyLength = userInput.getBodyLength("monkey", monkeyList, scnr); 
        newMonkey.setBodyLength(bodyLength); // Set body length

        // Get species
        clearScreen();
        String species = null;
        species = userInput.getSpecies("monkey", monkeyList, scnr);
        newMonkey.setSpecies(species); // Set species
        newMonkey.setAnimalType("monkey"); // Set animal type to monkey.

        // Add new monkey to list.
        monkeyList.add(newMonkey);
    }

    // Complete reserveAnimal
    // You will need to find the animal by animal type and in service country
    public static void reserveAnimal(Scanner scnr, InputValidator userInput) {
        int input = 0;
        String tmpName = null;
        boolean checkPassed = false;
        do {
            try {
                System.out.println("Select animal type to reserve:\n([1]dog, [2]monkey)\n");
                input = Integer.parseInt(scnr.nextLine());
                switch (input) { // Using a switch for decision.
                    case 1:
                        clearScreen();
                        System.out.println("Dogs: ");
                        for (Dog dog: dogList) {
                            if (dog.getReserved() == false) {
                                System.out.println(dog.getName());
                            }
                        }
                        System.out.println("Enter dog name.");
                        tmpName = userInput.getAnimalInputLine(tmpName, dogList, scnr); // Get name to search for.
                        for (Dog dog: dogList) { // searching by name finding animal.
                            if (dog.getName().toLowerCase().equals(tmpName.toLowerCase()) && dog.getReserved() == false) {
                                dog.setReserved(true); // set to reserved.
                                checkPassed = true;
                            }
                        }
                        break;
                    case 2:
                        clearScreen();
                        System.out.println("Monkeys: ");
                        for (Monkey monkey: monkeyList) {
                            if (monkey.getReserved() == false) {
                                System.out.println(monkey.getName());
                            }
                        }
                        System.out.println("Enter monkey name.");
                        tmpName = userInput.getAnimalInputLine(tmpName, dogList, scnr); // Get name to search for.
                        for (Monkey monkey: monkeyList) { // searching by name finding animal.
                            if (monkey.getName().toLowerCase().equals(tmpName.toLowerCase()) && monkey.getReserved() == false) {
                                monkey.setReserved(true); // set to reserved.
                                checkPassed = true;
                            }
                        }
                        break;
                    default: // loop again.
                        System.out.println("invalid input. (select 1 or 2).");
                        break;
                }
            } catch (Exception exception) { // Catch any input errors.
                System.out.println("Dog not found, try again.");
            }
        } while (!checkPassed);
    }

        // Complete printAnimals
        // Include the animal name, status, acquisition country and if the animal is reserved.
	// Remember that this method connects to three different menu items.
        // The printAnimals() method has three different outputs
        // based on the listType parameter
        // dog - prints the list of dogs
        // monkey - prints the list of monkeys
        // available - prints a combined list of all animals that are
        // fully trained ("in service") but not reserved 
	// Remember that you only have to fully implement ONE of these lists. 
	// The other lists can have a print statement saying "This option needs to be implemented".
	// To score "exemplary" you must correctly implement the "available" list.

    // Print animals of specified type.
    public static <T extends RescueAnimal> void printAnimals(ArrayList<T> animalList, Scanner scnr) {
        int input = -1;
        int count = 0;

        for (T animal: animalList) {                                            // For every dog,
            if (animal.getAnimalType().equals("dog")) {                // call printInfo()
                ((Dog)animal).printInfo();
                count++; // Update count for checking.
            } else if ((animal).getAnimalType().equals("monkey")) {    // for every monkey,
                ((Monkey)animal).printInfo();                                   // call printInfo()
                count++; // Update count for checking.
            }
        }
        if (count == 0) { // If no animals print no animals.
            System.out.println("No animals.\n");
        }
        while (input != 0) { // Press any to continue. Done for formatting.
            System.out.println("\nInput any to continue.\n");
            try {
                input = scnr.nextInt();
                input = 0;
            } catch (Exception exception) {
                input = 0;
            }
        }
    }

    // print available animals of specified type.
    public static void printAnimals(Scanner scnr) {
        int input = -1;
        int count = 0;

        for (Dog dog: dogList) { // Check if dog is reserved and if not and its also in service, print dog info.
            if (!dog.getReserved() && ((String)dog.getTrainingStatus().toLowerCase()).equals("in-service")) {
                dog.printInfo();
                count++;
            }
        }
        for (Monkey monkey: monkeyList) { // Check if monkey is not reserved and if its also in service, print monkey info.
            if (!monkey.getReserved() && monkey.getTrainingStatus().toLowerCase() == "in-service") {
                monkey.printInfo();
                count++;
            }
        }
        if (count == 0) { // Display no monkeys if no monkeys available.
            System.out.println("No animals.\n");
        }
        while (input != 0) { // Done for formatting.
            System.out.println("Input any to continue.\n");
            try {
                input = scnr.nextInt();
                input = 0;
            } catch (Exception exception) {
                input = 0;
            }
        }
    }
}
