package com.example.homework2_8.controller;

import com.example.homework2_8.employeeService.EmployeeService;
import com.example.homework2_8.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

        private final EmployeeService employeeService;

        public EmployeeController(EmployeeService employeeService) {
            this.employeeService = employeeService;
        }

    @GetMapping(path = "/add")
    public Object addEmployee(
            @RequestParam(value = "firstName") String firstName,
            @RequestParam(value = "lastName") String lastName,
            @RequestParam(value = "salary") int salary,
            @RequestParam(value = "department") int department) {
        Employee employee = null;
        try {
            employee = employeeService.add(firstName, lastName, salary, department);
        } catch (Throwable e) {
            return e.getMessage();
        }
        return employee;
        }

    @GetMapping(path = "/remove")
    public Object removeEmployee(
            @RequestParam(value = "firstName") String firstName,
            @RequestParam(value = "lastName") String lastName) {
        Employee employee = null;
        try {
            employee = employeeService.remove(firstName, lastName);
        } catch (Throwable e) {
            return e.getMessage();
        }
        return employee;
        }

    @GetMapping(path = "/find")
    public Object findEmployee(
            @RequestParam(value = "firstName") String firstName,
            @RequestParam(value = "lastName") String lastName) {
        Employee employee = null;
        try {
            employee = employeeService.find(firstName, lastName);
        } catch (Throwable e) {
            return e.getMessage();
        }
        return employee;
        }

    @GetMapping(path = "/departments/max-salary")
    public Object getHighestPaidEmployee(
            @RequestParam(value = "departmentId") int departmentId) {
        Employee employee = null;
        try {
            employee = employeeService.getLowestPaid(departmentId);
        } catch (Throwable e) {
            return e.getMessage();
        }
        return employee;
        }

    @GetMapping(path = "/departments/min-salary")
    public Object getLowestPaidEmployee(
            @RequestParam(value = "departmentId") int departmentId) {
        Employee employee = null;
        try {
            employee = employeeService.getHighestPaid(departmentId);
        } catch (Throwable e) {
            return e.getMessage();
        }
        return employee;
        }

    @GetMapping(path = "/departments/all", params = "departmentId")
    public Object printEmployeesForDepartment(
            @RequestParam(value = "departmentId") int departmentId) {
        List<Employee> employeeList = null;
        try {
            employeeList = employeeService.printForDepartment(departmentId);
        } catch (Throwable e) {
            return e.getMessage();
        }
        return employeeList;
        }

    @GetMapping(path = "/departments/all")
    public Object printEmployeesByDepartments() {
        List<Employee> employeeList = null;
        try {
            employeeList = employeeService.printByDepartments();
        } catch (Throwable e) {
            return e.getMessage();
        }
        return employeeList;
        }


    @GetMapping(path = "/print")
    public Object printEmployees() {
        List<Employee> employeeList = null;
        try {
            employeeList = employeeService.printAll();
        } catch (Throwable e) {
            return e.getMessage();
        }
        return employeeList;
        }

    @GetMapping(path = "/fill")
    public Object fillEmployeesList() {
        List<Employee> employeeList = null;
        try {
            employeeList = employeeService.fillEmployeesList();
        } catch (Throwable e) {
            return e.getMessage();
        }
        return employeeList;
        }



    }
