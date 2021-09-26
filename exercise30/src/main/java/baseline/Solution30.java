/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 William Furie
 */

package baseline;

public class Solution30 {

    private static final String ONE_DIGIT_SPACING = "   ";
    private static final String TWO_DIGIT_SPACING = "  ";
    private static final String THREE_DIGIT_SPACING = " ";


    public static void main(String[] args) {
        Solution30 solution = new Solution30();

        // generate multiplication table
        String table = solution.generateTable(12);
        // display table
        solution.displayTable(table);
    }

    private String generateTable(int table_length) {
        StringBuilder builder = new StringBuilder();

        if (table_length > 30) {
            return "That is too big of a table for this program.";
        }

        // use a nested for loop
        // go from 1-12 in each loop
        for (int i = 1; i <= table_length; i++){
            for (int j = 1; j <= table_length; j++){
                int product = i * j;
                String productString = String.valueOf(product);

                // build the string
                // aligning each column
                builder.append(getSpacing(productString.length()));
                builder.append(product);
            }
            builder.append("\n");
        }

        // return the string
        return builder.toString();
    }

    public String getSpacing(int numberDigits) {
        if (numberDigits == 1) {
            return ONE_DIGIT_SPACING;
        } else if (numberDigits == 2) {
            return TWO_DIGIT_SPACING;
        } else {
            return THREE_DIGIT_SPACING;
        }
    }

    public void displayTable(String table) {
        // print the table
        System.out.println(table);
    }
}
