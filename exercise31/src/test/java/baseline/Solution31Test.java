package baseline;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class Solution31Test {

    @ParameterizedTest
    @CsvFileSource(resources = "/sourcesIsStringInteger.csv", numLinesToSkip = 1)
    void isStringInteger(String number, boolean expected) {
        Solution31 solution = new Solution31();

        boolean actual = solution.isStringInteger(number);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/sourcesGetTargetHeartRate.csv", numLinesToSkip = 1)
    void getTargetHeartRate(int age, int restingHR, double intensity, int expected) {
        Solution31 solution = new Solution31();

        int actual = solution.getTargetHeartRate(age, restingHR, intensity);

        assertEquals(expected, actual);
    }
}