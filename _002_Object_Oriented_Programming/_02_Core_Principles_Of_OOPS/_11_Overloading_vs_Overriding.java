package _02_Core_Principles_Of_OOPS;

/*
=========================================================
Overloading vs Overriding
=========================================================
*/

class Calculator {

    // Method Overloading
    int add(int a, int b) {
        return a + b;
    }

    double add(double a, double b) {
        return a + b;
    }
}

class AdvancedCalculator extends Calculator {

    // Method Overriding
    @Override
    int add(int a, int b) {
        System.out.println("Overridden Method");
        return a + b;
    }
}

public class _11_Overloading_vs_Overriding {

    public static void main(String[] args) {

        AdvancedCalculator calc = new AdvancedCalculator();

        System.out.println(calc.add(5, 3));
        System.out.println(calc.add(5.5, 3.5));
    }
}