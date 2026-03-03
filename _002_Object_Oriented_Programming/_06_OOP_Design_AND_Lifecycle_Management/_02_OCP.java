package _06_OOP_Design_AND_Lifecycle_Management;

// OCP Example using Polymorphism

// Abstract base class
abstract class Shape {
    abstract double calculateArea();
}

// Rectangle extends Shape
class Rectangle extends Shape {

    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double calculateArea() {
        return length * width;
    }
}

// Circle extends Shape
class Circle extends Shape {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }
}

// New class can be added WITHOUT modifying existing code
class Triangle extends Shape {

    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    double calculateArea() {
        return 0.5 * base * height;
    }
}

public class _02_OCP {
    public static void main(String[] args) {

        Shape rect = new Rectangle(5, 4);
        Shape circle = new Circle(3);
        Shape triangle = new Triangle(4, 6);

        System.out.println("Rectangle Area: " + rect.calculateArea());
        System.out.println("Circle Area: " + circle.calculateArea());
        System.out.println("Triangle Area: " + triangle.calculateArea());
    }
}