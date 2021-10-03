/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 William Furie
 */

package baseline;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution38 {

    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Solution38 solution = new Solution38();

        // ensure that each character is either a number or a space
        // convert to an array
        int[] filtered;

        while (true) {
            // prompt user for a list of number separated by spaces
            char[] numbers = solution.getListStringFromUser();

            try {
                // filter out only the even numbers in the array and generate a new array
                filtered = solution.filterEvenNumbers(numbers);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Please enter a list of integers separated by spaces only.");
            }
        }

        // display the even numbers to the user
        solution.displayEvenNumbers(filtered);
    }

    private char[] getListStringFromUser() {
        // print the prompt
        System.out.print("Enter a list of numbers, separated by spaces: ");
        // return the string as an array
        return getCharArrayFromString(input.nextLine());
    }

    public char[] getCharArrayFromString(String input) {
        return input.toCharArray();
    }


    public int[] filterEvenNumbers(char[] charArray) throws IllegalArgumentException {
        List<Integer> numbers = new ArrayList<>();

        // used to keep track of the current number
        // this is because we scan char by char
        // otherwise 34 would be read as a 3 and a 4 separately
        StringBuilder currentNum = new StringBuilder();


        int index = 0;
        // go through the string and parse the numbers adding them to an array
        for (char c : charArray) {

            // we are starting to build the current number were parsing
            if (Character.isDigit(c)) {
                currentNum.append(c);
            }
            // if the string is not all numeric / spaces, throw an exception
            else if (!Character.isSpaceChar(c)) {
                throw new IllegalArgumentException("Includes character that is not a space or integer.");
            }

            // add the number to the list
            // if char is not a digit, we have to check if we have a number to add
            // if we are at the last char, we might have to release a number we've had to this point
            if ((!Character.isDigit(c) || index == charArray.length - 1) && !currentNum.isEmpty()) {
                int number;
                // check that the number isn't too big
                try {
                    number = Integer.parseInt(currentNum.toString());
                } catch (NumberFormatException e) {
                    System.out.printf("Invalid number. Value must be between %d and %d.%n",
                            Integer.MIN_VALUE, Integer.MAX_VALUE);
                    index++;
                    continue;
                }

                numbers.add(number);
                // reset the current number were working with
                currentNum.setLength(0);
            }
            index++;
        }

        // return the filtered array
        return getEvensArrayFromList(numbers);
    }

    public int[] getEvensArrayFromList(List<Integer> evens) {
        int evenCount = 0;

        for (int num : evens) {
            if (isEven(num)) {
                evenCount++;
            }
        }

        int [] evensArray = new int[evenCount];

        int i = 0;
        for (int num : evens) {
            if (isEven(num)) {
                evensArray[i++] = num;
            }
        }

        return evensArray;
    }

    public boolean isEven(int number) {
        return number % 2 == 0;
    }

    private void displayEvenNumbers(int[] evens) {
        if (evens.length == 0) {
            System.out.println("There are no even numbers.");
            return;
        }

        // print out the even numbers
        System.out.print("The even numbers are");

        for (int even : evens) {
            System.out.printf(" %d", even);
        }
        System.out.print(".");
    }
}
