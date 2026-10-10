package test;

import model.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class MainTest {
    public static void main(String[] args) {
        // 1. Create a Manager
        MonthlyEmployee manager = new MonthlyEmployee(
                101, "Dr. Sarah Adams", Gender.FEMALE,
                LocalDate.of(2018, 3, 15), 18000.0, 25, 15.0, true
        );

        // 2. Create Department
        Department techDept = new Department(1, "Software Engineering", manager, new ArrayList<>());
        techDept.addEmployee(manager);

        // 3. Create employees
        HourlyEmployee hourlyEmp = new HourlyEmployee(
                102, "Alex Smith", Gender.MALE,
                LocalDate.of(2022, 6, 1), 50.0, 48.0, 75.0
        );

        CommissionEmployee commissionEmp = new CommissionEmployee(
                103, "Laila Hassan", Gender.FEMALE,
                LocalDate.of(2021, 9, 10), 6000.0, 10.0, 45000.0
        );

        // 4. Add employees to department
        techDept.addEmployee(hourlyEmp);
        techDept.addEmployee(commissionEmp);

        // 5. Display info
        System.out.println(techDept);
        System.out.println();
        techDept.printAllEmployees();

        // 6. Summary
        System.out.println("\n--- Department Payroll Summary ---");
        System.out.printf("Total Payroll: $%.2f%n", techDept.calculateTotalPayroll());
    }
}