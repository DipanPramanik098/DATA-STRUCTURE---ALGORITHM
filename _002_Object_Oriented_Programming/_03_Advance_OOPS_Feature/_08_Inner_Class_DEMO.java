package _03_Advance_OOPS_Feature;

/*
=========================================================

Inner classes are classes defined inside another class.

They are used to:
✔ Improve encapsulation
✔ Logically group related classes
✔ Access outer class members easily

Types Covered in This Program:

1) Static Nested Class
2) Non-Static Inner Class
3) Local Inner Class
4) Anonymous Inner Class

=========================================================
*/


public class _08_Inner_Class_DEMO {

    // =====================================================
    // OUTER CLASS MEMBERS
    // =====================================================

    static int staticVar = 100;   // Static variable
    int instanceVar = 50;         // Instance variable


    // =====================================================
    // 1️⃣ STATIC NESTED CLASS
    // =====================================================
    /*
    - Declared using static keyword.
    - Does NOT require outer class object.
    - Can access ONLY static members of outer class directly.
    */

    static class StaticNestedClass {

        void display() {

            // Can access static variable directly
            System.out.println("Static Variable: " + staticVar);

            // Cannot access instanceVar directly ❌
            // System.out.println(instanceVar);  // ERROR
        }
    }


    // =====================================================
    // 2️⃣ NON-STATIC INNER CLASS
    // =====================================================
    /*
    - Declared without static keyword.
    - Requires outer class object.
    - Can access BOTH static and non-static members.
    */

    class InnerClass {

        void display() {

            // Can access both variables
            System.out.println("Instance Variable: " + instanceVar);
            System.out.println("Static Variable: " + staticVar);
        }
    }


    // =====================================================
    // 3️⃣ METHOD FOR LOCAL INNER CLASS
    // =====================================================
    /*
    - Defined inside a method.
    - Scope limited to that method.
    - Can access outer class members.
    - Can access effectively final local variables.
    */

    void outerMethod() {

        int localVar = 10;  // Effectively final

        // Local Inner Class
        class LocalInnerClass {

            void display() {
                System.out.println("Local Variable: " + localVar);
                System.out.println("Instance Variable: " + instanceVar);
            }
        }

        LocalInnerClass localObj = new LocalInnerClass();
        localObj.display();
    }


    // =====================================================
    // MAIN METHOD
    // =====================================================

    public static void main(String[] args) {

        System.out.println("=== Static Nested Class ===");

        // No outer object required
        StaticNestedClass staticObj = new StaticNestedClass();
        staticObj.display();


        System.out.println("\n=== Non-Static Inner Class ===");

        // Need outer class object first
        _08_Inner_Class_DEMO outerObj = new _08_Inner_Class_DEMO();

        _08_Inner_Class_DEMO.InnerClass innerObj =
                outerObj.new InnerClass();

        innerObj.display();


        System.out.println("\n=== Local Inner Class ===");

        outerObj.outerMethod();


        System.out.println("\n=== Anonymous Inner Class ===");

        /*
        4️⃣ Anonymous Inner Class
        - No class name
        - Created at the time of object creation
        - Used for one-time implementation
        */

        // Abstract class for demonstration
        abstract class Greeting {
            abstract void sayHello();
        }

        // Anonymous Inner Class
        Greeting greeting = new Greeting() {

            @Override
            void sayHello() {
                System.out.println("Hello from Anonymous Inner Class!");
            }
        };

        greeting.sayHello();
    }
}