package baseline;

public class Password {

    // generate the password as all letters at first
    // generate random indexes for the specialChars and numbers, making sure that index hasn't been used yet
    // fill in the random indexes with corresponding character/number

    // store a list of the indexes that are "open"
    // "open" means that something can overwrite that char
    // so when we put a number in an index, nothing can overwrite that again
    // but if it is a letter, it is an open space

    public Password(int minimumLength, int numSpecialChars, int numNumbers) {

    }

    private void layerSpecialsOn() {
        // for the number of numbers left to place
        // we will generate the amount of specials left
        // we will get random indexes of where to place these specials
        // we will return the final draft of the password
    }

    private void layerNumbersOn() {
        // for the number of numbers left to place
        // we will generate the amount of numbers left
        // we will get random indexes of where to place these numbers
        // we will return the next draft of the password
    }

    private int getOpenIndex() {
        // return a random index that is left

        // placeholder
        return 0;
    }

    // this is all letters
    private char[] generatePasswordFoundation() {
        // for the length of the password, generate a base that has that many letters
        // return that base

        // placeholder
        return null;
    }

    private char generateRandomLetter() {
        // return a random letter

        // placeholder
        return ' ';
    }

    private char generateRandomDigit() {
        // return a random digit

        // placeholder
        return ' ';
    }

    private char generateRandomSpecial() {
        // return a random special char

        // placeholder
        return ' ';
    }
}
