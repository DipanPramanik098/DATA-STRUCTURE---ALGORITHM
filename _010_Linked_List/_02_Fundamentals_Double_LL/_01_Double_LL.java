package _010_Linked_List._02_Fundamentals_Double_LL;

public class _01_Double_LL {

    // Node class for Doubly Linked List
    static class Node {
        int data;     // value of node
        Node next;    // pointer to next node
        Node prev;    // pointer to previous node

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    Node head; // head of DLL

    // Insert at head
    public void insertAtHead(int data) {
        Node newNode = new Node(data);

        // if list is not empty
        if (head != null) {
            newNode.next = head;  // new node points to old head
            head.prev = newNode;  // old head points back to new node
        }

        head = newNode; // update head
    }

    // Insert at tail
    public void insertAtTail(int data) {
        Node newNode = new Node(data);

        // if list is empty
        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;

        // traverse to last node
        while (temp.next != null) {
            temp = temp.next;
        }

        // connect last node with new node
        temp.next = newNode;
        newNode.prev = temp;
    }

    // Forward Traversal
    public void displayForward() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    // Reverse Traversal
    public void displayBackward() {
        Node temp = head;

        // move to last node first
        while (temp != null && temp.next != null) {
            temp = temp.next;
        }

        // traverse backward
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        _01_Double_LL list = new _01_Double_LL();

        // inserting elements
        list.insertAtHead(2);
        list.insertAtHead(1);
        list.insertAtTail(3);
        list.insertAtTail(4);

        System.out.println("Forward Traversal:");
        list.displayForward();

        System.out.println("Backward Traversal:");
        list.displayBackward();
    }
}