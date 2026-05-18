package _015_Binary_Trees._01_Introduction_And_Traversals;

class Node {

    // Stores value of node
    int data;

    // Reference to left child
    Node left;

    // Reference to right child
    Node right;

    // Constructor
    Node(int key) {

        // Assign value to node
        data = key;

        // Initially no children
        left = null;
        right = null;
    }
}

public class _01_Representation {

    public static void main(String[] args) {

        // Creating root node
        Node root = new Node(1);

        // Creating left child
        root.left = new Node(2);

        // Creating right child
        root.right = new Node(3);

        // Creating left child of node 3
        root.right.left = new Node(5);

        // Printing values
        System.out.println("Root Node: " + root.data);

        System.out.println("Left Child of Root: " + root.left.data);

        System.out.println("Right Child of Root: " + root.right.data);

        System.out.println("Left Child of Node 3: " + root.right.left.data);
    }
}