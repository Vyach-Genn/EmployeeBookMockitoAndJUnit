package mockitoandjunitemployeesbook.controller;

import mockitoandjunitemployeesbook.model.Employee;
import mockitoandjunitemployeesbook.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/employees")
public class EmployeesController {

    private final EmployeesService employeesService;

    @Autowired
    public EmployeesController(EmployeesService employeeService) {
        this.employeesService = employeeService;
    }

    @GetMapping("/get")
    public List<Employee> printListEmployee() {
        return employeesService.printListEmployee();
    }

    @GetMapping("/sum")
    public Integer calculateSumSalary() {
        return employeesService.calculateSumSalary();
    }

    @GetMapping("/min")
    public Employee findMinSalary() {
        return employeesService.findMinSalary();
    }

    @GetMapping("/max")
    public Employee findMaxSalary() {
        return employeesService.findMaxSalary();
    }

}
