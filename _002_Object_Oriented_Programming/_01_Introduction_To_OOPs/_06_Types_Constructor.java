package _01_Introduction_To_OOPs;

/*
=========================================================
_06_Types_Constructor.java

Concept Covered:
1. Non-Parameterized Constructor
2. Parameterized Constructor
3. Copy Constructor (Manual in Java)
4. Use of 'this' keyword
=========================================================
*/

class Employee {

    String name;
    int salary;

    // 1️⃣ Non-Parameterized Constructor
    public Employee() {
        name = "Unknown";
        salary = 0;
        System.out.println("Non-Parameterized Constructor Called");
    }

    // 2️⃣ Parameterized Constructor
    public Employee(String name, int salary) {
        this.name = name;     // 'this' refers to current object
        this.salary = salary;
        System.out.println("Parameterized Constructor Called");
    }

    // 3️⃣ Copy Constructor
    public Employee(Employee e) {
        this.name = e.name;
        this.salary = e.salary;
        System.out.println("Copy Constructor Called");
    }

    // Method to display details
    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
    }
}

public class _06_Types_Constructor {

    public static void main(String[] args) {

        // Non-Parameterized
        Employee emp1 = new Employee();
        emp1.display();

        System.out.println();

        // Parameterized
        Employee emp2 = new Employee("Raj", 10000);
        emp2.display();

        System.out.println();

        // Copy Constructor
        Employee emp3 = new Employee(emp2);
        emp3.display();
    }
}