package _06_OOP_Design_AND_Lifecycle_Management;

// Demonstrates reference changes and GC eligibility

class Sample {}

public class _07_Object_Creation_and_References {

    public static void main(String[] args) {

        Sample s1 = new Sample(); // Object created
        Sample s2 = s1;           // Two references

        s1 = null;  // One reference remains
        s2 = null;  // No references remain

        // Now object is eligible for GC
    }
}