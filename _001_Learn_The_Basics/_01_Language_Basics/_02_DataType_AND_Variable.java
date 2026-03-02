package _01_Language_Basics;

public class _02_DataType_AND_Variable {

    // ================================
    // Instance Variables (Default values apply)
    // ================================
    int defaultInt;
    double defaultDouble;
    boolean defaultBoolean;
    char defaultChar;
    String defaultString;

    // ================================
    // Static Variable (Class Variable)
    // ================================
    static String collegeName = "NSEC";

    // ================================
    // Constant (final variable)
    // ================================
    final double PI = 3.14159;

    public static void main(String[] args) {

        System.out.println("=== PRIMITIVE DATA TYPES ===");

        // 1️⃣ Integer Types
        byte b = 100;
        short s = 20000;
        int i = 500000;
        long l = 9000000000L;

        // 2️⃣ Floating Types
        float f = 3.14f;
        double d = 3.1415926535;

        // 3️⃣ Character Type
        char c = 'A';

        // 4️⃣ Boolean Type
        boolean flag = true;

        System.out.println("byte: " + b);
        System.out.println("short: " + s);
        System.out.println("int: " + i);
        System.out.println("long: " + l);
        System.out.println("float: " + f);
        System.out.println("double: " + d);
        System.out.println("char: " + c);
        System.out.println("boolean: " + flag);

        System.out.println("\n=== REFERENCE DATA TYPES ===");

        String name = "Dipan";
        int[] arr = {10, 20, 30};

        System.out.println("String: " + name);
        System.out.println("Array first element: " + arr[0]);

        System.out.println("\n=== LOCAL VARIABLE ===");

        int localVar = 50;   // Local variable
        System.out.println("Local Variable: " + localVar);

        System.out.println("\n=== INSTANCE & STATIC VARIABLES ===");

        // ✅ Correct Object Creation
        _02_DataType_AND_Variable obj = new _02_DataType_AND_Variable();

        System.out.println("Instance default int: " + obj.defaultInt);
        System.out.println("Instance default double: " + obj.defaultDouble);
        System.out.println("Instance default boolean: " + obj.defaultBoolean);
        System.out.println("Instance default char: " + obj.defaultChar);
        System.out.println("Instance default String: " + obj.defaultString);

        System.out.println("Static variable (collegeName): " + collegeName);

        System.out.println("\n=== CONSTANT (final) ===");
        System.out.println("Value of PI: " + obj.PI);

        System.out.println("\n=== TYPE CASTING ===");

        // Implicit Casting (Widening)
        int num1 = 100;
        double num2 = num1;
        System.out.println("Implicit Casting int → double: " + num2);

        // Explicit Casting (Narrowing)
        double num3 = 99.99;
        int num4 = (int) num3;
        System.out.println("Explicit Casting double → int: " + num4);

        System.out.println("\n=== TYPE PROMOTION ===");

        byte x = 10;
        byte y = 20;
        int result = x + y;   // Promoted to int
        System.out.println("Result of byte addition (promoted to int): " + result);

        System.out.println("\n=== WRAPPER CLASSES ===");

        // Autoboxing
        Integer wrapperInt = 500;

        // Unboxing
        int primitiveInt = wrapperInt;

        System.out.println("Wrapper Integer: " + wrapperInt);
        System.out.println("Unboxed int: " + primitiveInt);

        System.out.println("\n=== PROGRAM COMPLETED SUCCESSFULLY ===");
    }
}