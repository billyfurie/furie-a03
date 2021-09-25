package baseline;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class Solution29Test {

    @ParameterizedTest
    @CsvFileSource(resources = "/sourcesLengthToDoubleInvestment.csv", numLinesToSkip = 1)
    void calculateLengthToDoubleInvestment(double rate, double expected) {
        Solution29 solution = new Solution29();

        double actual = solution.calculateLengthToDoubleInvestment(rate);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/sourcesIsRateValid.csv", numLinesToSkip = 1)
    void isRateValid(String rate, boolean expected) {
        Solution29 solution = new Solution29();

        boolean actual = solution.isRateValid(rate);

        assertEquals(expected, actual);
    }
}