package baseline;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class Solution28Test {

    @ParameterizedTest
    @CsvFileSource(resources = "/sourcesAddNumbers.csv", numLinesToSkip = 1)
    void addNumbers(int num1, int num2, int num3, int num4, int num5, int expectedTotal) {
        int[] numbers = new int[5];
        numbers[0] = num1;
        numbers[1] = num2;
        numbers[2] = num3;
        numbers[3] = num4;
        numbers[4] = num5;

        Solution28 solution = new Solution28();

        int actualTotal = solution.addNumbers(numbers);

        assertEquals(expectedTotal, actualTotal);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/sourcesIsValidNumber.csv", numLinesToSkip = 1)
    void isValidNumber(String number, boolean expected) {
        Solution28 solution = new Solution28();

        boolean actual = solution.isValidNumber(number);

        assertEquals(expected, actual);
    }
}