package baseline;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Solution40 {

    private static final int HEADER_FIRST_NAME = 0;
    private static final int HEADER_LAST_NAME = 1;
    private static final int HEADER_POSITION = 2;
    private static final int HEADER_SEPARATION = 3;

    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Solution40 solution = new Solution40();

        // create a list of the employee maps
        List<HashMap<Integer, String>> employees = solution.createEmployeeMapList();
        // get the search string from the user
        String search = solution.getSearchFromUser();

        // filter out the results using the search string and the employee name
        List<HashMap<Integer, String>> filteredEmployees = solution.getFilteredListFromSearch(employees, search);

        // display the results to the user
        solution.displayFilteredResults(filteredEmployees);
    }

    private HashMap<Integer, String> createEmployeeMap(String firstName, String lastName, String position) {
        // create the map using the first name, last name, and position, no separation date
        HashMap<Integer, String> employee = new HashMap<>();
        employee.put(HEADER_FIRST_NAME, firstName);
        employee.put(HEADER_LAST_NAME, lastName);
        employee.put(HEADER_POSITION, position);
        employee.put(HEADER_SEPARATION, "");

        // return the map
        return employee;
    }

    public HashMap<Integer, String> createEmployeeMap(String firstName, String lastName, String position, String separationDate) {
        // create the map using the first name, last name, position, and separation date
        HashMap<Integer, String> employee = new HashMap<>();
        employee.put(HEADER_FIRST_NAME, firstName);
        employee.put(HEADER_LAST_NAME, lastName);
        employee.put(HEADER_POSITION, position);
        employee.put(HEADER_SEPARATION, separationDate);

        // return the map
        return employee;
    }

    private List<HashMap<Integer, String>> createEmployeeMapList() {
        // create a list
        List<HashMap<Integer, String>> employees = new ArrayList<>();

        // these are the employees provided by assignment
        // create maps for each employee
        HashMap<Integer, String> employee1 = createEmployeeMap("Jacquelyn", "Jackson", "DBA");
        HashMap<Integer, String> employee2 = createEmployeeMap("Jake", "Jacobson", "Programmer");
        HashMap<Integer, String> employee3 = createEmployeeMap("John", "Johnson", "Manager",
                "2016-12-31");
        HashMap<Integer, String> employee4 = createEmployeeMap("Michaela", "Michaelson",
                "District Manager", "2015-12-19");
        HashMap<Integer, String> employee5 = createEmployeeMap("Sally", "Weber", "Web Developer",
                "2015-12-18");
        HashMap<Integer, String> employee6 = createEmployeeMap("Tou", "Xiong", "Software Engineer",
                "2016-10-05");

        // add all the employee maps to the list
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);
        employees.add(employee6);

        // return the list
        return employees;
    }

    private String getSearchFromUser() {
        // prompt the user for a search string
        System.out.print("Enter a search string: ");
        // get and return this string
        return input.nextLine();
    }

    public List<HashMap<Integer, String>> getFilteredListFromSearch(List<HashMap<Integer, String>> employees, String search) {
        // create a list for the filtered employees
        List<HashMap<Integer, String>> filtered = new ArrayList<>();

        // go through the list of maps
        for (HashMap<Integer, String> employee : employees) {
            // in each of the maps, analyze the first and last name
            // check if the search string exists in either string
            if (isSearchMatch(search, employee.get(HEADER_FIRST_NAME)) || isSearchMatch(search, employee.get(HEADER_LAST_NAME))) {
                // if it does, we will add this employee to our filtered list
                filtered.add(employee);
            }
        }

        // return the filtered list
        return filtered;
    }

    public boolean isSearchMatch(String search, String word) {
        // return whether the search is inside the word
        return word.contains(search);
    }

    private void displayFilteredResults(List<HashMap<Integer, String>> list) {
        // check if the list is empty
        if (list.isEmpty()) {
            System.out.println("There are no results for your search.");
            return;
        }

        // go through each of the maps in the list

        System.out.format("%-20s| %-19s| %-16s%n", "Name", "Position", "Separation Date");
        System.out.println("--------------------|--------------------|----------------");

        for (HashMap<Integer, String> map : list) {
            String name = map.get(HEADER_FIRST_NAME) + ' ' + map.get(HEADER_LAST_NAME);
            String position = map.get(HEADER_POSITION);
            String separation = map.get(HEADER_SEPARATION);

            // print out the values in tabular form
            System.out.format("%-20s| %-19s| %-16s%n", name, position, separation);
        }
    }
}
