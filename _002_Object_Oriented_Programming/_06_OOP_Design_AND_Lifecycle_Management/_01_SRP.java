package _06_OOP_Design_AND_Lifecycle_Management;

// SRP Example
// Each class has only ONE responsibility.

class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }
}

// Responsibility 1: Salary calculation logic
class SalaryCalculator {

    public double calculateAnnualSalary(Employee emp) {
        // Business logic related to salary
        return emp.getSalary() * 12;
    }
}

// Responsibility 2: Report generation logic
class ReportGenerator {

    public void generateReport(Employee emp) {
        // Reporting logic only
        System.out.println("Generating report for: " + emp.getName());
    }
}

public class _01_SRP {
    public static void main(String[] args) {

        Employee emp = new Employee("Dipan", 50000);

        SalaryCalculator calculator = new SalaryCalculator();
        ReportGenerator report = new ReportGenerator();

        System.out.println("Annual Salary: " + calculator.calculateAnnualSalary(emp));
        report.generateReport(emp);
    }
}