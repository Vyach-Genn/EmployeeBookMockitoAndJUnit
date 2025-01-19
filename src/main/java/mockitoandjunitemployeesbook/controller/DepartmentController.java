package mockitoandjunitemployeesbook.controller;

import mockitoandjunitemployeesbook.model.Employee;
import mockitoandjunitemployeesbook.service.DepartmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    DepartmentsService departmentsService;

    @Autowired
    public DepartmentController(DepartmentsService departmentsService) {
        this.departmentsService = departmentsService;
    }

    @GetMapping("/{id}/salary/min")
    public Employee findEmployeeDepartmentMinSalary(@PathVariable int id) {
        return departmentsService.findEmployeeDepartmentMinSalary(id);
    }

    @GetMapping("/{id}/salary/max")
    public Employee findEmployeeDepartmentMaxSalary(@PathVariable int id) {
        return departmentsService.findEmployeeDepartmentMaxSalary(id);
    }

    @GetMapping("/{id}/salary/sum")
    public Integer paidTotalSalaryDeparments(@PathVariable int id) {
        return departmentsService.paidTotalSalaryDeparment(id);
    }

    @GetMapping("/{id}/employees")
    public List<Employee> printListEmployeeDepartment(@PathVariable int id) {
        return departmentsService.printListEmployeeDepartment(id);
    }

    @GetMapping("/employees")
    public Map<Integer, List<Employee>> divideEmployeesByDepartments() {
        return departmentsService.divideEmployeesByDepartments();

    }
}
