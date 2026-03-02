package _02_Core_Principles_Of_OOPS;

/*
=========================================================
Multilevel Inheritance
=========================================================
*/

class Animal {

    void eat() {
        System.out.println("Animal eats food.");
    }
}

class Mammal extends Animal {

    void walk() {
        System.out.println("Mammal walks.");
    }
}

class Dog extends Mammal {

    void bark() {
        System.out.println("Dog barks.");
    }
}

public class _07_Multilevel_Inheritance {

    public static void main(String[] args) {

        Dog dog = new Dog();

        dog.eat();
        dog.walk();
        dog.bark();
    }
}