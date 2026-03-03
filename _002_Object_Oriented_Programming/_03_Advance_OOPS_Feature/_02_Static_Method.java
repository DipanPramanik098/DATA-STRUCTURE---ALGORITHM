package _03_Advance_OOPS_Feature;

public class _02_Static_Method {

    // 🔹 Static variable (Class variable)
    // Shared among all objects
    static int count = 0;

    // 🔹 Instance variable (Object variable)
    String name;

    // 🔹 Constructor
    _02_Static_Method(String name) {
        this.name = name;
        count++;   // Increment shared counter
    }

    // 🔹 Static Method
    // Belongs to class, not object
    static void showCount() {

        // ❗ Cannot directly access non-static (instance) variables here
        // System.out.println(name); ❌ ERROR

        System.out.println("Total Objects Created: " + count);
    }

    // 🔹 Non-static method
    void display() {
        System.out.println("Name: " + name);
    }

    // 🔹 Main Method
    public static void main(String[] args) {

        // Calling static method without object
        _02_Static_Method.showCount();

        _02_Static_Method obj1 = new _02_Static_Method("Dipan");
        _02_Static_Method obj2 = new _02_Static_Method("Rahul");

        obj1.display();
        obj2.display();

        // Calling static method using class name (Recommended)
        _02_Static_Method.showCount();
    }
}