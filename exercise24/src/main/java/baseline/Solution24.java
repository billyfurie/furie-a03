/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 William Furie
 */

package baseline;

import java.util.Arrays;
import java.util.Scanner;

public class Solution24 {

    /*
        getStringFromUser(prompt)
            print(prompt)
            string = get string from user
            return string

        displayPrompt(prompt)
            print(prompt)

        displayResults(string1, string2, isAnagram)
            if isAnagram
                print("`string1` and `string2` are anagrams.")
            else
                print("`string1` and `string2` are  not anagrams.")

        isAnagram(string1, string2)
            if string1.length() != string2.length()
                return False

            sort string1
            sort string2

            return string1 same as string2
     */

    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Solution24 solution = new Solution24();

        solution.displayPrompt("Enter two strings and I'll tell you if they are anagrams:");
        String str1 = solution.getStringFromUser("Enter the first string: ");
        String str2 = solution.getStringFromUser("Enter the second string: ");

        boolean isAna = solution.isAnagram(str1, str2);

        solution.displayResults(str1, str2, isAna);
    }

    private String getStringFromUser(String prompt) {
        System.out.print(prompt);

        return input.nextLine();
    }

    private void displayPrompt(String prompt) {
        System.out.println(prompt);
    }

    private void displayResults(String string1, String string2, boolean isAna) {
        System.out.printf("%s and %s are ", string1, string2);

        if (!isAna) {
            System.out.print("not ");
        }
        System.out.println("anagrams.");
    }

    public boolean isAnagram(String string1, String string2) {
        if (string1 == null || string2 == null || string1.length() != string2.length()) {
            return false;
        }

        char[] arr1 = string1.toCharArray();
        char[] arr2 = string2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }
}
