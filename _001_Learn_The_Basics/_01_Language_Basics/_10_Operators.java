package _01_Language_Basics;

public class _10_Operators {
    public static void main(String[] args) {

        int a = 10, b = 3;

        System.out.println("=== Arithmetic ===");
        System.out.println(a + b);
        System.out.println(a - b);
        System.out.println(a * b);
        System.out.println(a / b);
        System.out.println(a % b);

        System.out.println("\n=== Unary ===");
        int x = 5;
        System.out.println(++x);
        System.out.println(x--);

        System.out.println("\n=== Relational ===");
        System.out.println(a > b);
        System.out.println(a == b);

        System.out.println("\n=== Logical ===");
        System.out.println(true && false);
        System.out.println(true || false);

        System.out.println("\n=== Bitwise ===");
        System.out.println(a & b);
        System.out.println(a | b);
        System.out.println(a ^ b);

        System.out.println("\n=== Shift ===");
        System.out.println(a << 1);
        System.out.println(a >> 1);

        System.out.println("\n=== Assignment ===");
        a += 5;
        System.out.println(a);

        System.out.println("\n=== Ternary ===");
        String result = (a > b) ? "Yes" : "No";
        System.out.println(result);

        System.out.println("\n=== instanceof ===");
        String s = "Java";
        System.out.println(s instanceof String);
    }
}
