package model;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private int id;
    private String name;
    private Employee manager;
    private List<Employee> employees;

    public Department(int id, String name, Employee manager, List<Employee> employees) {
        this.id = id;
        this.name = name;
        this.manager = manager;
        this.employees = (employees != null) ? employees : new ArrayList<>();
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Employee getManager() { return manager; }
    public void setManager(Employee manager) { this.manager = manager; }

    public List<Employee> getEmployees() { return employees; }
    public void setEmployees(List<Employee> employees) { this.employees = employees; }

    public void addEmployee(Employee employee) {
        if (employee != null && !employees.contains(employee)) {
            employees.add(employee);
            employee.setDepartment(this);
        }
    }

    public void removeEmployee(int employeeId) {
        Employee toRemove = findEmployee(employeeId);
        if (toRemove != null) {
            toRemove.setDepartment(null);
            employees.remove(toRemove);
        }
    }

    public Employee findEmployee(int employeeId) {
        for (Employee emp : employees) {
            if (emp.getId() == employeeId) {
                return emp;
            }
        }
        return null;
    }

    public double calculateTotalPayroll() {
        double total = 0.0;
        for (Employee emp : employees) {
            total += emp.calculateSalary();
        }
        return total;
    }

    public void printAllEmployees() {
        System.out.println("=== Employees in " + name + " Department ===");
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", manager=" + (manager != null ? manager.getName() : "None") +
                ", totalEmployees=" + employees.size() +
                ", totalPayroll=" + String.format("%.2f", calculateTotalPayroll()) +
                '}';
    }
}