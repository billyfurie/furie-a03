package baseline;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class PasswordRequirementsTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/sourcesIsValidForPassword.csv", numLinesToSkip = 1)
    void isValidForPassword(int length, int numSpecials, int numNumbers, boolean expected) {
        boolean actual = PasswordRequirements.isValidForPassword(length, numSpecials, numNumbers);

        assertEquals(expected, actual);
    }
}