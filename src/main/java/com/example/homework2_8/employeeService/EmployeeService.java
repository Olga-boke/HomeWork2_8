package com.example.homework2_8.employeeService;

import com.example.homework2_8.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee add(String firstName, String lastName, int salary, int department);

    Employee remove(String firstName, String lastName);

    Employee find(String firstName, String lastName);

    Employee getLowestPaid(int department);

    Employee getHighestPaid(int department);

    List<Employee> printForDepartment(int department);

    List<Employee> printByDepartments();

    List<Employee> printAll();

    List<Employee> fillEmployeesList();

    private void validateInput(String firstName, String lastName) {

    }
}
