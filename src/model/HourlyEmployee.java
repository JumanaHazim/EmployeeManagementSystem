package model;

import java.time.LocalDate;

public class HourlyEmployee extends Employee {
    private double hourlyRate;
    private double hoursWorked;
    private double overtimeRate;

    public HourlyEmployee(int id, String name, Gender gender, LocalDate hireDate,
                          double hourlyRate, double hoursWorked, double overtimeRate) {
        super(id, name, gender, hireDate);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
        this.overtimeRate = overtimeRate;
    }

    public double getHourlyRate() { return hourlyRate; }
    public void setHourlyRate(double hourlyRate) { this.hourlyRate = hourlyRate; }

    public double getHoursWorked() { return hoursWorked; }
    public void setHoursWorked(double hoursWorked) { this.hoursWorked = hoursWorked; }

    public double getOvertimeRate() { return overtimeRate; }
    public void setOvertimeRate(double overtimeRate) { this.overtimeRate = overtimeRate; }

    @Override
    public double calculateSalary() {
        double standardHours = 40.0;
        if (hoursWorked <= standardHours) {
            return hoursWorked * hourlyRate;
        } else {
            double overtimeHours = hoursWorked - standardHours;
            return (standardHours * hourlyRate) + (overtimeHours * overtimeRate);
        }
    }

    @Override
    public String toString() {
        return "HourlyEmployee{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", hourlyRate=" + hourlyRate +
                ", hoursWorked=" + hoursWorked +
                ", overtimeRate=" + overtimeRate +
                ", totalSalary=" + String.format("%.2f", calculateSalary()) +
                '}';
    }
}