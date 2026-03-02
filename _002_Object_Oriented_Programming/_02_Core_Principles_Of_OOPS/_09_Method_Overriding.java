package _02_Core_Principles_Of_OOPS;

/*
=========================================================
Method Overriding
=========================================================
*/

class Animal {

    void sound() {
        System.out.println("Animal makes sound.");
    }
}

class Dog extends Animal {

    @Override
    void sound() {
        System.out.println("Dog barks.");
    }
}

public class _09_Method_Overriding {

    public static void main(String[] args) {

        Animal obj = new Dog();  // Dynamic Binding
        obj.sound();             // Dog's version runs
    }
}