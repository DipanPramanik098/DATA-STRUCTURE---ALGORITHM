package _01_Introduction_To_OOPs;

/*
 * This class demonstrates:
 * 1. Object creation
 * 2. Reference variables
 * 3. Method calling (Getter/Setter)
 * 4. Basic understanding of Garbage Collection
 */

public class _02_Employee_Object {

    public static void main(String[] args) {

        // Creating first Employee object
        // 'new' keyword allocates memory in Heap
        // e1 is a reference variable stored in Stack
        _01_Employee e1 = new _01_Employee();

        // Creating second Employee object
        // This creates a completely separate object in Heap
        _01_Employee e2 = new _01_Employee();


        // Printing object references
        // By default, Java prints: ClassName@HashCode
        // because internally toString() method is called
        System.out.println(e1);
        System.out.println(e2);


        // Setting values for object e1 using setter methods
        // This is an example of Encapsulation (controlled access)
        e1.setName("Dipan");
        e1.setSalary(10000);


        // Accessing salary using getter method
        // Direct access is not allowed if variable is private
        System.out.println(e1.getSalary());


        // If we assign e1 = null;
        // The object previously referenced by e1
        // becomes eligible for Garbage Collection
        // (Only if no other reference is pointing to it)

        // e1 = null;
    }
}