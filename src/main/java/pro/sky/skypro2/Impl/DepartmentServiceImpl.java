package pro.sky.skypro2.Impl;

import org.springframework.stereotype.Service;
import pro.sky.skypro2.demo.Employee;
import pro.sky.skypro2.exception.EmployeeNotFoundException;
import pro.sky.skypro2.service.DepartmentService;
import pro.sky.skypro2.service.EmployeeService;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee getMaxSalaryEmployee(Integer department) {
        Optional<Employee> employeeMax = employeeService.getEmployees().stream()
                .filter(employee -> employee.getDepartment() == department)
                .max(Comparator.comparingInt(Employee::getSalary));
        if (employeeMax.isPresent()) {
            return employeeMax.get();
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee getMinSalaryEmployee(Integer department) {
        Optional<Employee> employeeMin = employeeService.getEmployees().stream()
                .filter(employee -> employee.getDepartment() == department)
                .min(Comparator.comparingInt(Employee::getSalary));
        if (employeeMin.isPresent()) {
            return employeeMin.get();
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public List<Employee> getAllEmployees(Integer department) {
        if (department == null) {
            return employeeService.getEmployees().stream()
                    .sorted(Comparator.comparingInt(Employee::getDepartment))
                    .collect(Collectors.toList());
        }
        return employeeService.getEmployees().stream()
                .filter(employee -> employee.getDepartment() == department)
                .collect(Collectors.toList());
    }

}
