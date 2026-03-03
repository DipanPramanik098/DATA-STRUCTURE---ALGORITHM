package _06_OOP_Design_AND_Lifecycle_Management;

// LSP Correct Example

// Base abstraction
interface Bird {
    void eat();
}

// Separate flying capability
interface FlyingBird {
    void fly();
}

// Sparrow can fly
class Sparrow implements Bird, FlyingBird {

    public void eat() {
        System.out.println("Sparrow eating.");
    }

    public void fly() {
        System.out.println("Sparrow flying.");
    }
}

// Penguin cannot fly but still is a Bird
class Penguin implements Bird {

    public void eat() {
        System.out.println("Penguin eating.");
    }
}

public class _03_LSP {
    public static void main(String[] args) {

        Bird sparrow = new Sparrow();
        Bird penguin = new Penguin();

        sparrow.eat();
        penguin.eat();

        FlyingBird flyingSparrow = new Sparrow();
        flyingSparrow.fly();
    }
}