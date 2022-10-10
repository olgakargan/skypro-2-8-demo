package pro.sky.skypro2.demo;

import java.util.List;

public interface EmployeeService {

    Employee addEmployee(String fam, String name, int salary, int department);

    Employee removeEmployee(String fam, String name);

    Employee findEmployee(String fam, String name);

    Employee getHighestPaidEmployee(int departmentId);

    Employee getLowestPaidEmployee(int departmentId);

    List<Employee> printEmployeesForDepartment(int departmentId);

    List<Employee> printEmployeesByDepartments();

    List<Employee> printEmployees();

    List<Employee> fillEmployeesList();


    public interface employeeService {
        Employee addEmployee(String fam, String name, int salary, int department) throws EmployeeAlreadyAddedException;

        Employee removeEmployee(String fam, String name) throws EmployeeAlreadyAddedException;

        Employee findEmployee(String fam, String name) throws EmployeeAlreadyAddedException;

        Employee getLowestPaidEmployee(int department);

        Employee getHighestPaidEmployee(int department);

        List<Employee> printEmployeesForDepartment(int department);

        List<Employee> printEmployeesByDepartments();

        List<Employee> printEmployees();

        List<Employee> fillEmployeesList();
    }
}

