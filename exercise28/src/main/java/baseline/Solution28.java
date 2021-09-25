/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 William Furie
 */

package baseline;

import java.util.Scanner;

public class Solution28 {

    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        // Write a program that prompts the user for five numbers and computes the total of the numbers.
        Solution28 solution = new Solution28();

        // prompt user for numbers

        // add those numbers together
        int numbers[] = solution.getNumbersFromUser(5);
        int total = solution.addNumbers(numbers);

        // print the total to the user
        solution.displayTotal(total);
    }

    public int addNumbers(int[] numbers) {
        // for the amount of numbers we have, get that many from the user
        // using promptUserForNumber() the amountOfNumbers times
        int total = 0;

        for (int i = 0; i < numbers.length; i++) {
            total += numbers[i];
        }

        return total;
    }

    private int[] getNumbersFromUser(int amountOfNumbers) {
        int[] numbers = new int[amountOfNumbers];

        for (int i = 0; i < amountOfNumbers; i++) {
            int num = promptUserForNumber();
            numbers[i] = num;
        }

        return numbers;
    }

    private int promptUserForNumber() {
        boolean isValid = false;
        boolean firstTry = true;
        String numString = "0";

        // get the number from the user
        while (!isValid) {
            if (!firstTry) {
                System.out.println("That is not a valid number!");
            }
            firstTry = false;
            // prompt user to enter a number
            System.out.print("Enter a number: ");
            numString = input.nextLine();
            isValid = isValidNumber(numString);
        }
        // return the number
        return Integer.parseInt(numString);
    }

    private void displayTotal(int total) {
        // print the total to the user
        System.out.printf("The total is %d.", total);
    }

    public boolean isValidNumber(String num) {
        try {
            Integer.parseInt(num);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
