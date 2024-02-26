import java.util.ArrayList;
import java.util.Scanner;

/*
 * A couple of notes.
 * 
 * This class was created in part with the UserInput method. Using these methods as decorators.
 * 
 * Reassigning variables durring the various checks to insure each input will be consistent.
 */

public class InputValidator extends UserInput {
    
    // Variables declared at beginning of scope. These are essential for input validation.
    private static String allowedDateChars = "1234567890-";
    private static String trainingPhases[] = {"Phase I", "Phase II", "Phase III", "Phase IV", "Phase V",  "farm", "intake", "in-service"};
    private static String monkeySpecies[] = {"Capuchin", "Guenon", "Macaque", "Marmoset", "Squeirrel monkey", "Tamarin"};
    
    // Method to clear screen. For keeping menu formatted.
    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    // Method for wrapping user input allowing for easy input validation
    public <T extends RescueAnimal> String getAnimalName(String animal, ArrayList<T> animalList, Scanner scnr) {
        String name = null; // Defaulting to null
        boolean checkPassed = false;
        try {
            do { // Do while checks are not passed.
                System.out.println("What is the " + animal + "'s name?");
                name = getAnimalInputLine(animal, animalList, scnr); // Call inputLine method.
                for(T animalTmp: animalList) {                       // For every animal in list,
                    if(!animalTmp.getName().equalsIgnoreCase(name)) {// Check if the animal name matches input name, to ensure no duplicate animals.                             
                        checkPassed = true;                          // Change checkPassed to true to exit the loop.
                    } else {
                    }
                }
            }
            while (!checkPassed);
        } catch (Exception exception) {
            clearScreen();
            System.out.println(exception + "\n getAnimalName: Error. \nInputValidation.java on line: 23");
        }
        return name; // Return name.
    }

    // Gender input and validiation.
    public <T extends RescueAnimal> String getAnimalGender(String animal, ArrayList<T> animalList, Scanner scnr) {

        // Variables declared at the begginging of the scope.
        String gender = "\0";
        boolean checkPassed = false;

        try {
            
            do {
                System.out.println("What is the " + animal + "'s gender? (M or F)");
                gender = getAnimalInputLine(animal, animalList, scnr); // Call inputLine method.
                if (gender.toLowerCase().charAt(0) == 'm') {     // Simple check to ensure most outputs resembling "male" are caught. any others are invalid.
                    gender = "Male";                                   // Reassigning each variable helps to ensure input consistency.
                    checkPassed = true;
                } else if (gender.toLowerCase().charAt(0) == 'f') { // Doing the same with "female" input as well. If input doesnt start with m or f, the loop will continue until inputs are valid.
                    gender = "Female";
                    checkPassed = true;
                } else {
                    clearScreen();
                    System.out.println("Input invalid, enter (M or F)");
                }
            }
            while (!checkPassed);
        } catch (Exception exception) {
            clearScreen();
            System.out.println(exception + "\n getAnimalGender: Error. \nInputValidation.java on line: 42");
        }
        return gender; // return name
    }

    // Method for getting animal gender.
    public <T extends RescueAnimal> int getAnimalAge(String animal, ArrayList<T> animalList, Scanner scnr) {
        
        // Variables declared at the begining of scope.
        int age = 0;
        boolean checkPassed = false;
        
        do {
            try {
                System.out.println("What is the " + animal + "'s age? (0-60)");
                age = getAnimalInputInt(animal, animalList, scnr); // get input int.

                if (!(age > 60) || !(age < 0)) {                    // Check if input is less than age 0. or greater than 60.
                    checkPassed = true;                             // This is to prevent absurd inputs.
                } else {
                    clearScreen();                                  // Display message for allowed inputs.
                    System.out.println("Age must be at least 0, and under 60. Whole numbers only.\n");
                }
            } catch (Exception exception) {          
                clearScreen();
                System.out.println("You must input only whole numbers.\n");
                scnr.nextLine();
            }
        } while (!checkPassed);
        return age; // Return age.
    }

    // Method for getting animal gender.
    public <T extends RescueAnimal> double getAnimalWeight(String animal, ArrayList<T> animalList, Scanner scnr) {

        // Declare varaibles at beggining of scope.
        double weight = -1.0; // Defaulting to null
        boolean checkPassed = false;

        do {
            try {
                System.out.println("What is the " + animal + "'s weight?");
                weight = getAnimalInputDouble(animal, animalList, scnr); // call input double method.
                scnr.nextLine(); // Needed after double input to clear buffer.
                checkPassed = true; // Since program hasen't thrown an exception, check passed.
                System.out.println(checkPassed);
            } catch (Exception exception) { // Catching the exception will cause the loop to continue.
                clearScreen();
                System.out.println("Please enter numbers only.\n"); 
                scnr.nextLine();
            }   
        } while (!checkPassed);
        return weight; // Return weight.
    }

