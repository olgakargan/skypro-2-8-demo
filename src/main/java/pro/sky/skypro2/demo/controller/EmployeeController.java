package pro.sky.skypro2.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skypro2.demo.Employee;
import pro.sky.skypro2.service.EmployeeService;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/post")
    public Employee addEmployee(@RequestParam String fam,
                                @RequestParam String name,
                                @RequestParam int department,
                                @RequestParam int salary
    ) {
        return employeeService.addEmployee(fam, name, department, salary);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam String fam,
                                   @RequestParam String name)
                                    {
        return employeeService.removeEmployee(fam, name);
    }

    @GetMapping("/find")
    public Employee find(@RequestParam String fam,
                         @RequestParam String name) {
        return employeeService.getEmployee(fam, name);
    }

    @GetMapping("/all")
    public Collection<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

}