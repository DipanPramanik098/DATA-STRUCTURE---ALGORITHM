package _03_Advance_OOPS_Feature;

/*
 Problem: Practice (Abstraction) - Medium

 You are required to design a program that utilizes an abstract class Animal
 to serve as the foundation for specific animal classes.

 Objective:
 Demonstrate runtime polymorphism where derived classes override
 the behaviour of the abstract method makeSound().

 Requirements:

 1. Create an abstract class Animal:
    - Attribute:
        name (String) : Represents the name of the animal.
    - Abstract Method:
        makeSound() : To print the sound specific to the animal.

 2. Create Derived Classes:
    - Dog class:
        Inherits Animal class.
        Overrides makeSound() method to print:
        "The dog <name> says : Woof!"

    - Cat class:
        Inherits Animal class.
        Overrides makeSound() method to print:
        "The cat <name> says : Meow!"

 3. Demonstrate Runtime Polymorphism:
    - Create objects using Animal reference.
    - Call makeSound() method to show dynamic method dispatch.

 Example:

 Input:
    d_name = "Buddy"
    c_name = "Whiskers"

 Output:
    The dog Buddy says : Woof!
    The cat Whiskers says : Meow!
*/

abstract class Animal {

    // Attribute
    protected String name;

    // Constructor
    public Animal(String name) {
        this.name = name;
    }

    // Abstract method (must be overridden)
    public abstract void makeSound();
}

// Dog class inheriting Animal
class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

    // Overriding abstract method
    @Override
    public void makeSound() {
        System.out.println("The dog " + name + " says : Woof!");
    }
}

// Cat class inheriting Animal
class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }

    // Overriding abstract method
    @Override
    public void makeSound() {
        System.out.println("The cat " + name + " says : Meow!");
    }
}

// Main class
public class _04_Abstraction_Problem {

    public static void main(String[] args) {

        // Input values (can be replaced with Scanner if needed)
        String d_name = "Buddy";
        String c_name = "Whiskers";

        // Runtime Polymorphism
        Animal dog = new Dog(d_name);
        Animal cat = new Cat(c_name);

        dog.makeSound(); // Calls Dog's makeSound()
        cat.makeSound(); // Calls Cat's makeSound()
    }
}