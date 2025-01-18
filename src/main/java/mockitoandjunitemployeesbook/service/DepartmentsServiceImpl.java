package mockitoandjunitemployeesbook.service;

import mockitoandjunitemployeesbook.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DepartmentsServiceImpl implements DepartmentsService {

    EmployeesService employees;
@Autowired
    public DepartmentsServiceImpl(EmployeesService employees) {
        this.employees = employees;
    }

    @Override
    public Employee findEmployeeDepartmentMinSalary(int number) {
        return employees.findEmployeeDepartmentMinSalary(number);

    }

    @Override
    public Employee findEmployeeDepartmentMaxSalary(int number) {
        return employees.findEmployeeDepartmentMaxSalary(number);
    }

    @Override
    public Integer paidTotalSalaryDeparments(int number) {
        return employees.paidTotalSalaryDepartments(number);
    }

    @Override
    public List<Employee> printListEmployeeDepartment(int number) {
       return employees.printListEmployeeDepartment(number);
    }

    @Override
    public Map<Integer, List<Employee>> divideEmployeesByDepartments() {
        return employees.divideEmployeesByDepartments();

    }
}