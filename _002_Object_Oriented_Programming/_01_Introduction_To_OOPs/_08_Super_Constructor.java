package _01_Introduction_To_OOPs;

/*
=========================================================
_08_Super_Constructor.java

Concept Covered:
1. Inheritance
2. Parent Constructor Call using super()
3. Constructor Execution Order
=========================================================
*/

class Person {

    public Person() {
        System.out.println("Person Constructor Executed");
    }
}

class Employee extends Person {

    public Employee() {
        super();   // Calls parent constructor
        System.out.println("Employee Constructor Executed");
    }
}

public class _08_Super_Constructor {

    public static void main(String[] args) {

        Employee emp = new Employee();
        System.out.println(emp);
        /*
         Output Order:
         1. Person Constructor Executed
         2. Employee Constructor Executed
        */
    }
}