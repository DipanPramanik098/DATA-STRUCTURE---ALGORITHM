package _02_Core_Principles_Of_OOPS;

/*
=========================================================
Super Keyword
=========================================================
*/

class Parent {

    int number = 10;

    Parent() {
        System.out.println("Parent Constructor");
    }

    void show() {
        System.out.println("Parent Method");
    }
}

class Child extends Parent {

    int number = 20;

    Child() {
        super();  // Call parent constructor
        System.out.println("Child Constructor");
    }

    void display() {
        System.out.println("Child number: " + number);
        System.out.println("Parent number: " + super.number);
        super.show();
    }
}

public class _10_Super_Keyword {

    public static void main(String[] args) {

        Child obj = new Child();
        obj.display();
    }
}