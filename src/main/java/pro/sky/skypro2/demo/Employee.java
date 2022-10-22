package pro.sky.skypro2.demo;

import java.util.Objects;

public class Employee {
    private final String fam;
    private final String name;
    private final int department;
    private final int salary;
    public static final int MAX_SALARY = Integer.MAX_VALUE / 2;

    public Employee(String fam, String name, int department, int salary) {
        this.fam = fam;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return department == employee.department && salary == employee.salary &&
                fam.equalsIgnoreCase(employee.fam) &&
                name.equalsIgnoreCase(employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fam, name, department, salary);
    }

    public String getName() {
        return name;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }


}
