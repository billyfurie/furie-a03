/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 William Furie
 */

package baseline;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class Solution39 {

    private static final int HEADER_FIRST_NAME = 0;
    private static final int HEADER_LAST_NAME = 1;
    private static final int HEADER_POSITION = 2;
    private static final int HEADER_SEPARATION = 3;

    public static void main(String[] args) {
        Solution39 solution = new Solution39();

        // get the list of employee maps
        List<HashMap<Integer, String>> employees = solution.createEmployeeMapList();
        // sort the map by last name
        List<HashMap<Integer, String>> employeesSortedByLastName = solution.getListSortedByLastName(employees);
        // display the map
        solution.displayList(employeesSortedByLastName);
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

    public List<HashMap<Integer, String>> getListSortedByLastName(List<HashMap<Integer, String>> employees) {
        List<HashMap<Integer, String>> sorted = new ArrayList<>();

        // for each employee, look at the last name
        int index = 0;
        for (HashMap<Integer, String> employee : employees) {
            // add to the list
            sorted.add(employee);

            // this sorts
            // while this last name comes before the one before it, we are going to swap those names
            // store this index because we might need to go down the line to make swaps
            int original = index;
            while (index > 0 && comesBefore(employee.get(HEADER_LAST_NAME), sorted.get(index - 1).get(HEADER_LAST_NAME))) {
                swapMapsInList(sorted, index, index - 1);
                index--;
            }
            index = original + 1;
        }

        // after going through all employees, we return the sorted list
        return sorted;
    }

    public void swapMapsInList(List<HashMap<Integer, String>> list, int index1, int index2) {
        // swap the maps in the list at the specified indices

        HashMap<Integer, String> temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
    }

    // does inQuestion come before comparedTo alphabetically
    public boolean comesBefore(String inQuestion, String comparedTo) {
        return inQuestion.toUpperCase().compareTo(comparedTo.toUpperCase()) < 0;
    }

    private void displayList(List<HashMap<Integer, String>> list) {
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
