package _03_Advance_OOPS_Feature;

/*
Practice (Static Keyword) – Medium

You are required to design a class Counter to keep track of how many
objects have been created from it. The tracking must be done using
the static keyword to ensure a single shared variable across all
instances of the class.

Class Specification:

Attributes:
    count (Integer) :
        - A static variable
        - Tracks total number of objects created

Methods:
    1) Default Constructor:
        - Increments count every time an object is created

    2) getCount():
        - Static method
        - Returns current value of count

    3) resetCount():
        - Static method
        - Resets count to 0

Example:

Input:
count = 10

Output:
Number of objects created : 10

Explanation:
We create 'count' number of objects.
Each time constructor runs, it increments the static count variable.
Then getCount() returns total number of created objects.
Finally resetCount() resets it to 0.
*/


// 🔹 Counter Class
class Counter {

    // 🔹 Static Variable (Shared among all objects)
    static int count = 0;

    // 🔹 Default Constructor
    Counter() {
        // Every time object is created,
        // this constructor runs and increments count
        count++;
    }

    // 🔹 Static Method to get current count
    static int getCount() {
        return count;
    }

    // 🔹 Static Method to reset count
    static void resetCount() {
        count = 0;
    }
}


// 🔹 Main Class
public class _07_Static_Problem {

    public static void main(String[] args) {

        // Simulated Input
        int inputCount = 10;

        // Creating 'inputCount' number of objects
        for (int i = 0; i < inputCount; i++) {
            new Counter();  // Constructor increments count
        }

        // Printing total objects created
        System.out.println("Number of objects created : " + Counter.getCount());

        // Resetting count
        Counter.resetCount();

        // Optional: Showing count after reset
        // System.out.println("After reset : " + Counter.getCount());
    }
}