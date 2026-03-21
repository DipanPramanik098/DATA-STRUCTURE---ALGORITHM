package _010_Linked_List._05_FAQ_Hard;

public class _02_Rotate_LL {

    // Definition of singly linked list node
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
            this.val = 0;
            this.next = null;
        }

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // Function to rotate linked list to the right by k places
    public static ListNode rotateRight(ListNode head, int k) {

        // Edge cases
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Step 1: Find length and last node
        ListNode tail = head;
        int length = 1;

        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // Step 2: Reduce unnecessary rotations
        k = k % length;

        // If no effective rotation needed
        if (k == 0) {
            return head;
        }

        // Step 3: Make the list circular
        tail.next = head;

        // Step 4: Find the new tail
        int stepsToNewTail = length - k;
        ListNode newTail = tail;

        while (stepsToNewTail-- > 0) {
            newTail = newTail.next;
        }

        // Step 5: Set new head
        ListNode newHead = newTail.next;

        // Step 6: Break the circle
        newTail.next = null;

        return newHead;
    }

    // Utility method to print linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) {
                System.out.print(" -> ");
            }
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // Create linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.print("Original List: ");
        printList(head);

        int k = 2;
        head = rotateRight(head, k);

        System.out.print("Rotated List: ");
        printList(head);
    }
}