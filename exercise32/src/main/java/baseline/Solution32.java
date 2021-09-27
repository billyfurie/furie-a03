/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 William Furie
 */

package baseline;

import java.util.Scanner;

public class Solution32 {

    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Solution32 solution = new Solution32();

        // print welcome message
        solution.welcomeMessage("Guess the Number");

        // We need the difficulty of first game to initialize the game
        int difficulty = solution.getDifficultyFromUser();
        GuessGame game = new GuessGame(difficulty);

        // keep prompting user for numbers while game is active
        while (game.getActive()) {
            String guess = input.nextLine();

            // check if the guess is correct
            if (game.guessNumber(guess)) {
                // if its correct we need to ask player whether they want to play again
                boolean playAgain = solution.getPlayAgainFromUser();

                if (playAgain) {
                    int diff = solution.getDifficultyFromUser();
                    game.newGame(diff);
                } else {
                    game.endGame();
                }
            } else {
                // tell the player why guess is incorrect
                game.getDiagnosisIncorrect(guess);
            }
        }
    }

    private void welcomeMessage(String gameName) {
        System.out.printf("Let's play %s!", gameName);
    }

    private int getDifficultyFromUser() {
        // prompt for difficulty level
        System.out.print("\nEnter the difficulty level (1, 2, or 3): ");
        // read in the string
        String diff = input.nextLine();

        // check to make sure it is 1, 2, or 3. If it is not, prompt again
        while (!(diff.equals("1") || diff.equals("2") || diff.equals("3"))) {
            System.out.print("That is not a difficulty. Enter 1, 2, or 3: ");
            diff = input.nextLine();
        }
        // return the difficulty

        return Integer.parseInt(diff);
    }

    // get whether the user wants to play another game
    private boolean getPlayAgainFromUser() {
        System.out.print("Do you wish to play again (Y/N)? ");

        String response = input.nextLine();

        while (!(response.equals("y") || response.equals("n") || response.equals("Y") || response.equals("N"))) {
            System.out.print("That is not a valid response! Please enter 'Y' or 'N':");
            response = input.nextLine();
        }

        return (response.equals("y") || response.equals("Y"));
    }
}
