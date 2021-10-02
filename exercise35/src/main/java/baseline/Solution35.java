/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 William Furie
 */

package baseline;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Solution35 {

    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Solution35 solution = new Solution35();

        // get the contestants from the user
        List<String> contestants = solution.buildContestantsList();

        // generate the winner
        String winner = solution.getWinner(contestants);

        // display the winner
        solution.displayWinner(winner);
    }

    private void displayWinner(String winner) {
        // print the winner message
        System.out.printf("The winner is... %s.%n", winner);
    }

    public String getWinner(List<String> contestants) {
        if (contestants.isEmpty()) {
            return "no one";
        }

        // generate a random number in the range of length of contestants
        Random random = new Random();
        int index = random.nextInt(contestants.size());

        // return the contestant at that index
        return contestants.get(index);
    }

    private List<String> buildContestantsList() {
        List<String> contestants = new ArrayList<>();

        // keep getting contestant names
        String contestant = getContestant();

        // add contestant to our list as long as the name is not blank
        while (!contestant.isBlank()) {
            addContestant(contestants, contestant);
            contestant = getContestant();
        }
        // if the name is blank we stop

        // return the list
        return contestants;
    }

    public void addContestant(List<String> contestants, String contestant) {
        // add contestant to the list
        contestants.add(contestant);
    }

    private String getContestant() {
        // get the contestants name from the user
        System.out.print("Enter a name: ");
        // return the contestants name
        return input.nextLine();
    }
}
