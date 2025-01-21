package mockitoandjunitemployeesbook.service;

import mockitoandjunitemployeesbook.model.Employee;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeesServiceImpl implements EmployeesService {

    private static List<Employee> employees = new ArrayList<>(Arrays.asList(
            new Employee("Fedorova Maria Ivanovna", 5, 63000),
            new Employee("Sidorova Elena Viktorovna", 4, 59000),
            new Employee("Petrova Anna Andreevna", 3, 61000),
            new Employee("Ivanova Irina Ivanovna", 2, 65000),
            new Employee("Fedorov Fedor Fedorovich", 1, 70000),
            new Employee("Novikov Nikolay Sergeevich", 5, 57500),
            new Employee("Petrov Petr Petrovich", 4, 58000),
            new Employee("Sokolov Sergey Sergevich", 3, 61500),
            new Employee("Morozova Maria Grigorievna", 2, 64000),
            new Employee("Popov Pavel Sergeevich", 1, 69000)
    ));

    public EmployeesServiceImpl(List<Employee> employees) {
        this.employees = employees;
    }

    public EmployeesServiceImpl() {

    }

    @Override
    public List<Employee> printListEmployee() {
        return employees;
    }

    @Override
    public Integer calculateSumSalary() {
        return employees.stream()
                .mapToInt(Employee::getMonthSalary)
                .sum();
    }

    @Override
    public Employee findMinSalary() {
        return employees.stream()
                .min(Comparator.comparingInt(Employee::getMonthSalary))
                .orElse(null);
    }

    @Override
    public Employee findMaxSalary() {
        return employees.stream()
                .max(Comparator.comparingInt(Employee::getMonthSalary))
                .orElse(null);
    }

    @Override
    public Employee findEmployeeDepartmentMinSalary(int number) {
        return employees.stream()
                .filter(employee -> employee.getDepartment() == number)
                .min(Comparator.comparingInt(Employee::getMonthSalary))
                .orElse(null);
    }

    @Override
    public Employee findEmployeeDepartmentMaxSalary(int number) {
        return employees.stream()
                .filter(employee -> employee.getDepartment() == number)
                .max(Comparator.comparingInt(Employee::getMonthSalary))
                .orElse(null);
    }

    @Override
    public Integer paidTotalSalaryDepartments(int number) {
        return employees.stream()
                .filter(employee -> employee.getDepartment() == number)
                .mapToInt(Employee::getMonthSalary)
                .sum();
    }

    @Override
    public List<Employee> printListEmployeeDepartment(int number) {
        return employees.stream()
                .filter(employee -> employee.getDepartment() == number)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> divideEmployeesByDepartments() {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

}
