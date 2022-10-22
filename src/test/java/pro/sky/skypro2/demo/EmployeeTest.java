package pro.sky.skypro2.demo;


import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import pro.sky.skypro2.Impl.EmployeeServiceImpl;
import pro.sky.skypro2.exception.*;
import pro.sky.skypro2.service.EmployeeService;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static pro.sky.skypro2.demo.Constants.*;


class EmployeeServiceImplTest {
    private final EmployeeService out = new EmployeeServiceImpl();

    @ParameterizedTest
    @MethodSource("provideParamsForPositiveAddTests")
    void shouldAddCorrectEmployee(String fam, String name,
                                  int department, int salary, Employee employee) {
        Employee actualEmployee = out.addEmployee(fam, name, department, salary);
        assertEquals(employee, actualEmployee);
    }

    public static Stream<Arguments> provideParamsForPositiveAddTests() {

        return Stream.of(
                Arguments.of(GOOD_FAM1, GOOD_NAME1,
                        GOOD_DEPARTMENT1, GOOD_SALARY1, GOOD_EMPLOYEE1),
                Arguments.of(GOOD_FAM2, GOOD_NAME2,
                        GOOD_DEPARTMENT2, GOOD_SALARY2, GOOD_EMPLOYEE2)
        );
    }

    @ParameterizedTest
    @MethodSource("provideParamsForIllegalNameException")
    void shouldThrowExceptionWhenNameIsInvalid(String fam, String name,
                                               int department, int salary) {
        Assertions.assertThrows(IllegalNameException.class,
                () -> out.addEmployee(fam, name, department, salary));
    }

    public static Stream<Arguments> provideParamsForIllegalNameException() {

        return Stream.of(
                // bad fam
                Arguments.of(BAD_FAM1, GOOD_NAME1,
                        GOOD_DEPARTMENT1, GOOD_SALARY1),
                Arguments.of(BAD_FAM2, GOOD_NAME1,
                        GOOD_DEPARTMENT1, GOOD_SALARY1),
                Arguments.of(BAD_FAM3, GOOD_NAME1,
                        GOOD_DEPARTMENT1, GOOD_SALARY1),
                Arguments.of(BAD_FAM4, GOOD_NAME1,
                        GOOD_DEPARTMENT1, GOOD_SALARY1),
                // bad name
                Arguments.of(GOOD_FAM2, GOOD_NAME2,
                        GOOD_DEPARTMENT2, GOOD_SALARY2),
                Arguments.of(GOOD_FAM2, GOOD_NAME1,
                        GOOD_DEPARTMENT2, GOOD_SALARY2),
                Arguments.of(GOOD_FAM2, GOOD_NAME3,
                        GOOD_DEPARTMENT2, GOOD_SALARY2),
                Arguments.of(GOOD_FAM1, GOOD_NAME3,
                        GOOD_DEPARTMENT2, GOOD_SALARY2)

        );
    }

    @ParameterizedTest
    @MethodSource("provideParamsForIllegalDepartmentException")
    void shouldThrowExceptionWhenDepartmentIsInvalid(String fam, String name,
                                                     int department, int salary) {
        Assertions.assertThrows(IllegalDepartmentException.class,
                () -> out.addEmployee(fam, name, department, salary));
    }

    public static @NotNull Stream<Arguments> provideParamsForIllegalDepartmentException() {
        return Stream.of(
                Arguments.of(GOOD_FAM2, GOOD_NAME1,
                        BAD_DEPARTMENT1, GOOD_SALARY1),
                Arguments.of(GOOD_FAM1, GOOD_NAME1,
                        BAD_DEPARTMENT2, GOOD_SALARY1),
                Arguments.of(GOOD_FAM1, GOOD_NAME1,
                        BAD_DEPARTMENT3, GOOD_SALARY1)
        );
    }

    @ParameterizedTest
    @MethodSource("provideParamsForIllegalSalaryException")
    void shouldThrowExceptionWhenSalaryIsInvalid(String fam, String name,
                                                 int department, int salary) {
        Assertions.assertThrows(IllegalSalaryException.class,
                () -> out.addEmployee(fam, name, department, salary));
    }

    public static Stream<Arguments> provideParamsForIllegalSalaryException() {
        return Stream.of(
                Arguments.of(GOOD_FAM2, GOOD_NAME1,
                        GOOD_DEPARTMENT1, TOO_BIG_SALARY),
                Arguments.of(GOOD_FAM1, GOOD_NAME1,
                        GOOD_DEPARTMENT1, NEGATIVE_SALARY)
        );
    }

    @Test
    void shouldThrowExceptionWhenAddDuplicateEmployee() {
        out.addEmployee(GOOD_FAM1, GOOD_NAME1,
                GOOD_DEPARTMENT1, GOOD_SALARY1);
        Assertions.assertThrows(DuplicateEmployeeException.class,
                () -> out.addEmployee(GOOD_FAM1, GOOD_NAME1,
                        GOOD_DEPARTMENT2, GOOD_SALARY2));
    }

    @Test
    void correctReturnEmployee() {
        Employee employee = out.addEmployee(GOOD_FAM1, GOOD_NAME1,
                GOOD_DEPARTMENT1, GOOD_SALARY1);
        assertEquals(out.getEmployee(GOOD_FAM1, GOOD_NAME1 ), employee);
        Employee employee1 = out.addEmployee(GOOD_FAM2, GOOD_NAME2,
                GOOD_DEPARTMENT2, GOOD_SALARY2);
        assertEquals(out.getEmployee(GOOD_FAM2, GOOD_NAME2), employee1);
    }

    @Test
    void shouldThrowExceptionWhenGetEmployee() {
        out.addEmployee(GOOD_FAM1, GOOD_NAME1,
                GOOD_DEPARTMENT1, GOOD_SALARY1);
        Assertions.assertThrows(EmployeeNotFoundException.class,
                () -> out.getEmployee(GOOD_FAM2, GOOD_NAME1));
    }

    @Test
    void correctRemoveEmployee() {
        Employee employee = out.addEmployee(GOOD_FAM1, GOOD_NAME1,
                GOOD_DEPARTMENT1, GOOD_SALARY1);
        assertEquals(out.removeEmployee(GOOD_FAM1, GOOD_NAME1), employee);
        Employee employee1 = out.addEmployee(GOOD_FAM1, GOOD_NAME1,
                GOOD_DEPARTMENT2, GOOD_SALARY2);
        assertEquals(out.removeEmployee(GOOD_FAM2, GOOD_NAME2), employee1);
    }

    @Test
    void shouldThrowExceptionWhenRemoveEmployee() {
        out.addEmployee(GOOD_FAM1, GOOD_NAME1,
                GOOD_DEPARTMENT1, GOOD_SALARY1);
        Assertions.assertThrows(EmployeeNotFoundException.class,
                () -> out.removeEmployee(GOOD_FAM1, GOOD_NAME2));
    }
}