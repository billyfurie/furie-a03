package baseline;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Password {

    private final int minimumLength;
    private int numSpecialChars;
    private int numNumbers;
    private List<Character> pass;
    private List<Integer> openIndexes;
    private final Random random;
    private String passwordString;

    private static final List<Character> letters = Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
            'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');
    private static final List<Character> specials = Arrays.asList('~', '`', '!', '@', '#', '$', '%', '^', '&', '*', '(',
            ')', '-', '_', '+', '=', '{', '}', '[', ']', '|', '\\', '/', ':', ';', '"', '\'', '<', '>', ',', '.', '?');
    private static final List<Character> digits = Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');

    // generate the password as all letters at first
    // generate random indexes for the specialChars and numbers, making sure that index hasn't been used yet
    // fill in the random indexes with corresponding character/number

    // store a list of the indexes that are "open"
    // "open" means that something can overwrite that char
    // so when we put a number in an index, nothing can overwrite that again
    // but if it is a letter, it is an open space

    // our static lists of chars to pull from



    public Password(int minimumLength, int numSpecialChars, int numNumbers) {
        this.minimumLength = minimumLength;
        this.numSpecialChars = numSpecialChars;
        this.numNumbers = numNumbers;
        random = new Random();

        generatePasswordFoundation();
        generateOpenIndexes();
        layerNumbersOn();
        layerSpecialsOn();
        generatePasswordString();
    }

    private void generatePasswordString() {
        StringBuilder builder = new StringBuilder();

        for (char c : pass) {
            builder.append(c);
        }

        passwordString = builder.toString();
    }

    private void generateOpenIndexes() {
        openIndexes = new ArrayList<>();

        for (int i = 0; i < minimumLength; i++) {
            openIndexes.add(i);
        }
    }

    private void layerSpecialsOn() {
        // for the number of numbers left to place
        // we will generate the amount of numbers left
        while (numSpecialChars > 0) {
            // we will get random indexes of where to place these numbers
            int index = getOpenIndex();
            pass.set(index, generateRandomSpecial());
            numSpecialChars--;
        }
    }

    private void layerNumbersOn() {
        // for the number of numbers left to place
        // we will generate the amount of numbers left
        while (numNumbers > 0) {
            // we will get random indexes of where to place these numbers
            int index = getOpenIndex();
            pass.set(index, generateRandomDigit());
            numNumbers--;
        }
    }

    public int getOpenIndex() {
        // return a random index that is left

        // get a random index
        int i = random.nextInt(openIndexes.size());

        // now using that index... we get a random OPEN index to return
        int index = openIndexes.get(i);

        // now update our ArrayList
        openIndexes.remove(i);

        return index;
    }

    // this is all letters
    public void generatePasswordFoundation() {
        pass = new ArrayList<>();

        // for the length of the password, generate a base that has that many letters
        for (int i = 0; i < minimumLength; i++) {
            pass.add(generateRandomLetter());
        }
    }

    public char generateRandomLetter() {
        // return a random letter
        int index = random.nextInt(letters.size());
        return letters.get(index);
    }

    public char generateRandomDigit() {
        // return a random digit
        int index = random.nextInt(digits.size());
        return digits.get(index);
    }

    public char generateRandomSpecial() {
        // return a random special char
        int index = random.nextInt(specials.size());
        return specials.get(index);
    }

    public String getPassword() {
        return passwordString;
    }
}
