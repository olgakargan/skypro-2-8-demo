package pro.sky.skypro2.demo;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class Employee {

    private final String fam;
    private final String name;
    private final int department;
    private final float salary;


    public String getFam() {
        return fam;
    }

    public String getName() {
        return name;
    }

    public int getDepartment() {
        return department;
    }

    public float getSalary() {
        return salary;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return department == employee.department && Float.compare(employee.salary, salary) == 0
                && fam.equals(employee.fam) && name.equals(employee.name);
    }

    public Employee(String fam, String name, int department, float salary) {
        this.fam = StringUtils.capitalize(fam.toLowerCase());
        this.name = StringUtils.capitalize(name.toLowerCase());
        this.department = department;
        this.salary = salary;

    }

    @Override
    public int hashCode() {
        return Objects.hash(fam, name, department, salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fam='" + fam + '\'' +
                ", name='" + name + '\'' +
                ", department=" + department +
                ", salary=" + salary +
                '}';
    }
}

