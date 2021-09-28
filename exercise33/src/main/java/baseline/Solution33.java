/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 William Furie
 */

package baseline;

import java.util.Random;
import java.util.Scanner;

public class Solution33 {

    // have constants for the possible answers
    private static final String ANSWER_YES = "Yes.";
    private static final String ANSWER_NO = "No.";
    private static final String ANSWER_MAYBE = "Maybe.";
    private static final String ANSWER_NOT_NOW = "Ask again later.";
    private static final int NUM_ANSWERS = 4;

    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Solution33 solution = new Solution33();

        // create our answer bank (not user based)
        String[] bank = solution.createAnswerBank(ANSWER_YES, ANSWER_NO, ANSWER_MAYBE, ANSWER_NOT_NOW);

        // get the question from the user
        solution.getQuestionFromUser();

        // get the answer (does not actually rely on question)
        String answer = solution.getAnswer(bank);

        // display answer from our answer bank
        solution.displayAnswer(answer);
    }

    private void displayAnswer(String answer) {
        // We want a line of space between question and answer
        System.out.printf("%n%s", answer);
    }

    public String getAnswer(String[] answerBank) {
        if (answerBank == null) {
            return "";
        }

        // index is random int
        int index = getRandomInt(NUM_ANSWERS);
        // return the answer of our random index
        return answerBank[index];
    }

    public String[] createAnswerBank(String ... answers) {
        String[] bank = new String[answers.length];
        // create a list of answers
        int index = 0;
        for (String answer : answers) {
            bank[index++] = answer;
        }

        // return the list
        return bank;
    }

    public int getRandomInt(int range) {
        // use library to return a random integer from 0 to n
        Random random = new Random();

        return random.nextInt(range);
    }

    private void getQuestionFromUser() {
        // prompt for question
        System.out.print("What's your question?\n> ");
        // we actually don't care to store the users question.
        input.nextLine();
    }
}
