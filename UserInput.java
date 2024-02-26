import java.util.ArrayList;
import java.util.Scanner;

/*
 * This class was created because getting user input and validating that input becomes messy and unreadable.
 * This class is implemented by InputValidator to wrap each input method like a decorator and run the InputValidations
 * This class holds methods for user input and decorators that can validate those inputs.
 */

public class UserInput {

    // Method for getting animal name.
    public <T extends RescueAnimal> String getAnimalInputLine(String animal, ArrayList<T> animalList, Scanner scnr) {
        String inputLine = "\0";
        boolean checkPassed = false;
        do {
            inputLine = scnr.nextLine(); // get input name.
            checkPassed = true;
        } while (!checkPassed);

        return inputLine; // Return name.
    }
    
    // Method for getting animal gender.
    public <T extends RescueAnimal> String getAnimalInputString(String animal, ArrayList<T> animalList, Scanner scnr) {
        String inputString = null;
        boolean checkPassed = false;
        do {
            inputString = scnr.next(); // get input string.
            checkPassed = true;
            System.out.println(checkPassed);
        } while (!checkPassed);
        return inputString; // Return input string.
    }

    public <T extends RescueAnimal> int getAnimalInputInt(String animal, ArrayList<T> animalList, Scanner scnr) {
        int inputInt = 0;
        boolean checkPassed = false;
        do {
            inputInt = scnr.nextInt(); // get input integer.
            checkPassed = true;
        } while (!checkPassed);
        return inputInt; // Return input integer.
    }

    public <T extends RescueAnimal> double getAnimalInputDouble(String animal, ArrayList<T> animalList, Scanner scnr) {
        double inputInt = 0;
        boolean checkPassed = false;
        do {
            inputInt = scnr.nextDouble(); // get input integer.
            checkPassed = true;
        } while (!checkPassed);
        return inputInt; // Return input integer.
    }
}