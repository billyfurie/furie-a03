/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 William Furie
 */

package baseline;

public class Solution31 {

    public static void main(String[] args) {
        // prompt the user for age and resting heart rate
        // build the heart rate table
        // display the heart rate table to the user
    }

    private int getIntegerFromUser(String prompt){
        // read string from user
        // if string is not integer, prompt again
        // return the integer

        // placeholder
        return 0;
    }

    public boolean isStringInteger(String number) {
        // check if rate is an integer or not

        // placeholder
        return false;
    }

    public int getTargetHeartRate(int age, int restingHR, double intensity) {
        // use formula
        // TargetHeartRate = (((220 − age) − restingHR) × intensity) + restingHR

        // calculate, then return target heart rate

        // placeholder
        return 0;
    }

    public String buildHeartRateTable(int age, int restingHR) {
        // use string builder
        // build the header rows
        // build the standard rows using a loop

        // placeholder
        return "";
    }

    public String buildHeartRateTableRow(double intensity, int restingHR) {
        // build the row using string builder in the specified format
        // return the row

        // placeholder
        return "";
    }

    private void displayHeartRateTable(String table) {
        System.out.println(table);
    }
}
