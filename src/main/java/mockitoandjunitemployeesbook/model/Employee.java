package mockitoandjunitemployeesbook.model;

import java.util.Objects;

public class Employee {

    private final String fullName;
    private final int department;
    private int monthSalary;

    public Employee(String fullName, int department, int monthSalary) {
        this.fullName = fullName;
        this.department = department;
        this.monthSalary = monthSalary;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDepartment() {
        return department;
    }

    public int getMonthSalary() {
        return monthSalary;
    }

    public void setMonthSalary(int monthSalary) {
        this.monthSalary = monthSalary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return department == employee.department && monthSalary == employee.monthSalary && Objects.equals(fullName, employee.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, department, monthSalary);
    }

    @Override
    public String toString() {
        return "(fullName: " + fullName + ", department: " + department + ", monthSalary: " + monthSalary + ')';
    }
}
