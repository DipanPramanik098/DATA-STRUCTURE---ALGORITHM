package _010_Linked_List._02_Fundamentals_Double_LL;

public class _07_Insert_Node_Before_Head {

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

    // Function to insert before head
    public static ListNode insertBeforeHead(ListNode head, int X) {

        // Edge Case: if list is empty
        if (head == null) {
            return new ListNode(X);
        }

        // Step 1: create new node
        ListNode newHead = new ListNode(X, null, head);

        // Step 2: update old head's prev
        head.prev = newHead;

        // Step 3: return new head
        return newHead;
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

        int[] arr = {2, 3};

        // create DLL
        ListNode head = arrayToDLL(arr);

        System.out.print("Original List: ");
        printList(head);

        // insert before head
        head = insertBeforeHead(head, 10);

        System.out.print("After Inserting Before Head: ");
        printList(head);
    }
}