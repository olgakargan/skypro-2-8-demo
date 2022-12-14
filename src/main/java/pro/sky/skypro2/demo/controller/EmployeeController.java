package pro.sky.skypro2.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skypro2.demo.Employee;
import pro.sky.skypro2.demo.EmployeeService;

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
            @RequestParam(value = "fam") String fam,
            @RequestParam(value = "name") String name,
            @RequestParam(value = "salary") int salary,
            @RequestParam(value = "department") int department) {
        Employee employee;
        try {
            employee = employeeService.addEmployee(fam, name, salary, department);
        } catch (Throwable e) {
            return e.getMessage();
        }
        return employee;
    }

    @GetMapping(path = "/remove")
    public Object removeEmployee(
            @RequestParam(value = "fame") String fam,
            @RequestParam(value = "name") String name) {
        Employee employee;
        try {
            employee = employeeService.removeEmployee(fam, name);
        } catch (Throwable e) {
            return e.getMessage();
        }
        return employee;
    }

    @GetMapping(path = "/find")
    public Object findEmployee(
            @RequestParam(value = "fam") String fam,
            @RequestParam(value = "name") String name) {
        Employee employee;
        try {
            employee = employeeService.findEmployee(fam, name);
        } catch (Throwable e) {
            return e.getMessage();
        }
        return employee;
    }

    @GetMapping(path = "/departments/max-salary")
    public Object getHighestPaidEmployee(
            @RequestParam(value = "departmentId") int departmentId) {
        Employee employee;
        try {
            employee = employeeService.getHighestPaidEmployee(departmentId);
        } catch (Throwable e) {
            return e.getMessage();
        }
        return employee;
    }

    @GetMapping(path = "/departments/min-salary")
    public Object getLowestPaidEmployee(
            @RequestParam(value = "departmentId") int departmentId) {
        Employee employee;
        try {
            employee = employeeService.getLowestPaidEmployee(departmentId);
        } catch (Throwable e) {
            return e.getMessage();
        }
        return employee;
    }

    @GetMapping(path = "/departments/all, params = departmentId")
    public Object printEmployeesForDepartment(
            @RequestParam(value = "departmentId") int departmentId) {
        List<Employee> employees;
        try {
            employees = employeeService.printEmployeesForDepartment(departmentId);
        } catch (Throwable e) {
            return e.getMessage();
        }
        return employees;
    }

    @GetMapping(path = "/departments/all")
    public Object printEmployeesByDepartments() {
        List<Employee> employees;
        try {
            employees = employeeService.printEmployeesByDepartments();
        } catch (Throwable e) {
            return e.getMessage();
        }
        return employees;
    }

    @GetMapping(path = "/print")
    public Object printEmployees() {
        List<Employee> employees;
        try {
            employees = employeeService.printEmployees();
        } catch (Throwable e) {
            return e.getMessage();
        }
        return employees;
    }

    @GetMapping(path = "/fill")
    public Object fillEmployeesList() {
        List<Employee> employees;
        try {
            employees = employeeService.fillEmployeesList();
        } catch (Throwable e) {
            return e.getMessage();
        }
        return employees;
    }

}