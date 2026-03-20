package _010_Linked_List._02_Fundamentals_Double_LL;

public class _05_Delete_Kth_DLL {

    // Node class
    static class ListNode {
        int data;
        ListNode next;
        ListNode prev;

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

    // Function to delete Kth node
    public static ListNode deleteKth(ListNode head, int k) {

        // Edge Case: empty list
        if (head == null) return null;

        int count = 0;
        ListNode temp = head;

        // Step 1: reach Kth node
        while (temp != null) {
            count++;
            if (count == k) break;
            temp = temp.next;
        }

        // If k > length
        if (temp == null) return head;

        ListNode prev = temp.prev;
        ListNode next = temp.next;

        // Case 1: only one node
        if (prev == null && next == null) {
            return null;
        }

        // Case 2: deleting head
        else if (prev == null) {
            head = next;
            next.prev = null;
        }

        // Case 3: deleting tail
        else if (next == null) {
            prev.next = null;
        }

        // Case 4: deleting middle node
        else {
            prev.next = next;
            next.prev = prev;
        }

        // disconnect node
        temp.next = null;
        temp.prev = null;

        return head;
    }

    // Utility: array to DLL
    public static ListNode arrayToDLL(int[] arr) {
        if (arr.length == 0) return null;

        ListNode head = new ListNode(arr[0]);
        ListNode prev = head;

        for (int i = 1; i < arr.length; i++) {
            ListNode node = new ListNode(arr[i], null, prev);
            prev.next = node;
            prev = node;
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

        int[] arr = {2, 5, 7};
        int k = 3;

        ListNode head = arrayToDLL(arr);

        System.out.print("Original List: ");
        printList(head);

        head = deleteKth(head, k);

        System.out.print("After Deleting Kth Node: ");
        printList(head);
    }
}