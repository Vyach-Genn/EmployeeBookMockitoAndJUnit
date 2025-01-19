package mockitoandjunitemployeesbook.service;

import mockitoandjunitemployeesbook.model.Employee;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class EmployeesServiceImplTest {

    private EmployeesServiceImpl out = new EmployeesServiceImpl();


    @ParameterizedTest
    @MethodSource("provideParamsForTestListEmployee")
    void printListEmployee_ShouldReturnAllEmployees(List<Employee> employees) {

        out = new EmployeesServiceImpl(employees);

        List<Employee> result = out.printListEmployee();

        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(3, result.size());
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTestListEmployee")
    void calculateSumSalary_ShouldReturnCorrectSum(List<Employee> employees) {

        out = new EmployeesServiceImpl(employees);
        int expected = 600;

        int sum = out.calculateSumSalary();

        assertEquals(expected, sum);

    }

    @ParameterizedTest
    @MethodSource("provideParamsForTestListEmployee")
    void findMinSalary_ShouldReturnSalaryMin(List<Employee> employees) {

        out = new EmployeesServiceImpl(employees);
        Employee expected = new Employee("Иванов", 1, 100);

        Employee min = out.findMinSalary();

        assertEquals(expected, min);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTestListEmployee")
    void findMaxSalary_ShouldReturnSalaryMax(List<Employee> employees) {

        out = new EmployeesServiceImpl(employees);
        Employee expected = new Employee("Сидоров", 3, 300);

        Employee max = out.findMaxSalary();

        assertEquals(expected, max);
    }

    public static Stream<Arguments> provideParamsForTestListEmployee() {
        return Stream.of(
                Arguments.of(
                        Arrays.asList(
                                new Employee("Иванов", 1, 100),
                                new Employee("Петров", 2, 200),
                                new Employee("Сидоров", 3, 300)),
                        600));
    }

}