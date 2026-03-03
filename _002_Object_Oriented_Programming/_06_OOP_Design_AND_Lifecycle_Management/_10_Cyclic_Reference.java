package _06_OOP_Design_AND_Lifecycle_Management;

// Demonstrates cyclic references

class Node {
    Node next;
}

public class _10_Cyclic_Reference {

    public static void main(String[] args) {

        Node a = new Node();
        Node b = new Node();

        a.next = b;
        b.next = a;  // Cycle formed

        a = null;
        b = null;

        // Both objects now unreachable
        // Java GC will collect them
    }
}