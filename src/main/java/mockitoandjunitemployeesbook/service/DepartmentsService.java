package mockitoandjunitemployeesbook.service;

import mockitoandjunitemployeesbook.model.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentsService {
    Employee findEmployeeDepartmentMinSalary(int number);

    Employee findEmployeeDepartmentMaxSalary(int number);

    Integer paidTotalSalaryDeparments(int number);

    List<Employee> printListEmployeeDepartment(int number);

    Map<Integer, List<Employee>> divideEmployeesByDepartments();
}