    // Method for getting animal acquisition date.
    public <T extends RescueAnimal> String getAnimalAcquisitionDate(String animal, ArrayList<T> animalList, Scanner scnr) {
        
        // Variables declared at beginning of loop.
        String acquisitionDate = null;
        boolean checkPassed = false;

        do {
            try {
                System.out.println("When was the " + animal + " acquired?");
                acquisitionDate = getAnimalInputLine(animal, animalList, scnr); // Call inputLine method.
                String dateTemp[] = acquisitionDate.split("");            // Re format the input to parse each char.
                for (String challangeChar : dateTemp) {                         // For every char,
                    if (!allowedDateChars.contains(challangeChar)) {            // check if input char is in the allowed list,
                        clearScreen();                                          // If not
                        System.out.println("Invalid date format. Please use the following: (MM-DD-YYYY)");
                        continue;                                               // Continue loop for new input.
                    } else {                                                    // if all chars pass.
                        dateTemp = acquisitionDate.split("-");            // split by seperator.
                        int date1 = Integer.parseInt(dateTemp[0]);
                        int date2 = Integer.parseInt(dateTemp[1]);
                        int date3 = Integer.parseInt(dateTemp[2]);
                        System.out.println(date1 + " " +  date2 + " " + date3);
                        if (!((date1 >= 13) || (date1 <= 0) || (date2 >= 32) || (date2 <= 0) || (date3 >= 3000) || (date3 <= 1899))) {
                            System.out.println("1");
                            checkPassed = true; // If months are real, and days do not exceed 31, and years within reasonable ranges, check passes.
                        } else { // If not re loop and display message for user.
                            System.out.println("2");
                            clearScreen();
                            System.out.println("Invalid input, please use the following: (MM-DD-YYYY) make sure you use real Month, Day, and Year values.");
                        }
                    }
                }
            } catch (Exception exception) { // Error cathcing.
                clearScreen(); 
                System.out.println("Please enter a real date. (MM-DD-YYYY)");
            }
        } while (!checkPassed);
        return acquisitionDate; // Return acquisition date.
    }


    //Method for getting acqusisiton country.
    public <T extends RescueAnimal> String getAnimalCountry(String animal, ArrayList<T> animalList, Scanner scnr) {

        // Variables declared at beginning of loop.
        String acquisitionCountry = null;
        boolean checkPassed = false;
        do {
            try {
                System.out.println("What country was the " + animal + " aquired?");
                acquisitionCountry = getAnimalInputLine(animal, animalList, scnr); // Call inputLine method.
                for (String tmpCountry : countryList.countries) { // For each real country, comapre with input country.
                    if (tmpCountry.toLowerCase().equals(acquisitionCountry.toLowerCase())) { // Using to lower case to compare. This ensures that inputs by user arent't case sensitive.
                        checkPassed = true; // If country matches check is passed.
                        acquisitionCountry = tmpCountry; // Re-assigning variable to ensure input consistency.
                    } else {
                        clearScreen(); // Else display error message for user and loop again.
                        System.out.println("Please enter a real country.");
                    }
                }
            } catch (Exception exception) { // Catch any exceptions.
                clearScreen(); 
                System.out.println("An error has occured, try again.");
            }
        } while (!checkPassed);
        return acquisitionCountry; // Return acquisition country.
    }

    // Training status input and validation.
    public <T extends RescueAnimal> String getAnimalTrainingStatus(String animal, ArrayList<T> animalList, Scanner scnr) {

        // Variables declared at beginning of loop.
        String trainingStatus = null;
        boolean checkPassed = false;
        int selection = -1;

        // This input method uses a seperate method for input. Since there are only a finite about of possible entries within a reasonable range,
        // Display the options on screen with a corresponding number.
        do { 
            try {
                System.out.println("What is the " + animal + "'s training status?\n" + //
                                        "Options: ([1]Phase I, [2]Phase II, [3]Phase III, [4]Phase IV, [5]Phase V, [6]intake, [7]farm, [8]in-service)");              
                selection = getAnimalInputInt(animal, animalList, scnr); // Get input int.
                trainingStatus = trainingPhases[selection-1]; // Try assigning input, if input is out of range, exception will be caught.
                checkPassed = true;
            } catch (Exception exception) { // Catch exception and loop again after displaying error message.
                clearScreen();
                scnr.nextLine();
                System.out.println("An error has occured, try again.");
            }
        } while (!checkPassed); 
        return trainingStatus; // Return training status.
    }


