package baseline;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Solution34Test {

    @ParameterizedTest
    @CsvFileSource(resources = "/sourcesCreateListOfEmployees.csv", numLinesToSkip = 1)
    void createListOfEmployees(String employee1, String employee2, String employee3) {
        Solution34 solution = new Solution34();

        List<String> expected = new ArrayList<>();
        expected.add(employee1);
        expected.add(employee2);
        expected.add(employee3);

        List<String> actual = solution.createListOfEmployees(employee1, employee2, employee3);

        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/sourcesRemoveEmployee.csv", numLinesToSkip = 1)
    void removeEmployee(String employee1, String employee2, String employeeToRemove, boolean employeeExists) {
        Solution34 solution = new Solution34();

        List<String> original;
        List<String> expected;

        if (employeeExists) {
            expected = solution.createListOfEmployees(employee1, employee2, employeeToRemove);
            original = solution.createListOfEmployees(employee1, employee2, employeeToRemove);
        } else {
            expected = solution.createListOfEmployees(employee1, employee2);
            original = solution.createListOfEmployees(employee1, employee2);
        }

        List<String> actual = solution.createListOfEmployees(employee1, employee2);

        solution.removeEmployee(expected, employeeToRemove);

        if (employeeExists) {
            assertArrayEquals(expected.toArray(), actual.toArray());
        } else {
            // we shouldn't have removed any employees if they don't exist
            assertArrayEquals(original.toArray(), expected.toArray());
        }

    }
}