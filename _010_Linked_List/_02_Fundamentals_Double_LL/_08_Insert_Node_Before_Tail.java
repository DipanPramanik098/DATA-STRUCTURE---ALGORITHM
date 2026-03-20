package _010_Linked_List._02_Fundamentals_Double_LL;

public class _08_Insert_Node_Before_Tail {

    // Node class
    static class ListNode {
        int data;
        ListNode prev;
        ListNode next;

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

    // Function to insert before tail
    public static ListNode insertBeforeTail(ListNode head, int X) {

        // Edge Case: only one node
        if (head == null) return null;

        if (head.next == null) {
            ListNode newHead = new ListNode(X, null, head);
            head.prev = newHead;
            return newHead;
        }

        // Step 1: reach tail
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }

        // Step 2: get previous node
        ListNode prev = tail.prev;

        // Step 3: create new node
        ListNode newNode = new ListNode(X, prev, tail);

        // Step 4: update links
        prev.next = newNode;
        tail.prev = newNode;

        return head;
    }

    // Utility: array to DLL
    public static ListNode arrayToDLL(int[] arr) {
        if (arr.length == 0) return null;

        ListNode head = new ListNode(arr[0]);
        ListNode prev = head;

        for (int i = 1; i < arr.length; i++) {
            ListNode temp = new ListNode(arr[i], prev, null);
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

        int[] arr = {4, 5};

        // create DLL
        ListNode head = arrayToDLL(arr);

        System.out.print("Original List: ");
        printList(head);

        // insert before tail
        head = insertBeforeTail(head, 6);

        System.out.print("After Inserting Before Tail: ");
        printList(head);
    }
}