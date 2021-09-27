package baseline;

import java.util.Random;

public class GuessGame {

    private int difficulty;
    private int number;
    private int guesses = 0;
    private boolean gameActive = true;

    public GuessGame(int difficulty) {
        this.difficulty = difficulty;

        // generate number
        generateNumber();
    }

    public void generateNumber() {
        // generate number based on ranges of difficulty
        // 1 => (1, 10)
        // 2 => (1, 100)
        // 3 => (1, 1000)

        // set number to randomly generated number in range
        // notice that range is 10^difficulty
        Random random = new Random();
        int upperBound = (int)Math.pow(10, difficulty);
        number = 1 + random.nextInt(upperBound);

        // let user know we have our number
        System.out.print("I have my number. What's your guess? ");
    }

    public boolean guessNumber(String guess) {
        // increment guesses (even for incorrect guess format)
        guesses++;
        // if it is our number
        if (checkIfNumber(guess) && (int)Double.parseDouble(guess) == number) {
            displayCorrectInfo();
            return true;
        }
        return false;
    }

    private void displayCorrectInfo() {
        System.out.printf("You got it in %d guesses!%n%n", guesses);
    }

    public void getDiagnosisIncorrect(String guess) {
        // if guess is not a number, tell user to enter a number
        if (!checkIfNumber(guess)) {
            System.out.print("That is not a number. Please enter a number: ");
            return;
        }
        // doubles get changed to integers for this game
        int numberGuess = (int)Double.parseDouble(guess);

        // if guess was too low or high, tell user
        if (numberGuess < number) {
            System.out.print("Too low. Guess again: ");
        } else {
            System.out.print("Too high. Guess again: ");
        }
    }

    public void endGame() {
        gameActive = false;
    }

    public void newGame(int difficulty) {
        // set guessingActive to true
        gameActive = true;
        // reset the difficulty
        this.difficulty = difficulty;
        // reset the guesses
        guesses = 0;
        // regenerate the number
        generateNumber();
    }

    public boolean checkIfNumber(String num) {
        try {
            Double.parseDouble(num);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean getActive() {
        return gameActive;
    }

    public int getNumber() {
        return number;
    }
}
