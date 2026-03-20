package _010_Linked_List._02_Fundamentals_Double_LL;

public class _06_Remove_Given_Node_DLL {

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

    // Function to delete given node (NO HEAD PROVIDED)
    public static void deleteNode(ListNode node) {

        // Step 1: get previous and next node
        ListNode prev = node.prev;
        ListNode next = node.next;

        // Case 1: node is tail
        if (next == null) {
            prev.next = null;   // remove forward link
            node.prev = null;   // disconnect node
            return;
        }

        // Case 2: node is middle
        prev.next = next;
        next.prev = prev;

        // Step 3: disconnect node completely
        node.next = null;
        node.prev = null;
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

        int[] arr = {1, 3, 5};

        // create DLL
        ListNode head = arrayToDLL(arr);

        System.out.print("Original List: ");
        printList(head);

        // node to delete (example: 3)
        ListNode node = head.next;

        // delete node
        deleteNode(node);

        System.out.print("After Deleting Given Node: ");
        printList(head);
    }
}