package _06_OOP_Design_AND_Lifecycle_Management;

// Abstraction
interface Keyboard {
    void connect();
}

// Low-level module 1
class WiredKeyboard implements Keyboard {

    public void connect() {
        System.out.println("Connected via wire.");
    }
}

// Low-level module 2
class WirelessKeyboard implements Keyboard {

    public void connect() {
        System.out.println("Connected via Bluetooth.");
    }
}

// High-level module depends on abstraction
class Computer {

    private Keyboard keyboard;

    // Dependency Injection
    public Computer(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    public void start() {
        keyboard.connect();
        System.out.println("Computer started.");
    }
}

public class _05_DIP {
    public static void main(String[] args) {

        Keyboard wired = new WiredKeyboard();
        Keyboard wireless = new WirelessKeyboard();

        Computer pc1 = new Computer(wired);
        Computer pc2 = new Computer(wireless);

        pc1.start();
        pc2.start();
    }
}