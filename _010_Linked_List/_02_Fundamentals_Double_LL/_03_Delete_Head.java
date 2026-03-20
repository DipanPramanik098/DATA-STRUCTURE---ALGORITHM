package _010_Linked_List._02_Fundamentals_Double_LL;

public class _03_Delete_Head {

    // Node class for Doubly Linked List
    static class ListNode {
        int data;        // value of node
        ListNode next;   // pointer to next node
        ListNode prev;   // pointer to previous node

        ListNode(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }

        ListNode(int data, ListNode next, ListNode prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    // Function to delete head of DLL
    public static ListNode deleteHead(ListNode head) {

        // Edge Case 1: empty list OR single node
        if (head == null || head.next == null) {
            return null;
        }

        // store old head
        ListNode oldHead = head;

        // move head to next node
        head = head.next;

        // remove backward link
        head.prev = null;

        // remove forward link of old head
        oldHead.next = null;

        // return new head
        return head;
    }

    // Utility: convert array to DLL
    public static ListNode arrayToDLL(int[] arr) {
        if (arr.length == 0) return null;

        ListNode head = new ListNode(arr[0]);
        ListNode prev = head;

        for (int i = 1; i < arr.length; i++) {
            ListNode temp = new ListNode(arr[i], null, prev);
            prev.next = temp;
            prev = temp;
        }

        return head;
    }

    // Utility: print DLL
    public static void printList(ListNode head) {
        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3};

        // create DLL
        ListNode head = arrayToDLL(arr);

        System.out.print("Original List: ");
        printList(head);

        // delete head
        head = deleteHead(head);

        System.out.print("After Deleting Head: ");
        printList(head);
    }
}