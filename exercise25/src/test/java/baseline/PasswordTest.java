package baseline;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class PasswordTest {

    @ParameterizedTest
    @ValueSource(strings = {"123", "342166", "000000", "998877", "0"})
    void passwordValidator1(String str) {
        Password password = new Password(str);

        int expected = Password.VERY_WEAK;
        int actual = password.passwordValidator();

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Billy", "BillyF", "passed", "enter", "testing"})
    void passwordValidator2(String str) {
        Password password = new Password(str);

        int expected = Password.WEAK;
        int actual = password.passwordValidator();

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Billy123", "password77335", "123pass123", "pleaseenter7", "testing55"})
    void passwordValidator3(String str) {
        Password password = new Password(str);

        int expected = Password.STRONG;
        int actual = password.passwordValidator();

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Billy123!!", "^^password77335^^", "123&pass&123", "pleaseenter7??", "testing55..."})
    void passwordValidator4(String str) {
        Password password = new Password(str);

        int expected = Password.VERY_STRONG;
        int actual = password.passwordValidator();

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"!@#%^", "123345567789", "123$$", "12345%$#@!", "test!"})
    void passwordValidator5(String str) {
        Password password = new Password(str);

        int expected = Password.UNKNOWN_STRENGTH;
        int actual = password.passwordValidator();

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "342166", "000000", "998877", "0"})
    void getPasswordStrength1(String str) {
        Password password = new Password(str);

        String expected = " very weak";
        String actual = password.getPasswordStrength();

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Billy", "BillyF", "passed", "enter", "testing"})
    void getPasswordStrength2(String str) {
        Password password = new Password(str);

        String expected = " weak";
        String actual = password.getPasswordStrength();

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Billy123", "password77335", "123pass123", "pleaseenter7", "testing55"})
    void getPasswordStrength3(String str) {
        Password password = new Password(str);

        String expected = " strong";
        String actual = password.getPasswordStrength();

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Billy123!!", "^^password77335^^", "123&pass&123", "pleaseenter7??", "testing55..."})
    void getPasswordStrength4(String str) {
        Password password = new Password(str);

        String expected = " very strong";
        String actual = password.getPasswordStrength();

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"!@#%^", "123345567789", "123$$", "12345%$#@!", "test!"})
    void getPasswordStrength5(String str) {
        Password password = new Password(str);

        String expected = "n unknown strength";
        String actual = password.getPasswordStrength();

        assertEquals(expected, actual);
    }
}