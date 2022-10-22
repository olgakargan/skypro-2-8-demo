package pro.sky.skypro2.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.skypro2.Impl.DepartmentServiceImpl;
import pro.sky.skypro2.exception.EmployeeNotFoundException;
import pro.sky.skypro2.service.EmployeeService;

import java.util.Collections;
import java.util.List;

import static java.util.List.of;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;

import static pro.sky.skypro2.demo.Constants.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {
    @Mock
    EmployeeService employeeService;

    @InjectMocks
    private DepartmentServiceImpl out;

    @BeforeEach
    void initList() {
        Mockito.when(employeeService.getEmployees()).thenReturn(EMPLOYEE_LIST);
    }

    @Test
    void shouldReturnEmployeeWithMaxSalary() {
        assertEquals(out.getMaxSalaryEmployee(3), GOOD_EMPLOYEE3);
        assertEquals(out.getMaxSalaryEmployee(1), GOOD_EMPLOYEE2);
    }

    private void assertEquals(Employee maxSalaryEmployee, Employee goodEmployee3) {
    }

    @Test
    void shouldReturnEmployeeWithMinSalary() {
        assertEquals(out.getMinSalaryEmployee(3), GOOD_EMPLOYEE1);
        assertEquals(out.getMinSalaryEmployee(1), GOOD_EMPLOYEE2);
    }

    @Test
    void shouldReturnEmployeeNotFoundExceptionWhenDepartmentIsIncorrect() {
        assertThrows(EmployeeNotFoundException.class, () -> out.getMaxSalaryEmployee(0));
        assertThrows(EmployeeNotFoundException.class, () -> out.getMaxSalaryEmployee(6));
        assertThrows(EmployeeNotFoundException.class, () -> out.getMinSalaryEmployee(2));
    }

    @Test
    void shouldReturnListOfAllEmployeesInDepartmentWhenDepartmentIsCorrect() {
        assertEquals((Employee) out.getAllEmployees(3), (Employee) EMPLOYEE_LIST_DEPARTMENT3);
        assertEquals((Employee) out.getAllEmployees(1), (Employee) EMPLOYEE_LIST_DEPARTMENT1);

    }

        @Test
    void shouldReturnAllEmployeesOrderedByDepartmentWhenDepartmentIsNull() {
        assertEquals((Employee) out.getAllEmployees(null), (Employee) EMPLOYEE_LIST_ORDERED);
    }

}