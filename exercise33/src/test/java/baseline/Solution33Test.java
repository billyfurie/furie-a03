package baseline;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Solution33Test {

    @Test
    void getAnswer() {
        Solution33 solution = new Solution33();

        String[] values = {"Hello", "This", "Is", "A", "Test"};

        for (int i = 0; i < 50; i++) {
            String value = solution.getAnswer(values);

            // make sure the result we got randomly is in the array
            assertTrue(Arrays.asList(values).contains(value));
        }
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/sourcesCreateAnswerBank.csv", numLinesToSkip = 1)
    void createAnswerBank(String a, String b, String c) {
        Solution33 solution = new Solution33();

        String[] expectedOne = {a};
        String[] actualOne = solution.createAnswerBank(a);

        String[] expectedTwo = {a, b};
        String[] actualTwo = solution.createAnswerBank(a, b);

        String[] expectedThree = {a, b, c};
        String[] actualThree = solution.createAnswerBank(a, b, c);

        assertArrayEquals(actualOne, expectedOne);
        assertArrayEquals(actualTwo, expectedTwo);
        assertArrayEquals(actualThree, expectedThree);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/sourcesGetRandomInt.csv", numLinesToSkip = 1)
    void getRandomInt(int range) {
        Solution33 solution = new Solution33();

        for (int i = 0; i < 50; i++) {
            int actual = solution.getRandomInt(range);

            assertTrue(actual >=0 && actual < range);
        }
    }
}