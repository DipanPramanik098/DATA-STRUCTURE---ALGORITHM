package _02_Core_Principles_Of_OOPS;

/*
=========================================================
Single Inheritance
=========================================================
*/

class Animal {

    void eat() {
        System.out.println("This animal eats food.");
    }
}

class Dog extends Animal {

    void bark() {
        System.out.println("This dog barks.");
    }
}

public class _06_Single_Inheritance {

    public static void main(String[] args) {

        Dog dog = new Dog();

        dog.eat();   // inherited
        dog.bark();  // own method
    }
}