package mockitoandjunitemployeesbook.service;

import mockitoandjunitemployeesbook.model.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeesService {

    List<Employee> printListEmployee();

    Integer calculateSumSalary();

    Employee findMinSalary();

    Employee findMaxSalary();

    Employee findEmployeeDepartmentMinSalary(int number);

    Employee findEmployeeDepartmentMaxSalary(int number);

    Integer paidTotalSalaryDepartments(int number);

    List<Employee> printListEmployeeDepartment(int number);

    Map<Integer, List<Employee>> divideEmployeesByDepartments();
}
