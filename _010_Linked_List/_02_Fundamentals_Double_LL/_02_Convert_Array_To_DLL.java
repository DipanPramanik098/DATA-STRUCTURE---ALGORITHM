package _010_Linked_List._02_Fundamentals_Double_LL;

public class _02_Convert_Array_To_DLL {

    // Node class for Doubly Linked List
    static class ListNode {
        int data;        // value of node
        ListNode prev;   // pointer to previous node
        ListNode next;   // pointer to next node

        ListNode(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }

        ListNode(int data, ListNode prev, ListNode next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    // Function to convert array to Doubly Linked List
    public static ListNode arrayToDLL(int[] arr) {

        // Edge Case: empty array
        if (arr == null || arr.length == 0) {
            return null;
        }

        // Step 1: create head node
        ListNode head = new ListNode(arr[0]);

        // prev pointer to track previous node
        ListNode prev = head;

        // Step 2: iterate through array
        for (int i = 1; i < arr.length; i++) {

            // create new node
            ListNode temp = new ListNode(arr[i], prev, null);

            // connect previous node to current
            prev.next = temp;

            // move prev forward
            prev = temp;
        }

        // Step 3: return head
        return head;
    }

    // Utility: print DLL (forward)
    public static void printForward(ListNode head) {
        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    // Utility: print DLL (backward)
    public static void printBackward(ListNode head) {
        ListNode temp = head;

        // move to last node
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

        /*
            Example:
            arr = [1, 2, 3, 4]
        */

        int[] arr = {1, 2, 3, 4};

        // convert array to DLL
        ListNode head = arrayToDLL(arr);

        System.out.println("Forward Traversal:");
        printForward(head);

        System.out.println("Backward Traversal:");
        printBackward(head);
    }
}