    // Reserved input and validation.
    public <T extends RescueAnimal> boolean getAnimalReservedStatus(String animal, ArrayList<T> animalList, Scanner scnr) {
        
        // Variables declared at beginning of loop.
        String reserved = null;
        boolean reservedBoolean = false;
        boolean checkPassed = false;
        try {
            do {
                System.out.println("Is " + animal + " reserved? (Y/N)");
                reserved = getAnimalInputLine(animal, animalList, scnr);
                if (reserved.toLowerCase().charAt(0) == 'y') { // If input is yes.
                    reservedBoolean = true; // set reserved to true.
                    checkPassed = true; // pass checks.
                } else if (reserved.toLowerCase().charAt(0) == 'n') { // If input is no
                    reservedBoolean = false; // Set reserved to false.
                    checkPassed = true; // pass checks.
                } else { // else display error.
                    clearScreen(); 
                    System.out.println("Please enter, (\"yes\", \"no\", or 'y', 'n')\n");
                }
            } while (!checkPassed);
        } catch (Exception exception) { // catch exception.
            clearScreen();
            System.out.println("Error has occured. Try again.\n(\"yes\", \"no\", or 'y', 'n')\n");
        }
        return reservedBoolean; // return reserved value.
    }

    // Dog breed input and input validation.
    // Makes sure breed inputed isnt a made up breed.
    public <T extends RescueAnimal> String getDogBreed(String animal, ArrayList<T> animalList, Scanner scnr) {
        
        // Variables declared at beginning of loop.
        String breed = null;
        boolean checkPassed = false;

        try {
            do { // do while loop for looping if input is invalid.
                System.out.println("What is the dog's breed?");
                breed = getAnimalInputLine(animal, animalList, scnr);
                for (String challangeBreed : DogBreedsList.dogBreeds) { // Loop thorugh allowed list of breeds to compare.
                    if (challangeBreed.toLowerCase().equals(breed.toLowerCase())) { // If breed is real then check is passed.
                        checkPassed = true;
                        breed = challangeBreed;
                    } else {
                        clearScreen();
                        System.out.println("Please enter a real breed of dog.");
                    }
                }
            } while (!checkPassed);
        } catch (Exception exception) {
            clearScreen();
            System.out.println("An error has occured, try again.");
        }
        return breed;
    }

    public <T extends RescueAnimal> double getTailLength(String animal, ArrayList<T> animalList, Scanner scnr) {
        double tailLength =  -1.0;
        boolean checkPassed = false;
        do {
            try {
                System.out.println("What is the monkeys's tail length?");
                tailLength = getAnimalInputDouble(animal, animalList, scnr); // Simply gets input.
                checkPassed = true;
            } catch (Exception exception) {
                clearScreen();
                scnr.nextLine();
                System.out.println("Please enter whole numbers and decimal numbers only.");
            }
        } while (!checkPassed);
        return tailLength; // return tail length.
    }

    // Gets monkey height.
    public <T extends RescueAnimal> double getHeight(String animal, ArrayList<T> animalList, Scanner scnr) {
        double height = -1.0;
        boolean checkPassed = false;
        do {
            try {
                System.out.println("Where is the monkey's height?");
                height = getAnimalInputDouble(animal, animalList, scnr);
                checkPassed = true;
            } catch (Exception exception) {
                clearScreen();
                scnr.nextLine();
                System.out.println("Please enter whole numbers and decimal numbers only.");
            }
        } while (!checkPassed);
        return height; // return height.
    }

    // Gets monkey bodylength.
    public <T extends RescueAnimal> double getBodyLength(String animal, ArrayList<T> animalList, Scanner scnr) {
        double bodyLength = -1.0;
        boolean checkPassed = false;
        do {
            try {
                System.out.println("Where is the monkeys's body length?");
                bodyLength = getAnimalInputDouble(animal, animalList, scnr);
                checkPassed = true; 
            } catch (Exception exception) {
                clearScreen();
                scnr.nextLine();
                System.out.println("Please enter whole numbers and decimal numbers only.");
            }
        } while (!checkPassed);
        return bodyLength; // return height
    }

    // Gets monkey species.
    public <T extends RescueAnimal> String getSpecies(String animal, ArrayList<T> animalList, Scanner scnr) {
        String species = null;
        boolean checkPassed = false;
        int selection = -1;
        do { // display menu
            System.out.println("What is the species of monkey?\n([1]Capuchin, [2]Guenon, [3]Macaque, [4]Marmoset, [5]Squeirrel monkey, [6]Tamarin)");

            try {
                selection = getAnimalInputInt(animal, animalList, scnr); // Get selection.
                species = monkeySpecies[selection-1]; // Assign selection.
                scnr.nextLine();

                checkPassed = true;
            } catch (Exception exception) { // Catch exception, display message and loop again.
                clearScreen();
                System.out.print("Please enter a valid species. ");
                System.out.print("\n([1]Capuchin, [2]Guenon, [3]Macaque, [4]Marmoset, [5]Squeirrel monkey, [6]Tamarin)");
                System.out.println("");
            }
        } while (!checkPassed);
        return species;
    }
}
