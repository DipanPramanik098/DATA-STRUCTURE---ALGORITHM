package _010_Linked_List._01_Fundamentals_Singly_LL;
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
public class _01_singlyLL {
    Node head; // points to first node

    public static void main(String[] args) {
        _01_singlyLL list = new _01_singlyLL();

        // manually creating nodes
        Node first = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);

        // connecting nodes
        list.head = first;
        first.next = second;
        second.next = third;

        // printing list manually
        Node temp = list.head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
