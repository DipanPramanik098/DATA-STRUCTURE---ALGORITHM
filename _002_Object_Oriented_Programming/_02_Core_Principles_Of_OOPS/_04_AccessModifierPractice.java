package _02_Core_Principles_Of_OOPS;

/*
====================================================================
Problem Statement:

Design a class Employee to manage employee details securely 
using proper encapsulation and access modifiers.

Attributes:

1. name (String)
   → public
   → Represents the name of employee.

2. employeeId (Integer)
   → protected
   → Represents the unique ID of the employee.

3. salary (double)
   → private
   → Represents the salary of the employee.

Methods:

1. setSalary(double salary)
   → Sets the salary value.
   → If salary is negative:
        - Print "Invalid salary"
        - Set salary to 0.

2. getSalary()
   → Returns the salary value.

3. Parameterized Constructor
   → Initializes name, employeeId and salary.
   → If salary is negative:
        - Print "Invalid salary"
        - Set salary to 0.

4. displayEmployeeDetails()
   → Display employee details in the format:

        Name : <name>
        Employee Id : <employeeId>
        Salary : <salary formatted to 2 decimal places>

Example:

Input:
name = "Dipan"
employeeId = 9656
salary = 10000
newSalary = 15840

Output:

Salary : 10000.00
Name : Dipan
Employee Id : 9656
Salary : 15840.00

Explanation:

1. An object employee of class Employee is created using the 
   parameterized constructor.

2. getSalary() is called and displayed through driver code.

3. setSalary(newSalary) is called.

4. displayEmployeeDetails() prints updated details.

====================================================================
*/

class Employee {

    // ============================
    // Attributes with Access Modifiers
    // ============================

    public String name;          // Public
    protected Integer employeeId; // Protected
    private double salary;        // Private


    // ============================
    // Parameterized Constructor
    // ============================

    public Employee(String name, Integer employeeId, double salary) {

        this.name = name;
        this.employeeId = employeeId;

        if (salary < 0) {
            System.out.println("Invalid salary");
            this.salary = 0;
        } else {
            this.salary = salary;
        }
    }


    // ============================
    // Setter Method
    // ============================

    public void setSalary(double salary) {

        if (salary < 0) {
            System.out.println("Invalid salary");
            this.salary = 0;
        } else {
            this.salary = salary;
        }
    }


    // ============================
    // Getter Method
    // ============================

    public double getSalary() {
        return salary;
    }


    // ============================
    // Display Method
    // ============================

    public void displayEmployeeDetails() {

        System.out.println("Name : " + name);
        System.out.println("Employee Id : " + employeeId);
        System.out.printf("Salary : %.2f%n", salary);
    }
}


// ============================
// Driver Class
// ============================

public class _04_AccessModifierPractice {

    public static void main(String[] args) {

        String name = "Dipan";
        int employeeId = 9656;
        double salary = 10000;
        double newSalary = 15840;

        // Creating object
        Employee employee = new Employee(name, employeeId, salary);

        // Displaying salary using getter
        System.out.printf("Salary : %.2f%n", employee.getSalary());

        // Updating salary
        employee.setSalary(newSalary);

        // Display updated details
        employee.displayEmployeeDetails();
    }
}