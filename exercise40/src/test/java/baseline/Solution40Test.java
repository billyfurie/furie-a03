package baseline;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class Solution40Test {

    @ParameterizedTest
    @CsvFileSource(resources = "/sourcesCreateEmployeeMap.csv", numLinesToSkip = 1)
    void createEmployeeMap(String firstName, String lastName, String position, String date) {
        Solution40 solution = new Solution40();

        HashMap<Integer, String> expected = new HashMap<>();
        expected.put(0, firstName);
        expected.put(1, lastName);
        expected.put(2, position);
        expected.put(3, date);

        HashMap<Integer, String> actual = solution.createEmployeeMap(firstName, lastName, position, date);

        assertArrayEquals(expected.values().toArray(), actual.values().toArray());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/sourcesGetFilteredListFromSearch.csv", numLinesToSkip = 1)
    void getFilteredListFromSearch(String firstName1, String lastName1,
                                   String firstName2, String lastName2,
                                   String firstName3, String lastName3,
                                   String search, int filteredOutEmployeeNumber) {
        Solution40 solution = new Solution40();

        List<HashMap<Integer, String>> employees = new ArrayList<>();
        employees.add(solution.createEmployeeMap(firstName1, lastName1, "", ""));
        employees.add(solution.createEmployeeMap(firstName2, lastName2, "", ""));
        employees.add(solution.createEmployeeMap(firstName3, lastName3, "", ""));


        List<HashMap<Integer, String>> actual = solution.getFilteredListFromSearch(employees, search);
        List<HashMap<Integer, String>> expected = new ArrayList<>();

        if (filteredOutEmployeeNumber == 1) {
            expected.add(solution.createEmployeeMap(firstName1, lastName1, "", ""));
        } else if (filteredOutEmployeeNumber == 2) {
            expected.add(solution.createEmployeeMap(firstName2, lastName2, "", ""));
        } else {
            expected.add(solution.createEmployeeMap(firstName3, lastName3, "", ""));
        }

        assertArrayEquals(actual.toArray(), expected.toArray());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/sourcesIsSearchMatch.csv", numLinesToSkip = 1)
    void isSearchMatch(String search, String word, boolean expected) {
        Solution40 solution = new Solution40();

        boolean actual = solution.isSearchMatch(search, word);

        assertEquals(expected, actual);
    }
}