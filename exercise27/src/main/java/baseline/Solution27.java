/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 William Furie
 */

package baseline;

import java.util.Scanner;

public class Solution27 {

    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Solution27 solution = new Solution27();

        // firstName = get string from user
        String firstName = solution.getStringFromUser("Enter the first name: ");
        // lastName = get string from user
        String lastName = solution.getStringFromUser("Enter the last name: ");
        // zip = get string from user
        String zip = solution.getStringFromUser("Enter the ZIP code: ");
        // id = get string from user
        String id = solution.getStringFromUser("Enter the employee ID: ");

        // create an InputValidator class
        InputValidator validator = new InputValidator(firstName, lastName, zip, id);

        // Retrieve the output statement that the InputValidator built
        solution.displayOutputMessage(validator);
    }

    private String getStringFromUser(String prompt) {
        // print prompt
        System.out.print(prompt);
        // get string from user
        // return string

        return input.nextLine();
    }

    private void displayOutputMessage(InputValidator validator) {
        // get output message from validator
        // print output message to user

        System.out.println(validator.getValidationMessage());
    }
}
