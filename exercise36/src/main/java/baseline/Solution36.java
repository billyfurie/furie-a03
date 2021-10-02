/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 William Furie
 */

package baseline;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution36 {

    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Solution36 solution = new Solution36();

        // get the response times from the user
        List<Double> responseTimes = solution.buildResponseTimesList();
        // calculate the average, minimum, maximum, and standard deviation
        double average = solution.average(responseTimes);
        double min = solution.min(responseTimes);
        double max = solution.max(responseTimes);
        double std = solution.std(responseTimes);

        // display the results
        solution.displayResults(responseTimes, average, min, max, std);
    }

    private void displayResults(List<Double> numbers, double average, double min, double max, double std) {
        // display the results to the user
        System.out.printf("Numbers: ");

        int index = 0;
        for (double num : numbers) {
            System.out.printf("%.2f", num);
            // the last element doesn't need a comma
            if (!(index++ ==  numbers.size() - 1)) {
                System.out.print(", ");
            } else {
                System.out.println();
            }
        }
        System.out.printf("The average is %.2f%nThe minimum is %.2f%nThe maximum is %.2f%nThe standard deviation is %.2f",
                average, min, max, std);
    }

    public double std(List<Double> numbers) {
        // calculate the std dev of the numbers
        double average = average(numbers);
        double sumOfDifferenceSquared = 0;

        for (Double num : numbers) {
            double differenceSquared = Math.pow(num - average, 2);
            sumOfDifferenceSquared += differenceSquared;
        }

        double underSquareRoot = sumOfDifferenceSquared / numbers.size();

        // return the std dev
        return Math.sqrt(underSquareRoot);
    }

    public double max(List<Double> numbers) {
        // find the maximum of the numbers
        double max = Double.MIN_VALUE;

        for (Double num : numbers) {
            if (num > max) {
                max = num;
            }
        }

        // return the maximum
        return max;
    }

    public double min(List<Double> numbers) {
        // find the minimum of the numbers
        double min = Double.MAX_VALUE;

        for (Double num : numbers) {
            if (num < min) {
                min = num;
            }
        }

        // return the minimum
        return min;
    }

    public double average(List<Double> numbers) {
        // calculate the average of the numbers
        double total = 0;

        for (Double num : numbers) {
            total += num;
        }

        return total / numbers.size();
    }

    public boolean isNumber(String num) {
        // return whether the string is numeric
        try {
            Double.parseDouble(num);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private List<Double> buildResponseTimesList() {
        // create the list
        List<Double> responseTimes = new ArrayList<>();

        // keep getting numbers from user
        String num = getNumber();

        // verify that the string is a number before we add
        // if they enter done, we stop
        while (!num.equals("done")) {
            if (isNumber(num)) {
                double number = Double.parseDouble(num);
                responseTimes.add(number);
            } else {
                System.out.println("That is not a valid number.");
            }
            num = getNumber();
        }

        // return the list
        return responseTimes;
    }

    private String getNumber() {
        // prompt for the number
        System.out.print("Enter a number: ");
        // return the number
        return input.nextLine();
    }
 }
