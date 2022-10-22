package pro.sky.skypro2.service;

import pro.sky.skypro2.demo.Employee;

import java.util.List;

public interface DepartmentService {
    Employee getMaxSalaryEmployee(Integer department);

    Employee getMinSalaryEmployee(Integer department);

    // return list of all Employees, when department == null
    List<Employee> getAllEmployees(Integer department);
}
