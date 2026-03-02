package _02_Core_Principles_Of_OOPS;

/*
====================================================================
Problem Statement:

You are tasked with creating a class hierarchy to represent
employees in a company.

Implement:

1) Base Class: Employee
   ----------------------------------
   Attributes:
   - name (String) : Represents the name of the employee.
   - id (Integer)  : Unique identifier for the employee.

   Methods:
   - displayDetails()
     -> Prints:
        Name : <name>
        Id : <id>


2) Derived Class: Manager
   ----------------------------------
   Additional Attribute:
   - teamSize (Integer) : Size of team managed.

   Methods:
   - displayDetails()
     -> Calls parent displayDetails()
     -> Then prints:
        Team Size : <teamSize>


3) Derived Class: Engineer
   ----------------------------------
   Additional Attribute:
   - specialization (String) : Engineer's area of interest.

   Methods:
   - displayDetails()
     -> Calls parent displayDetails()
     -> Then prints:
        Specialization : <specialization>


Important Requirements:
- Derived classes must explicitly call parent constructor using super().
- Method overriding must be used.
- Parent displayDetails() must be reused inside child classes.

Example:

Input:
M_name = "Jax"
M_id = 101
M_teamSize = 8

E_name = "William"
E_id = 202
E_specialization = "Backend Developer"

Output:

Manager Details
Name : Jax
Id : 101
Team Size : 8

Engineer Details
Name : William
Id : 202
Specialization : Backend Developer

====================================================================
*/


// ==============================
// Base Class
// ==============================

class Employee {

    protected String name;
    protected Integer id;

    // Parameterized Constructor
    public Employee(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    // Method to display common details
    public void displayDetails() {
        System.out.println("Name : " + name);
        System.out.println("Id : " + id);
    }
}


// ==============================
// Manager Class (Derived)
// ==============================

class Manager extends Employee {

    private Integer teamSize;

    // Constructor calling parent constructor
    public Manager(String name, Integer id, Integer teamSize) {
        super(name, id);  // Explicit parent constructor call
        this.teamSize = teamSize;
    }

    // Overriding displayDetails()
    @Override
    public void displayDetails() {
        System.out.println("Manager Details");
        super.displayDetails();   // Call parent method
        System.out.println("Team Size : " + teamSize);
    }
}


// ==============================
// Engineer Class (Derived)
// ==============================

class Engineer extends Employee {

    private String specialization;

    // Constructor calling parent constructor
    public Engineer(String name, Integer id, String specialization) {
        super(name, id);   // Explicit parent constructor call
        this.specialization = specialization;
    }

    // Overriding displayDetails()
    @Override
    public void displayDetails() {
        System.out.println("Engineer Details");
        super.displayDetails();   // Call parent method
        System.out.println("Specialization : " + specialization);
    }
}


// ==============================
// Driver Class
// ==============================

public class _13_Inheritance_Practice {

    public static void main(String[] args) {

        // Creating Manager object
        Manager manager = new Manager("Jax", 101, 8);
        manager.displayDetails();

        System.out.println();

        // Creating Engineer object
        Engineer engineer = new Engineer("William", 202, "Backend Developer");
        engineer.displayDetails();
    }
}