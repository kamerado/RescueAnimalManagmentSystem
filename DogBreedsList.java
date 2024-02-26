import java.util.Arrays;
import java.util.List;

/*
 * This class is used to verify if the dog breeds inputed by user are real dog breeds.
 * 
 * In the future if the client would like to inlcude only certain breeds, as they do with the monkey class,
 * Breeds can easily be redacted from the list.
 * This is sperated to avoid bloating driver class.
 */

public class DogBreedsList {

    static List<String> dogBreeds = Arrays.asList(
        "Labrador Retriever", "German Shepherd", "Golden Retriever", "Bulldog", "Poodle",
        "Beagle", "Rottweiler", "Siberian Husky", "Dachshund", "Boxer",
        "Shih Tzu", "Doberman Pinscher", "Great Dane", "Pomeranian", "Chihuahua",
        "Border Collie", "Shetland Sheepdog", "Cavalier King Charles Spaniel", "Pug", "Australian Shepherd",
        "Akita", "Alaskan Malamute", "American Eskimo Dog", "Basset Hound", "Bernese Mountain Dog",
        "Bloodhound", "Boston Terrier", "Borzoi", "Briard", "Brittany Spaniel",
        "Bullmastiff", "Cane Corso", "Chinese Crested", "Clumber Spaniel", "Cockapoo",
        "Collie", "Coton de Tulear", "Dalmatian", "Dandie Dinmont Terrier", "English Bulldog",
        "English Foxhound", "English Setter", "French Bulldog", "German Shorthaired Pointer", "Giant Schnauzer",
        "Gordon Setter", "Irish Setter", "Irish Wolfhound", "Italian Greyhound", "Japanese Chin",
        "Japanese Spitz", "Keeshond", "Kerry Blue Terrier", "Komondor", "Kuvasz",
        "Leonberger", "Lowchen", "Maltese", "Manchester Terrier", "Mastiff",
        "Miniature Bull Terrier", "Miniature Pinscher", "Neapolitan Mastiff", "Newfoundland", "Norwegian Elkhound",
        "Norwich Terrier", "Nova Scotia Duck Tolling Retriever", "Old English Sheepdog", "Otterhound", "Papillon",
        "Pekingese", "Pembroke Welsh Corgi", "Pharaoh Hound", "Plott Hound", "Pointer",
        "Polish Lowland Sheepdog", "Portuguese Water Dog", "Rhodesian Ridgeback", "Saint Bernard", "Saluki",
        "Samoyed", "Schipperke", "Scottish Deerhound", "Shiba Inu", "Silky Terrier",
        "Sloughi", "Small Munsterlander Pointer", "Smooth Fox Terrier", "Tibetan Mastiff", "Tibetan Spaniel",
        "Tibetan Terrier", "Toy Fox Terrier", "Treeing Walker Coonhound", "Vizsla", "Weimaraner",
        "Welsh Springer Spaniel", "West Highland White Terrier", "Whippet", "Wire Fox Terrier", "Wirehaired Pointing Griffon",
        "Xoloitzcuintli", "Yorkshire Terrier"
    );

}
