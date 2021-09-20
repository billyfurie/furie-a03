/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 William Furie
 */

package baseline;

import java.util.Scanner;

public class Solution25 {

    /*
        class Password(string)
            containsNumber = false
            containsSpecial = false
            containsLetter = false
            length

            scanPassword()
                for character in string
                    if isDigit(character)
                        containsNumber = true
                    else if isAlpha(character)
                        containsLetter = true
                    else
                        containsSpecial = true

            calculateStrength()
                if onlyNumbers() and < 8 chars
                    strength = very weak
                else if onlyLetters() and < 8 chars
                    strength = weak
                else if containsLetter and containsNumber and !containsSpecial and >= 8 chars
                    strength = strong
                else if containsAll()
                    return very strong
                else
                    return unknown strength



            onlyLetters()
                return containsLetter and !containsNumber and !containsSpecial

            onlyNumbers()
                return containsNumber and !containsLetter and !containsSpecial

            containsAll()
                return containsNumber and containsLetter and containsSpecial

            getStrengthString

     */

    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Solution25 solution = new Solution25();

        Password password = solution.getPasswordFromUser();

        solution.displayStrengthMessage(password);
    }

    private Password getPasswordFromUser() {
        System.out.print("Please enter your password: ");

        String pass = input.nextLine();

        return new Password(pass);
    }

    private void displayStrengthMessage(Password password) {
        String strength = password.getPasswordStrength();
        String pass = password.getPassword();

        System.out.printf("The password '%s' is a%s password.", pass, strength);
    }
}
