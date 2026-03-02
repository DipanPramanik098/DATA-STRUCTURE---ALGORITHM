package _01_Introduction_To_OOPs;

/*
=========================================================
_07_Constructor_Overloading_Chaining.java

Concept Covered:
1. Constructor Overloading
2. Constructor Chaining using this()
3. Code Reusability
4. Rule: this() must be first statement
=========================================================
*/

class Employee {

    String name;
    int salary;

    // Main Constructor
    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
        System.out.println("Main Constructor Executed");
    }

    // Constructor Chaining (1 parameter)
    public Employee(String name) {
        this(name, 0);   // Calls main constructor
        System.out.println("One-Parameter Constructor Executed");
    }

    // Constructor Chaining (No parameter)
    public Employee() {
        this("Unknown", 0);  // Calls main constructor
        System.out.println("Default Constructor Executed");
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
    }
}

public class _07_Constructor_Overloading_Chaining {

    public static void main(String[] args) {

        System.out.println("Employee 1:");
        Employee e1 = new Employee();
        e1.display();

        System.out.println("\nEmployee 2:");
        Employee e2 = new Employee("Rahul");
        e2.display();

        System.out.println("\nEmployee 3:");
        Employee e3 = new Employee("Amit", 5000);
        e3.display();
    }
}