package pro.sky.skypro2.Impl;

import org.springframework.stereotype.Service;
import pro.sky.skypro2.demo.Employee;
import pro.sky.skypro2.exception.*;
import pro.sky.skypro2.service.EmployeeService;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.capitalize;
import static org.apache.commons.lang3.StringUtils.isAlpha;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private Map<String, Employee> employeeMap = new HashMap<>();

    public EmployeeServiceImpl() {
        addEmployee("Fam10", "Name10", 1, 20000);
        addEmployee("Fam12", "Name12", 1, 15000);
        addEmployee("Fam13", "Name13", 2, 30000);
        addEmployee("Fam14", "Name14", 1, 15000);
        addEmployee("Fam15", "Name15", 4, 20000);


    }

    private String getKeyString(String fam, String name) {
        return fam + '/' + name;
    }

    private void checkInputString(String fam, String name) {
        if (!isAlpha(fam) || !isAlpha(name)) {
            throw new IllegalNameException();
        }
    }

    private void checkInputDepartment(int department) {
        if (department > 5 || department < 1) {
            throw new IllegalDepartmentException();
        }
    }

    private void checkInputSalary(int salary) {
        if (salary > Employee.MAX_SALARY || salary < 0) {
            throw new IllegalSalaryException();
        }
    }

    @Override
    public Employee addEmployee(String fam, String name,
                                int department, int salary) {
        checkInputString(fam, name);
        checkInputDepartment(department);
        checkInputSalary(salary);


        String key = getKeyString(fam, name);
        if (!employeeMap.containsKey(key)) {
            Employee employee = new Employee(fam, name, department, salary);
            employeeMap.put(key, employee);
            return employee;
        }
        throw new DuplicateEmployeeException("Такой сотрудник уже есть.");
    }

    @Override
    public Employee getEmployee(String fam, String name) {
        checkInputString(fam, name);
        String key = getKeyString(capitalize(fam), capitalize(name));
        if (employeeMap.containsKey(key)) {
            return employeeMap.get(key);
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee removeEmployee(String fam, String name) {
        checkInputString(fam, name);

        String key = getKeyString(capitalize(fam), capitalize(name));
        if (employeeMap.containsKey(key)) {
            return employeeMap.remove(key);
        }
        throw new EmployeeNotFoundException();
    }


    @Override
    public Employee addEmployee(String firstName, String secondName, String lastName, int department, int salary) {
        return null;
    }

    @Override
    public Employee getEmployee(String firstName, String secondName, String lastName) {
        return null;
    }

    @Override
    public Employee removeEmployee(String firstName, String secondName, String lastName) {
        return null;
    }

    @Override
    public Collection<Employee> getEmployees() {
        return Collections.unmodifiableCollection(employeeMap.values());
    }
}
