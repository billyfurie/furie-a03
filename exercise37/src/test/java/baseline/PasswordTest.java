package baseline;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class PasswordTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/sourcesGetOpenIndex.csv", numLinesToSkip = 1)
    void getOpenIndex(int passwordLength) {

        Password password = new Password(passwordLength, 0, 0);

        for (int i = 0; i < passwordLength; i++) {
            int index = password.getOpenIndex();
            assert index < passwordLength;
        }
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/sourcesGeneratePasswordFoundation.csv", numLinesToSkip = 1)
    void generatePasswordFoundation(int passwordLength) {
        Password password = new Password(passwordLength, 0, 0);
        password.generatePasswordFoundation();
        String pass = password.getPassword();

        for (char c : pass.toCharArray()) {
            assert Character.isLetter(c);
        }
    }

    @Test
    void generateRandomLetter() {
        Password password = new Password(8, 0, 0);

        assert (Character.isLetter(password.generateRandomLetter()));
    }

    @Test
    void generateRandomDigit() {
        Password password = new Password(2, 0, 0);

        for (int i = 0; i < 20; i++) {
            assert (Character.isDigit(password.generateRandomDigit()));
        }
    }

    @Test
    void generateRandomSpecial() {
        Password password = new Password(2, 0, 0);

        for (int i = 0; i < 20; i++) {
            char special = password.generateRandomSpecial();
            assert (!Character.isLetter(special) && !Character.isDigit(special));
        }
    }
}