package baseline;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Solution36Test {

    @ParameterizedTest
    @CsvFileSource(resources = "/sourcesStd.csv", numLinesToSkip = 1)
    void std(double num1, double num2, double num3, double num4, double num5, double expected) {
        Solution36 solution = new Solution36();

        List<Double> numbers = createList(num1, num2, num3, num4, num5);

        double actual = solution.std(numbers);

        assertEquals(expected, actual, .001);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/sourcesMax.csv", numLinesToSkip = 1)
    void max(double num1, double num2, double num3, double num4, double num5, double expected) {
        Solution36 solution = new Solution36();

        List<Double> numbers = createList(num1, num2, num3, num4, num5);

        double actual = solution.max(numbers);

        assertEquals(expected, actual, .001);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/sourcesMin.csv", numLinesToSkip = 1)
    void min(double num1, double num2, double num3, double num4, double num5, double expected) {
        Solution36 solution = new Solution36();

        List<Double> numbers = createList(num1, num2, num3, num4, num5);

        double actual = solution.min(numbers);

        assertEquals(expected, actual, .001);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/sourcesAverage.csv", numLinesToSkip = 1)
    void average(double num1, double num2, double num3, double num4, double num5, double expected) {
        Solution36 solution = new Solution36();

        List<Double> numbers = createList(num1, num2, num3, num4, num5);

        double actual = solution.average(numbers);

        assertEquals(expected, actual, .001);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/sourcesIsNumber.csv", numLinesToSkip = 1)
    void isNumber(String number, boolean expected) {
        Solution36 solution = new Solution36();

        boolean actual = solution.isNumber(number);

        assertEquals(expected, actual);
    }

    List<Double> createList(double... numbers) {
        List<Double> list = new ArrayList<>();

        for (double num : numbers) {
            list.add(num);
        }

        return list;
    }
}