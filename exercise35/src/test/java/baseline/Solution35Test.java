package baseline;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Solution35Test {

    @ParameterizedTest
    @CsvFileSource(resources = "/sourcesGetWinner.csv", numLinesToSkip = 1)
    void getWinner(String contestant1, String contestant2, String contestant3) {
        Solution35 solution = new Solution35();

        List<String> contestants = new ArrayList<>();
        // add the 3 contestants we are going to have
        solution.addContestant(contestants, contestant1);
        solution.addContestant(contestants, contestant2);
        solution.addContestant(contestants, contestant3);

        String winner = solution.getWinner(contestants);

        // make sure that the winner is actually one of the contestants
        assert (contestants.contains(winner));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/sourcesAddContestant.csv", numLinesToSkip = 1)
    void addContestant(String contestant1, String contestant2, String contestant3) {
        Solution35 solution = new Solution35();

        List<String> expected = new ArrayList<>();
        List<String> actual = new ArrayList<>();

        expected.add(contestant1);
        expected.add(contestant2);
        expected.add(contestant3);

        solution.addContestant(actual, contestant1);
        solution.addContestant(actual, contestant2);
        solution.addContestant(actual, contestant3);

        assertArrayEquals(expected.toArray(), actual.toArray());
    }
}