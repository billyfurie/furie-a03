/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 William Furie
 */

package baseline;

import java.util.Scanner;

public class Solution31 {

    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Solution31 solution = new Solution31();
        // prompt the user for age and resting heart rate
        int age = solution.getIntegerFromUser("Enter your age: ");
        int restingHR = solution.getIntegerFromUser("Enter your resting heart rate: ");
        // build the heart rate table
        String table = solution.buildHeartRateTable(age, restingHR);
        // display the heart rate table to the user
        solution.displayHeartRateTable(table);
    }

    private int getIntegerFromUser(String prompt){
        // read string from user
        // if string is not integer, prompt again
        // return the integer

        boolean valid = false;
        boolean firstAttempt = true;
        String num = "0";

        while (!valid) {
            if (!firstAttempt) {
                System.out.println("That is not a valid number! Please enter an integer.");
            }
            firstAttempt = false;
            System.out.print(prompt);
            num = input.nextLine();

            valid = isStringInteger(num);
        }

        // if we get here, we know the number is valid
        return Integer.parseInt(num);
    }

    public boolean isStringInteger(String number) {
        // check if rate is an integer or not
        try {
            int num = Integer.parseInt(number);
            return (num > 0);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public int getTargetHeartRate(int age, int restingHR, double intensity) {
        // use formula
        // TargetHeartRate = (((220 − age) − restingHR) × intensity) + restingHR

        // calculate, then return target heart rate
        double target = (((220 - age) - restingHR) * intensity) + restingHR;

        return (int)Math.round(target);
    }

    private String buildHeartRateTable(int age, int restingHR) {
        // use string builder
        StringBuilder table = new StringBuilder();
        // build the header rows
        String mainHeader = String.format("%nResting Pulse: %d        Age: %d%n%n", restingHR, age);
        String tableHeader = String.format("Intensity    | Rate%n-------------|--------%n");

        table.append(mainHeader);
        table.append(tableHeader);

        // build the standard rows using a loop
        for (int i = 55; i <= 95; i+=5) {
            table.append(buildHeartRateTableRow(age, restingHR, i));
        }

        // return the table
        return table.toString();
    }

    private String buildHeartRateTableRow(int age, int restingHR, double intensity) {
        // build the row using string builder in the specified format
        StringBuilder row = new StringBuilder();
        double i = intensity / 100;

        String n = String.format("%.0f%%          | %d bpm%n", intensity, getTargetHeartRate(age, restingHR, i));
        row.append(n);

        // return the row
        return row.toString();
    }

    private void displayHeartRateTable(String table) {
        System.out.println(table);
    }
}
