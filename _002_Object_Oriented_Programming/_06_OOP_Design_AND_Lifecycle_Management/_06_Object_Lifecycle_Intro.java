package _06_OOP_Design_AND_Lifecycle_Management;

// Demonstrates basic object lifecycle

class Demo {

    // Method representing usage phase
    void performTask() {
        System.out.println("Task performed.");
    }
}

public class _06_Object_Lifecycle_Intro {

    public static void main(String[] args) {

        // ---------------------------
        // Creation Phase
        // ---------------------------
        Demo obj = new Demo(); 
        // obj -> reference stored in stack
        // new Demo() -> object stored in heap

        // ---------------------------
        // Usage Phase
        // ---------------------------
        obj.performTask();

        // After main() ends:
        // obj goes out of scope
        // Object becomes eligible for GC
    }
}