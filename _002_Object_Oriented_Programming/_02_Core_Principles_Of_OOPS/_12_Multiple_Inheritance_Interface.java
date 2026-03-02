package _02_Core_Principles_Of_OOPS;

/*
=========================================================
Multiple Inheritance using Interfaces
(Java does not support multiple inheritance with classes)
=========================================================
*/

interface A {
    void show();
}

interface B {
    void display();
}

class C implements A, B {

    public void show() {
        System.out.println("Interface A method");
    }

    public void display() {
        System.out.println("Interface B method");
    }
}

public class _12_Multiple_Inheritance_Interface {

    public static void main(String[] args) {

        C obj = new C();

        obj.show();
        obj.display();
    }
}