/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 William Furie
 */

package baseline;

import java.util.Scanner;

public class Solution26 {

    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Solution26 solution = new Solution26();

        // get balance from user
        double balance = solution.getInputFromUser("What is your balance? ");
        // get apr from user
        double apr = solution.getInputFromUser("What is the APR on the card (as a percent)? ");
        // get monthlyPayment from user
        double monthlyPayment = solution.getInputFromUser("What is the monthly payment you can make? ");

        // create PaymentCalculator(balance, apr, monthlyPayment)
        PaymentCalculator calculator = new PaymentCalculator(balance, apr, monthlyPayment);
        // calculate number of months using PaymentCalculator
        int months = calculator.calculateMonthsUntilPaidOff();
        // display the number of months to pay to the user
        solution.displayMonthsToPay(months);
    }

    private double getInputFromUser(String prompt) {
        // print prompt to user
        System.out.print(prompt);
        // get input string from user
        String userInput = input.nextLine();
        // return input as double
        return Double.parseDouble(userInput);
    }

    private void displayMonthsToPay(int numberMonths) {
        // print output to user displaying number of months left
        System.out.printf("It will take you %d months to pay off this card", numberMonths);
    }
}
