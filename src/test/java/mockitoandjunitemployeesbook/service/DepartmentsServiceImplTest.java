package mockitoandjunitemployeesbook.service;

import mockitoandjunitemployeesbook.model.Employee;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DepartmentsServiceImplTest {

    @Mock
    private EmployeesService employeesService;
    @InjectMocks
    private DepartmentsServiceImpl out;

    static Stream<Arguments> provideParamsForTestEmployeeDepartment() {
        return Stream.of(
                Arguments.of(1, List.of(new Employee("John", 1, 900),
                        new Employee("Mary", 1, 1000))),
                Arguments.of(2, List.of(new Employee("Jane", 2, 800),
                        new Employee("Bob", 2, 900))),
                Arguments.of(3, List.of(new Employee("Tom", 3, 3000),
                        new Employee("Alice", 3, 3500)))
        );

    }

    @ParameterizedTest
    @MethodSource("provideParamsForTestEmployeeDepartment")
    void findEmployeeDepartmentMinSalary_ShouldReturnEmployeeWithMinSalary(int departmentId, List<Employee> employees) {

        Employee minSalary = Collections.min(employees, Comparator.comparingInt(Employee::getMonthSalary));
        when(employeesService.findEmployeeDepartmentMinSalary(departmentId)).thenReturn(minSalary);
        Employee actual = out.findEmployeeDepartmentMinSalary(departmentId);

        assertFalse(employees.isEmpty());
        assertEquals(minSalary, actual);
        assertNotNull(actual);
        verify(employeesService, times(1)).findEmployeeDepartmentMinSalary(departmentId);

    }

    @ParameterizedTest
    @MethodSource("provideParamsForTestEmployeeDepartment")
    void findEmployeeDepartmentMaxSalary_ShouldReturnEmployeeWithMaxSalary(int departmentId, List<Employee> employees) {
        Employee maxSalary = Collections.max(employees, Comparator.comparingInt(Employee::getMonthSalary));
        when(employeesService.findEmployeeDepartmentMaxSalary(departmentId)).thenReturn(maxSalary);
        Employee actual = out.findEmployeeDepartmentMaxSalary(departmentId);

        assertFalse(employees.isEmpty());
        assertEquals(maxSalary, actual);
        assertNotNull(actual);
        verify(employeesService, times(1)).findEmployeeDepartmentMaxSalary(departmentId);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTestEmployeeDepartment")
    void paidTotalSalaryDepartments_ShouldReturnCorrectSum(int departmentId, List<Employee> employees) {
        int sum = employees.stream()
                .mapToInt(Employee::getMonthSalary)
                .sum();
        when(employeesService.paidTotalSalaryDepartments(departmentId)).thenReturn(sum);
        int actual = out.paidTotalSalaryDeparments(departmentId);
        assertEquals(sum, actual);
        verify(employeesService, times(1)).paidTotalSalaryDepartments(departmentId);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTestEmployeeDepartment")
    void printListEmployeeDepartment_ShouldPrintDepartment(int departmentId, List<Employee> employees) {
        when(employeesService.printListEmployeeDepartment(departmentId)).thenReturn(employees);
        List<Employee> actual = out.printListEmployeeDepartment(departmentId);
        assertEquals(employees, actual);
        assertNotNull(actual);
        verify(employeesService, times(1)).printListEmployeeDepartment(departmentId);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTestEmployeeDepartment")
    void divideEmployeesByDepartments_ShouldPrintByDepartment(int departmentId, List<Employee> employees) {
        Map<Integer, List<Employee>> expected = Map.of(departmentId, employees);
        when(employeesService.divideEmployeesByDepartments()).thenReturn(expected);
        Map<Integer, List<Employee>> actual = out.divideEmployeesByDepartments();
        assertEquals(expected, actual);
        assertNotNull(actual);
        verify(employeesService, times(1)).divideEmployeesByDepartments();
    }
}