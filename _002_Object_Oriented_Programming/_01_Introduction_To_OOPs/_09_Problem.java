package _01_Introduction_To_OOPs;

/*
=========================================================
Problem Statement:

Design a class Rectangle with the following specifications:

Attributes:
1. length (double) : Represents the length of the rectangle
2. width (double)  : Represents the width of the rectangle
3. area (double)   : Represents the area of the rectangle

Constructors:
1. A default constructor that initializes both length and width to 1.0
2. A parameterized constructor that takes two arguments to initialize
   length and width.

Methods:
1. void calculateArea()
   → Computes the area of rectangle.
2. void displayDetails()
   → Prints the rectangle's details in the format:

      Length : XX.XX
      Width  : XX.XX
      Area   : XX.XX

Program Flow:
1. Create object r1 using default constructor.
2. Call calculateArea() using r1.
3. Call displayDetails() using r1.
4. Create object r2 using parameterized constructor.
5. Call calculateArea() using r2.
6. Call displayDetails() using r2.
=========================================================
*/

// Rectangle class
class Rectangle {

    // Attributes
    private double length;
    private double width;
    private double area;

    // Default Constructor
    public Rectangle() {
        this.length = 1.0;
        this.width = 1.0;
    }

    // Parameterized Constructor
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    // Method to calculate area
    public void calculateArea() {
        area = length * width;
    }

    // Method to display details
    public void displayDetails() {
        System.out.printf("Length : %.2f%n", length);
        System.out.printf("Width : %.2f%n", width);
        System.out.printf("Area : %.2f%n", area);
    }
}

// Main Class
public class _09_Problem {

    public static void main(String[] args) {

        // Object using default constructor
        Rectangle r1 = new Rectangle();
        r1.calculateArea();
        r1.displayDetails();

        // Object using parameterized constructor
        Rectangle r2 = new Rectangle(5.0, 3.0);
        r2.calculateArea();
        r2.displayDetails();
    }
}