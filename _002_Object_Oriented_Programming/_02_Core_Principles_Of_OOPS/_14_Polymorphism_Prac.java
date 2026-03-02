package _02_Core_Principles_Of_OOPS;

/*
====================================================================

Problem Statement:

Design a class ShapeCalculator that calculates the area of
different shapes using method overloading.

Implement the following overloaded methods:

1) area(int radius)
   → Calculates and prints area of a circle
   → Formula: π × radius²
   → Use π = 3.14

2) area(int length, int width)
   → Calculates and prints area of a rectangle
   → Formula: length × width

3) area(int base1, int base2, int height)
   → Calculates and prints area of a trapezoid
   → Formula: ((base1 + base2) × height) / 2

Important Notes:
- Print area in INTEGER format.
- Always round down to nearest integer.
  Example:
  3.9 → 3
  2.1 → 2

Example:

Input:
base1 = 2
base2 = 3
height = 2
length = 2
radius = 2
width = 3

Output:

Area of Circle : 12
Area of Rectangle : 6
Area of Trapezoid : 5

Explanation:
- Circle area = 3.14 × 2 × 2 = 12.56 → 12
- Rectangle area = 2 × 3 = 6
- Trapezoid area = ((2 + 3) × 2) / 2 = 5

====================================================================
*/


// ==============================
// ShapeCalculator Class
// ==============================

class ShapeCalculator {

    private static final double PI = 3.14;

    // Circle Area
    public void area(int radius) {

        double result = PI * radius * radius;
        int finalResult = (int) result;   // Round down

        System.out.println("Area of Circle : " + finalResult);
    }

    // Rectangle Area
    public void area(int length, int width) {

        int result = length * width;

        System.out.println("Area of Rectangle : " + result);
    }

    // Trapezoid Area
    public void area(int base1, int base2, int height) {

        double result = ((base1 + base2) * height) / 2.0;
        int finalResult = (int) result;   // Round down

        System.out.println("Area of Trapezoid : " + finalResult);
    }
}


// ==============================
// Driver Class
// ==============================

public class _14_Polymorphism_Prac {

    public static void main(String[] args) {

        ShapeCalculator calc = new ShapeCalculator();

        int base1 = 2;
        int base2 = 3;
        int height = 2;
        int length = 2;
        int radius = 2;
        int width = 3;

        calc.area(radius);                    // Circle
        calc.area(length, width);             // Rectangle
        calc.area(base1, base2, height);      // Trapezoid
    }
}