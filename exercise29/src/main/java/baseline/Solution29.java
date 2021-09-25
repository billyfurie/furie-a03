/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 William Furie
 */

package baseline;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Solution29 {

    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Solution29 solution = new Solution29();

        // Prompt user for rate of return
        double rate = solution.getRateOfReturnFromUser();

        // Once valid, calculate how long to double investment
        double years = solution.calculateLengthToDoubleInvestment(rate);

        // Display the length it will take to the user
        solution.displayLengthToDoubleInvestment(years);
    }

    private void displayLengthToDoubleInvestment(double years) {
        // print how long it will take to double the investment
        System.out.printf("It will take %.2f years to double your initial investment.", years);
    }

    public double calculateLengthToDoubleInvestment(double rate) {
        // use formula years = 72 / r
        BigDecimal value = new BigDecimal(72).divide(BigDecimal.valueOf(rate), 2, RoundingMode.HALF_UP);

        // return this number
        return value.doubleValue();
    }

    private double getRateOfReturnFromUser() {
        // Prompt the user for the rate of return
        boolean numberValid = false;
        boolean firstAttempt = true;
        String rate = "";

        // Use a loop to check for bad input
        while (!numberValid) {
            if (!firstAttempt) {
                System.out.println("Sorry. That's not a valid input.");
            }
            firstAttempt = false;
            System.out.print("What is the rate of return? ");

            // Check that the rate is a number
            // Check that the rate is not 0
            rate = input.nextLine();

            numberValid = isRateValid(rate);
        }
        // we only exit the loop if the rate is valid, so we can collect the rate now

        // Return the rate of return
        return Double.parseDouble(rate);
    }

    public boolean isRateValid(String number) {
        // check if rate is number
        try {
            double num = Double.parseDouble(number);
            // check if rate is not 0
            return (num != 0);
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
