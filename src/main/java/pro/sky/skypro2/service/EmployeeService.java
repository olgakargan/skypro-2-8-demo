package pro.sky.skypro2.service;

import pro.sky.skypro2.demo.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee addEmployee(String firstName, String secondName, String lastName, int department, int salary);

    Employee getEmployee(String firstName, String secondName, String lastName);

    Employee removeEmployee(String firstName, String secondName, String lastName);

    Collection<Employee> getEmployees();

    Employee getEmployee(String fam, String name);

    Employee removeEmployee(String fam, String name);

    Employee addEmployee(String fam, String name, int department, int salary);
}

