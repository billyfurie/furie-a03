package baseline;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Solution38Test {

    @ParameterizedTest
    @CsvFileSource(resources = "/sourcesFilterEvenNumbers.csv", numLinesToSkip = 1)
    void filterEvenNumbers(String numbers, int even1, int even2, int even3) {
        Solution38 solution = new Solution38();

        char[] numCharArray = solution.getCharArrayFromString(numbers);

        int[] actual = solution.filterEvenNumbers(numCharArray);

        int evenCount = 3;

        // 2 numbers will be even
        int[] expected = new int[evenCount];
        expected[0] = even1;
        expected[1] = even2;
        expected[2] = even3;

        assertArrayEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/sourcesGetEvensArrayFromList.csv", numLinesToSkip = 1)
    void getEvensArrayFromList(int even1, int even2, int odd1) {
        Solution38 solution = new Solution38();

        List<Integer> numbers = new ArrayList<>();
        numbers.add(even1);
        numbers.add(even2);
        numbers.add(odd1);

        int[] expected = new int[2];
        expected[0] = even1;
        expected[1] = even2;

        int[] actual = solution.getEvensArrayFromList(numbers);

        assertArrayEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/sourcesIsEven.csv", numLinesToSkip = 1)
    void isEven(int number, boolean expected) {
        Solution38 solution = new Solution38();

        boolean actual = solution.isEven(number);

        assertEquals(expected, actual);
    }
}