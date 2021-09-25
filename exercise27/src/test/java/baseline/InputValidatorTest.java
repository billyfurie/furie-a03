package baseline;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/sourcesFirstNameTest.csv", numLinesToSkip = 1)
    void validateFirstName(String firstName, boolean expected) {
        InputValidator validator = new InputValidator();

        boolean actual = validator.validateFirstName(firstName);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/sourcesLastNameTest.csv", numLinesToSkip = 1)
    void validateLastName(String lastName, boolean expected) {
        InputValidator validator = new InputValidator();

        boolean actual = validator.validateLastName(lastName);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/sourcesZipTest.csv", numLinesToSkip = 1)
    void validateZip(String zip, boolean expected) {
        InputValidator validator = new InputValidator();

        boolean actual = validator.validateZip(zip);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/sourcesIDTest.csv", numLinesToSkip = 1)
    void validateID(String id, boolean expected) {
        InputValidator validator = new InputValidator();

        boolean actual = validator.validateID(id);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/sourcesCharInIDTest.csv", numLinesToSkip = 1)
    void validateCharInID(char c, int index, boolean expected) {
        InputValidator validator = new InputValidator();

        boolean actual = validator.validateCharInID(index, c);

        assertEquals(expected, actual);
    }
}