/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 William Furie
 */

package baseline;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution34 {

    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Solution34 solution = new Solution34();

        // create our list of employees
        List<String> employeeList = solution.createListOfEmployees("John Smith", "Jackie Jackson",
                "Chris Jones", "Amanda Cullen", "Jeremy Goodwin");

        // display the list to the user
        solution.displayListOfEmployees(employeeList);
        // prompt the user for an employee to remove
        String employeeToRemove = solution.getEmployeeToRemove();
        // delete the employee if they exist
        solution.removeEmployee(employeeList, employeeToRemove);
        // display the updated list
        solution.displayListOfEmployees(employeeList);
    }

    public List<String> createListOfEmployees(String ... employees) {
        // return the list
        // converts our input to a list
        return new ArrayList<>(Arrays.stream(employees).toList());
    }

    private void displayListOfEmployees(List<String> list) {
        // print out the list of employees
        System.out.printf("There are %d employees.%n", list.size());

        for (String employee : list) {
            System.out.println(employee);
        }

        System.out.println();
    }

    private String getEmployeeToRemove() {
        // prompt the user
        System.out.print("Enter an employee name to remove: ");
        // get a name from the user
        String employee = input.nextLine();
        System.out.println();
        // return the name
        return employee;
    }

    public void removeEmployee(List<String> list, String employee) {
        // check if employee is in list
        // if they are not, display a message telling the user
        if (!list.contains(employee)) {
            System.out.printf("There is not an employee named %s%n%n", employee);
        }

        // if they are, we remove them
        list.remove(employee);
    }
}
