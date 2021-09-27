package baseline;

public class GuessGame {

    private int difficulty;
    private int number;
    private int guesses;
    private boolean playAgainPromptActive = false;
    private boolean guessingActive = true;

    public GuessGame(int difficulty) {
        // print welcome message
        // generate number
    }

    private void generateNumber() {
        // generate number based on ranges of difficulty
        // 1 => (1, 10)
        // 2 => (1, 100)
        // 3 => (1, 1000)

        // set number to randomly generated number in range
        // let user know we have our number
    }

    public void guessNumber(String guess) {
        // increment guesses (even for incorrect guess format)

        // if guess is not an integer, tell user to enter a number

        // if guess was correct, tell user that and how many guesses it took
        // we are now asking if they want to play again

        // if guess was too low or high, tell user
    }

    public int getNumberOfGuesses() {
        return guesses;
    }

    public void newGame(int difficulty) {
        // set guessingActive to true
        // set playAgainPrompt to false
        // reset the difficulty
        // regenerate the number
    }
}
