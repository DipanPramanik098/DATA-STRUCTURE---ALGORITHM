package _010_Linked_List._02_Fundamentals_Double_LL;

public class _04_Delete_Tail_DLL {

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

    // Function to delete tail of DLL
    public static ListNode deleteTail(ListNode head) {

        // Edge Case: empty OR single node
        if (head == null || head.next == null) {
            return null;
        }

        // Step 1: reach tail
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }

        // Step 2: get second last node
        ListNode newTail = tail.prev;

        // Step 3: break links
        newTail.next = null;  // remove forward link
        tail.prev = null;     // remove backward link

        // Step 4: return head
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

        // delete tail
        head = deleteTail(head);

        System.out.print("After Deleting Tail: ");
        printList(head);
    }
}