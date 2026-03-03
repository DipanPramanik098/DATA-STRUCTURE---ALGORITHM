package _03_Advance_OOPS_Feature;

// 🔹 Abstract class (Blueprint)
// Cannot create object of this class directly
abstract class Animal {

    // Instance variable
    String name;

    // Constructor of abstract class
    // Yes, abstract classes CAN have constructors
    Animal(String name) {
        this.name = name;
        System.out.println("Animal constructor called");
    }

    // Concrete method (normal method with body)
    void eat() {
        System.out.println(name + " eats food.");
    }

    // Abstract method (no body)
    // Must be implemented by child class
    abstract void sound();
}

// 🔹 Concrete class (Child class)
// Provides implementation of abstract method
class Dog extends Animal {

    // Constructor
    Dog(String name) {

        // Calls abstract class constructor
        // super must be first statement
        super(name);

        System.out.println("Dog constructor called");
    }

    // Implementing abstract method
    @Override
    void sound() {
        System.out.println(name + " barks.");
    }
}

public class _01_Abstraction_Demo {

    public static void main(String[] args) {

        // 🔸 We cannot do this:
        // Animal a = new Animal("Tommy"); ❌ ERROR
        // Because Animal is abstract

        // 🔸 Valid statement
        Animal a = new Dog("Tommy");

        // Calling methods
        a.eat(); // Concrete method from Animal
        a.sound(); // Overridden method from Dog (Runtime Polymorphism)
    }
}
