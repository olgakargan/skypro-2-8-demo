package pro.sky.skypro2.demo;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
class EmployeeServiceImpl implements EmployeeService.employeeService {
    private final List<Employee> employees;
    private final String ERR_EMPL_ALREADY_ADDED = "Сотрудник уже имеется";
    private final String ERR_EMPL_NOT_FOUND = "Сотрудник не найден";

    public EmployeeServiceImpl(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public Employee addEmployee(String fam, String name, int salary, int department) {
        Employee employee = new Employee(fam, name, salary, department);
        if (employees.contains(employee)) {
            throw new RuntimeException(ERR_EMPL_ALREADY_ADDED);
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String fam, String name) {
        Employee employee = findEmployee(fam, name);
        employees.remove(employee);
        return employee;
    }

    @Override
    public Employee findEmployee(String fam, String name) {
        final Optional<Employee> employee = employees.stream()
                .filter(e -> e.getFam().equals(fam) && e.getName().equals(name))
                .findAny();
        return employee.orElseThrow(() -> new RuntimeException(ERR_EMPL_NOT_FOUND));
    }

    @Override
    public Employee getLowestPaidEmployee(int department) {
        return employees.stream()
                .filter(e -> e.getDepartment() == department)
                .min(Comparator.comparingInt(e -> (int) e.getSalary()))
                .orElseThrow(() -> new RuntimeException(ERR_EMPL_NOT_FOUND));
    }

    @Override
    public Employee getHighestPaidEmployee(int department) {
        return employees.stream()
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparingInt(e -> (int) e.getSalary()))
                .orElseThrow(() -> new RuntimeException(ERR_EMPL_NOT_FOUND));
    }

    @Override
    public List<Employee> printEmployeesForDepartment(int department) {
        return employees.stream()
                .filter(e -> e.getDepartment() == department)
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> printEmployeesByDepartments() {
        return Collections.unmodifiableList(employees.stream()
                .sorted(Comparator.comparingInt(e -> e.getDepartment()))
                .collect(Collectors.toList()));
    }

    @Override
    public List<Employee> printEmployees() {
        return Collections.unmodifiableList(employees);
    }


    @Override
    public List<Employee> fillEmployeesList() {

        employees.add(new Employee(" Fam 1 ", "Name1", Department.PROGRAMMER, 10500f));
        employees.add(new Employee(" Fam 2 ", "Name2", Department.ACCOUNTANT, 13456f));
        employees.add(new Employee(" Fam 3 ", "Name3", Department.PROGRAMMER, 18907f));
        employees.add(new Employee(" Fam 4 ", "Name4", Department.ECONOMIST, 13227f));
        employees.add(new Employee(" Fam 5 ", "Name5", Department.PROGRAMMER, 14025f));
        employees.add(new Employee(" Fam 6 ", "Name6", Department.ACCOUNTANT, 15456f));
        employees.add(new Employee(" Fam 7 ", "Name7", Department.PROGRAMMER, 16897f));
        employees.add(new Employee(" Fam 8 ", "Name8", Department.ECONOMIST, 18455f));
        return employees;
    }
}

