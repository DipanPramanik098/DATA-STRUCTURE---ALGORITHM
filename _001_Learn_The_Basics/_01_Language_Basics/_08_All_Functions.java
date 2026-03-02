package _01_Language_Basics;

class Student {
    int marks;
}

public class _08_All_Functions {

    // ================================
    // 1️⃣ Method with Return & Parameters
    // ================================
    public static int add(int a, int b) {
        return a + b;
    }

    // ================================
    // 2️⃣ Method without Return (void)
    // ================================
    public static void greet(String name) {
        System.out.println("Hello " + name);
    }

    // ================================
    // 3️⃣ Method without Parameters
    // ================================
    public static void showMessage() {
        System.out.println("Welcome to Functions Demo");
    }

    // ================================
    // 4️⃣ Pass by Value (Primitive)
    // ================================
    public static void changePrimitive(int x) {
        x = 999;   // Only local copy changes
    }

    // ================================
    // 5️⃣ Pass Object (Modify Object Field)
    // ================================
    public static void modifyObject(Student s) {
        s.marks = 85;   // Modifies original object
    }

    // ================================
    // 6️⃣ Object Reassignment Case
    // ================================
    public static void reassignObject(Student s) {
        s = new Student();  // Only local reference changes
        s.marks = 100;
    }

    // ================================
    // 7️⃣ Method Overloading
    // ================================
    public static int multiply(int a, int b) {
        return a * b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    // ================================
    // 8️⃣ Recursion Example
    // ================================
    public static int factorial(int n) {
        if (n == 1)
            return 1;

        return n * factorial(n - 1);
    }

    // ================================
    // 9️⃣ Non-Static Method
    // ================================
    public void nonStaticMethod() {
        System.out.println("This is a Non-Static Method");
    }

    // ================================
    // MAIN METHOD
    // ================================
    public static void main(String[] args) {

        System.out.println("===== BASIC FUNCTION CALLS =====");

        showMessage();

        int sum = add(10, 20);
        System.out.println("Sum: " + sum);

        greet("Dipan");


        System.out.println("\n===== PASS BY VALUE (PRIMITIVE) =====");

        int num = 50;
        changePrimitive(num);
        System.out.println("Primitive after change: " + num); // 50


        System.out.println("\n===== PASS OBJECT (MODIFY FIELD) =====");

        Student st = new Student();
        st.marks = 60;

        modifyObject(st);
        System.out.println("Marks after modify: " + st.marks); // 85


        System.out.println("\n===== OBJECT REASSIGN CASE =====");

        reassignObject(st);
        System.out.println("Marks after reassign: " + st.marks); // 85


        System.out.println("\n===== METHOD OVERLOADING =====");

        System.out.println("Multiply int: " + multiply(5, 4));
        System.out.println("Multiply double: " + multiply(2.5, 3.5));


        System.out.println("\n===== RECURSION =====");

        System.out.println("Factorial of 5: " + factorial(5));


        System.out.println("\n===== NON-STATIC METHOD =====");

        _08_All_Functions obj = new _08_All_Functions();
        obj.nonStaticMethod();


        System.out.println("\n===== PROGRAM COMPLETED =====");
    }
}