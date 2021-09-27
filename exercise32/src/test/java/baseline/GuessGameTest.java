package baseline;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class GuessGameTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/sourcesGenerateNumber.csv", numLinesToSkip = 1)
    void generateNumber(int difficulty, int lowerBound, int upperBound) {
        GuessGame game = new GuessGame(difficulty);

        for (int i = 0; i < 50; i++) {
            game.generateNumber();
            int num = game.getNumber();
            boolean inBounds = num >= lowerBound && num <= upperBound;
            assertTrue(inBounds);
        }
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/sourcesCheckIfNumber.csv", numLinesToSkip = 1)
    void checkIfNumber(String number, boolean expected) {
        GuessGame game = new GuessGame(1);

        boolean actual = game.checkIfNumber(number);

        assertEquals(expected, actual);
    }
}