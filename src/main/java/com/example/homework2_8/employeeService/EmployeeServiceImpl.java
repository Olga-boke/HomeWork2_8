package com.example.homework2_8.employeeService;

import com.example.homework2_8.exception.EmployeeAlreadyAddedException;
import com.example.homework2_8.exception.EmployeeNotFoundException;
import com.example.homework2_8.model.Employee;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {


        private final List<Employee> employeeList;

        public EmployeeServiceImpl() {
            this.employeeList = new ArrayList<>();
        }
        @Override
        public Employee add(String firstName, String lastName, int salary, int department) {
            Employee employee = new Employee(firstName, lastName, salary, department);
            if (employeeList.contains(employee)) {
                throw new EmployeeAlreadyAddedException(" Такой сотрудник уже есть");}
            employeeList.add(employee);
            return employee;
        }
        @Override
        public Employee remove(String firstName, String lastName) {
            Employee employee = find(firstName,lastName);
            if (employeeList.contains(employee)) {
                employeeList.remove(employee);
                return employee;
            }
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
    @Override
    public Employee find(String firstName, String lastName) {
        final Optional<Employee> employee = employeeList.stream()
                .filter(e -> e.getFirstName().equals(firstName) && e.getLastName().equals(lastName))
                .findAny();
        return employee.orElseThrow(() -> new EmployeeNotFoundException("Сотрудник не найден"));
        }
    @Override
    public Employee getLowestPaid(int department) {
        return employeeList.stream()
                .filter(e -> e.getDepartment() == department)
                .min(Comparator.comparingInt(e -> e.getSalary()))
                .orElseThrow(() -> new EmployeeNotFoundException("Сотрудник не найден"));
        }
    @Override
    public Employee getHighestPaid(int department) {
        return employeeList.stream()
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparingInt(e -> e.getSalary()))
                .orElseThrow(() -> new EmployeeNotFoundException("Сотрудник не найден"));
        }
    @Override
    public List<Employee> printForDepartment(int department) {
        return employeeList.stream()
                .filter(e -> e.getDepartment() == department)
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> printByDepartments() {
        return Collections.unmodifiableList(employeeList.stream()
                .sorted(Comparator.comparingInt(e -> e.getDepartment()))
                .collect(Collectors.toList()));
    }

    @Override
    public List<Employee> printAll() {
        return Collections.unmodifiableList(employeeList);
        }
    @Override
    public List<Employee> fillEmployeesList() {
        employeeList.add(new Employee("Ivan", "Ivanov", 50_000, 1));
        employeeList.add(new Employee("Vasiliy", "Petrov", 40_000, 1));
        employeeList.add(new Employee("Petr", "Perviy", 90_000, 2));
        employeeList.add(new Employee("Ivan", "Grozniy", 100_000, 2));
        employeeList.add(new Employee("Ekaterina", "Velikaya", 120_000, 2));
        return employeeList;
    }
}




