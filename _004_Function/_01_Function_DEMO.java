package _004_Function;

import java.util.Scanner;

/*
 * 1. Why Functions
 * 2. Method Syntax
 * 3. Types of Methods
 * 4. Method Structure Breakdown
 * 5. Call Stack Concept
 * 6. Pass By Value
 * 7. Static vs Non-Static
 * 8. Method Overloading
 * 9. Variable Scope
 * 10. Default Return Rules
 * 11. Armstrong Number (Method Based)
 */

public class _01_Function_DEMO {

    /* =========================================================
       1️⃣ WHY FUNCTIONS
       ========================================================= */

    static void reusableMessage() {
        System.out.println("Functions make code modular and reusable.");
    }

    /* =========================================================
       2️⃣ BASIC METHOD SYNTAX
       accessModifier returnType methodName(parameters)
       ========================================================= */

    static int add(int a, int b) {
        return a + b;
    }

    /* =========================================================
       3️⃣ TYPES OF METHODS
       ========================================================= */

    // 1. No Parameter, No Return
    static void greet() {
        System.out.println("Hello!");
    }

    // 2. Parameter, No Return
    static void printSquare(int x) {
        System.out.println("Square = " + (x * x));
    }

    // 3. No Parameter, With Return
    static int getNumber() {
        return 10;
    }

    // 4. Parameter, With Return
    static int multiply(int a, int b) {
        return a * b;
    }

    /* =========================================================
       4️⃣ METHOD STRUCTURE BREAKDOWN
       public static int sample(int x, int y)
       public  -> access modifier
       static  -> belongs to class
       int     -> return type
       sample  -> method name
       x, y    -> parameters
       ========================================================= */

    public static int sample(int x, int y) {
        int result = x + y;  // local variable
        return result;       // returning value
    }

    /* =========================================================
       5️⃣ METHOD CALL STACK DEMO
       ========================================================= */

    static void first() {
        System.out.println("Inside First()");
        second();
    }

    static void second() {
        System.out.println("Inside Second()");
    }

    /* =========================================================
       6️⃣ PASS BY VALUE DEMO
       Java is Pass By Value ONLY
       ========================================================= */

    static void changePrimitive(int x) {
        x = 50;  // only copy changes
    }

    static class Test {
        int value;
    }

    static void changeObject(Test t) {
        t.value = 100;  // object data changes
    }

    /* =========================================================
       7️⃣ STATIC vs NON-STATIC
       ========================================================= */

    void nonStaticMethod() {
        System.out.println("Non-static method called.");
    }

    static void staticMethod() {
        System.out.println("Static method called.");
    }

    /* =========================================================
       8️⃣ METHOD OVERLOADING
       Same name, different parameters
       ========================================================= */

    static int sum(int a, int b) {
        return a + b;
    }

    static int sum(int a, int b, int c) {
        return a + b + c;
    }

    static double sum(double a, double b) {
        return a + b;
    }

    /* =========================================================
       9️⃣ VARIABLE SCOPE
       ========================================================= */

    int instanceVar = 10;          // instance variable
    static int staticVar = 20;     // static variable

    void scopeDemo(int param) {    // parameter variable
        int localVar = 30;         // local variable

        System.out.println("Instance: " + instanceVar);
        System.out.println("Static: " + staticVar);
        System.out.println("Parameter: " + param);
        System.out.println("Local: " + localVar);
    }

    /* =========================================================
       🔟 DEFAULT RETURN RULES
       void -> no return required
       non-void -> must return value
       ========================================================= */

    static void show() {
        System.out.println("Void method - no return needed.");
    }

    static int getValue() {
        return 100;
    }

    /* =========================================================
       1️⃣1️⃣ ARMSTRONG NUMBER USING METHOD
       ========================================================= */

    static boolean isArmstrong(int num) {

        int original = num;
        int digits = 0;
        int sum = 0;

        int temp = num;

        // Count digits
        while (temp > 0) {
            temp /= 10;
            digits++;
        }

        temp = num;

        // Calculate sum of digit^digits
        while (temp > 0) {
            int rem = temp % 10;
            sum += Math.pow(rem, digits);
            temp /= 10;
        }

        return sum == original;
    }

    /* =========================================================
       MAIN METHOD
       ========================================================= */

    public static void main(String[] args) {

        System.out.println("===== 1. Why Functions =====");
        reusableMessage();

        System.out.println("\n===== 2. Basic Method Syntax =====");
        System.out.println("Add = " + add(10, 20));

        System.out.println("\n===== 3. Types of Methods =====");
        greet();
        printSquare(5);
        System.out.println("getNumber = " + getNumber());
        System.out.println("multiply = " + multiply(4, 3));

        System.out.println("\n===== 4. Method Structure =====");
        System.out.println("Sample = " + sample(15, 25));

        System.out.println("\n===== 5. Call Stack Demo =====");
        first();

        System.out.println("\n===== 6. Pass By Value =====");
        int a = 10;
        changePrimitive(a);
        System.out.println("Primitive after change = " + a);

        Test obj = new Test();
        obj.value = 5;
        changeObject(obj);
        System.out.println("Object after change = " + obj.value);

        System.out.println("\n===== 7. Static vs Non-Static =====");
        staticMethod();
        _01_Function_DEMO demo = new _01_Function_DEMO();
        demo.nonStaticMethod();

        System.out.println("\n===== 8. Method Overloading =====");
        System.out.println(sum(5, 10));
        System.out.println(sum(1, 2, 3));
        System.out.println(sum(2.5, 3.5));

        System.out.println("\n===== 9. Variable Scope =====");
        demo.scopeDemo(99);

        System.out.println("\n===== 10. Default Return Rules =====");
        show();
        System.out.println("getValue = " + getValue());

        System.out.println("\n===== 11. Armstrong Number =====");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int num = sc.nextInt();

        if (isArmstrong(num))
            System.out.println("Armstrong Number");
        else
            System.out.println("Not Armstrong Number");

        sc.close();
    }
}