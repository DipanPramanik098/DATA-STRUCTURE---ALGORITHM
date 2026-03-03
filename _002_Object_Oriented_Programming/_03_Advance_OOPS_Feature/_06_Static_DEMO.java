package _03_Advance_OOPS_Feature;

/*

This program demonstrates:

1) Static Variable
2) Static Method
3) Static Block
4) Static Nested Class
5) Execution Order
*/

public class _06_Static_DEMO {

    // 🔹 Static Variable (Class Variable)
    // Shared among all objects
    static int objectCount;

    // 🔹 Instance Variable
    String name;

    // 🔹 Static Block
    // Runs only once when class is loaded
    static {
        objectCount = 0;
        System.out.println("Static Block Executed (Class Loaded)");
    }

    // 🔹 Constructor
    _06_Static_DEMO(String name) {
        this.name = name;
        objectCount++;
        System.out.println("Constructor Called for: " + name);
    }

    // 🔹 Static Method
    // Belongs to class, not object
    static void showObjectCount() {
        System.out.println("Total Objects Created: " + objectCount);

        // ❌ Cannot access instance variable directly
        // System.out.println(name);  // Compilation Error
    }

    // 🔹 Instance Method
    void display() {
        System.out.println("Name: " + name);
    }

    // 🔹 Static Nested Class
    static class Helper {

        void showMessage() {
            System.out.println("Inside Static Nested Class");
        }
    }

    // 🔹 Main Method
    public static void main(String[] args) {

        System.out.println("Main Method Started");

        // Calling static method before object creation
        _06_Static_DEMO.showObjectCount();

        // Creating objects
        _06_Static_DEMO obj1 = new _06_Static_DEMO("Dipan");
        _06_Static_DEMO obj2 = new _06_Static_DEMO("Rahul");

        obj1.display();
        obj2.display();

        // Calling static method again
        _06_Static_DEMO.showObjectCount();

        // Accessing Static Nested Class
        _06_Static_DEMO.Helper helper = new _06_Static_DEMO.Helper();
        helper.showMessage();
    }
}