package pro.sky.skypro2.demo;


import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;


@SpringBootApplication
public class Skypro28DemoApplication {

    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee(" Fam 1 ", "Name1", 1, 10500f, 1));
        employeeList.add(new Employee(" Fam 2 ", "Name2", 2, 13456f, 2));
        employeeList.add(new Employee(" Fam 3 ", "Name3", 3, 18907f, 3));
        employeeList.add(new Employee(" Fam 4 ", "Name4", 4, 13227f, 4));
        employeeList.add(new Employee(" Fam 5 ", "Name5", 5, 14025f, 5));
        employeeList.add(new Employee(" Fam 6 ", "Name6", 1, 15456f, 6));
        employeeList.add(new Employee(" Fam 7 ", "Name7", 3, 16897f, 7));
        employeeList.add(new Employee(" Fam 8 ", "Name8", 5, 18455f, 8));

        Comparator<Employee> bySalary = Comparator.comparing(Employee::getSalary);

        Map<Integer, Optional<Employee>> collect =
                employeeList.stream().collect(
                        Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.reducing(BinaryOperator.minBy(bySalary))
                        )
                );

        collect.entrySet().stream().forEach(System.out::println);


    }

}

   // printAllEmployee();
//        System.out.println("sum salary of an employee:" + getAndCalculateSalarySum() + "rub.");
//               System.out.println(getEmployeeMinSalary());
//                System.out.println(getEmployeeMaxSalary());
//                System.out.println("avg salary of an employee:" + getAndCalculateAverageSalary() + "rub.");
 //               printFamNameSNameAllEmployee();
 //               }

//public static void printAllEmployee() {
//        for (Employee employee : employees) {
 //       System.out.println(employee);
  //      }
   //     }

//public static float getAndCalculateSalarySum() {
  //      float sum = 0;
  //      for (int i = 0; i < employees.length; i++) {
  //      if (employees[i] != null) {
  //      sum = sum + employees[i].getSalary();
 //       }
  //      }
   //     return sum;
  //      }

//public static Employee getEmployeeMinSalary() {
 //       float minSalary = -1;
 //       Employee minSalaryEmpl = null;
 //       int index = 0;
   //     for (int i = 0; i < employees.length; i++) {
   //     if (employees != null) {
   //     minSalary = employees[i].getSalary();
   //     index = i;
   //     break;
   //     }
    //    }
  //      for (int i = index; i < employees.length; i++) {
   //     if (employees[i] != null) {
   //     if (minSalary > employees[i].getSalary()) {
   //     minSalary = employees[i].getSalary();
   //     minSalaryEmpl = employees[i];


   //     }
   //     }
   //     }
   //     return minSalaryEmpl;
   //     }

//public static Employee getEmployeeMaxSalary() {
     //   float maxSalary = -1;
    //    Employee maxSalaryEmpl = null;
    //    int index = 0;
   //     for (int i = 0; i < employees.length; i++) {
    //    if (employees != null) {
    //    maxSalary = employees[i].getSalary();
    //    index = i;
    //    break;
    //    }
    //    }
