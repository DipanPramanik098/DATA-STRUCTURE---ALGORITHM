package _010_Linked_List._02_Fundamentals_Double_LL;

public class _10_insertBeforeGivenNode {

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

    // Function to insert before a given node (NO HEAD PROVIDED)
    public static void insertBeforeGivenNode(ListNode node, int X) {

        // Step 1: get previous node
        ListNode prev = node.prev;

        // Step 2: create new node
        ListNode newNode = new ListNode(X, prev, node);

        // Step 3: update links
        prev.next = newNode;
        node.prev = newNode;

        // No return needed (void)
    }

    // Utility: create DLL from array
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

        int[] arr = {7, 6, 5};

        // create DLL
        ListNode head = arrayToDLL(arr);

        System.out.print("Original List: ");
        printList(head);

        // node before which insertion happens (node = 5)
        ListNode node = head.next.next;

        // insert before given node
        insertBeforeGivenNode(node, 10);

        System.out.print("After Insertion: ");
        printList(head);
    }
}