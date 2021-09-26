package baseline;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class Solution30Test {

    @ParameterizedTest
    @CsvFileSource(resources = "/sourcesGetSpacing.csv", numLinesToSkip = 1)
    void getSpacing(int length, String expected) {
        Solution30 solution = new Solution30();

        String actual = solution.getSpacing(length);

        assertEquals(expected, actual);
    }
}