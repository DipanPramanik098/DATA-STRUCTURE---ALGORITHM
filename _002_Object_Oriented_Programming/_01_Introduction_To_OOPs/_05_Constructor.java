package _01_Introduction_To_OOPs;

/*
=========================================================
_05_Constructor.java

Concept Covered:
1. What is a Constructor?
2. Default constructor behavior
3. Automatic initialization of instance variables
4. Constructor execution at object creation
=========================================================
*/

class Employee {

    // Instance Variables
    int id;            // Default value -> 0
    double salary;     // Default value -> 0.0
    String name;       // Default value -> null

    // Explicit Constructor
    public Employee() {
        System.out.println("Constructor Executed!");
        name = "John Doe";
        salary = 5000;
        id = 101;
    }

    // Method to display employee details
    public void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
    }
}

public class _05_Constructor {

    public static void main(String[] args) {

        // Object Creation
        Employee emp1 = new Employee();  // Constructor runs automatically

        System.out.println("\nEmployee Details:");
        emp1.display();
    }
}