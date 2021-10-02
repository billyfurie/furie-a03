/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 William Furie
 */

package baseline;

import java.util.Scanner;

public class Solution37 {

    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Solution37 solution = new Solution37();

        // prompt user for minimum length of password
        int minimumLength = solution.getIntegerFromUser("What's the minimum length? ");

        // prompt user for number of specials
        int numSpecials = solution.getIntegerFromUser("How many special characters? ");
        // prompt user for number of numbers
        int numNumbers = solution.getIntegerFromUser("How many numbers? ");

        // keep incrementing the password until we make numLetters >= (numSpecials + numNumbers) (per assignment requirement)
        while (!PasswordRequirements.isValidForPassword(minimumLength, numSpecials, numNumbers)) {
            minimumLength++;
        }

        // generate the password using the password class
        Password password = new Password(minimumLength, numSpecials, numNumbers);

        // give the password to the user
        solution.displayPassword(password);
    }

    private void displayPassword(Password password) {
        System.out.printf("Your password is %s", password.getPassword());
    }

    private int getIntegerFromUser(String prompt) {
        System.out.print(prompt);
        int number;

        while (true) {
            try {
                number = Integer.parseInt(input.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter an integer.");
            }
        }

        return number;
    }
}
