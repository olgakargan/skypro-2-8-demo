package pro.sky.skypro2.demo;

import java.util.Objects;
import java.util.stream.IntStream;

public class Employee {

    private String fam;
    private String name;
    private int department;
    private float salary;
    private static int counter;
    private int id;

    public static IntStream stream() {
        return null;
    }

    public String getFam() {
        return fam;
    }

    public void setFam(String fam) {
        this.fam = fam;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Employee.counter = counter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return department == employee.department && Float.compare(employee.salary, salary) == 0 && id == employee.id && fam.equals(employee.fam) && name.equals(employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fam, name, department, salary, id);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fam='" + fam + '\'' +
                ", name='" + name + '\'' +
                ", department=" + department +
                ", salary=" + salary +
                ", id=" + id +
                '}';
    }

    public Employee(String fam, String name, int department, float salary, int id) {
        this.fam = fam;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.id = id;
    }



}

