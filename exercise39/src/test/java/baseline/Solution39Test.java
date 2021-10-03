package baseline;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Solution39Test {

    @ParameterizedTest
    @CsvFileSource(resources = "/sourceCreateEmployeeMap.csv", numLinesToSkip = 1)
    void createEmployeeMap(String firstName, String lastName, String position, String date) {
        Solution39 solution = new Solution39();

        HashMap<Integer, String> expected = new HashMap<>();
        expected.put(0, firstName);
        expected.put(1, lastName);
        expected.put(2, position);
        expected.put(3, date);

        HashMap<Integer, String> actual = solution.createEmployeeMap(firstName, lastName, position, date);

        assertArrayEquals(expected.values().toArray(), actual.values().toArray());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/sourcesGetListSortedByLastName.csv", numLinesToSkip = 1)
    void getListSortedByLastName(String lastName1, String lastName2, String lastName3, String lastName4) {
        Solution39 solution = new Solution39();
        String firstName = "test";
        String position = "test";
        String date = "test";

        // create our list of employees, only changing the last name
        List<HashMap<Integer, String>> employees = new ArrayList<>();

        employees.add(solution.createEmployeeMap(firstName, lastName1, position, date));
        employees.add(solution.createEmployeeMap(firstName, lastName2, position, date));
        employees.add(solution.createEmployeeMap(firstName, lastName3, position, date));
        employees.add(solution.createEmployeeMap(firstName, lastName4, position, date));

        // sort the employee list
        List<HashMap<Integer, String>> sorted = solution.getListSortedByLastName(employees);

        // create list of last names and find which should come first
        String[] lastNames = new String[4];
        lastNames[0] = lastName1;
        lastNames[1] = lastName2;
        lastNames[2] = lastName3;
        lastNames[3] = lastName4;

        Arrays.sort(lastNames);

        String expected = lastNames[0];

        // get the firstEmployee.lastName
        String actual = sorted.get(0).get(1);

        assertEquals(expected, actual);
    }

    @Test
    void swapMapsInList() {
        Solution39 solution = new Solution39();

        List<HashMap<Integer, String>> list = new ArrayList<>();

        HashMap<Integer, String> employee1 = new HashMap<>();
        HashMap<Integer, String> employee2 = new HashMap<>();

        String originalFirst = "Number One";
        String originalSecond = "Number Two";

        employee1.put(0, originalFirst);
        employee2.put(0, originalSecond);

        list.add(employee1);
        list.add(employee2);

        solution.swapMapsInList(list, 0, 1);

        // ensure that the values of the two have swapped
        assertEquals(list.get(0).get(0), originalSecond);
        assertEquals(list.get(1).get(0), originalFirst);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/sourcesComesBefore.csv", numLinesToSkip = 1)
    void comesBefore(String inQuestion, String comparedTo, boolean expected) {
        Solution39 solution = new Solution39();

        boolean actual = solution.comesBefore(inQuestion, comparedTo);

        assertEquals(expected, actual);
    }
}