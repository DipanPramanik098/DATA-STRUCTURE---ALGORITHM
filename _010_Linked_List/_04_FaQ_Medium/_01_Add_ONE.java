package _010_Linked_List._04_FaQ_Medium;

public class _01_Add_ONE {

    // Definition of ListNode
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // 🔁 Reverse Linked List
    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next; // store next
            curr.next = prev;          // reverse link
            prev = curr;               // move prev
            curr = next;               // move curr
        }

        return prev;
    }

    // ➕ Add One Function
    public static ListNode addOne(ListNode head) {

        // Step 1: Reverse the list
        head = reverse(head);

        ListNode curr = head;
        int carry = 1; // initially we add 1

        // Step 2: Traverse and add
        while (curr != null) {

            int sum = curr.val + carry;

            curr.val = sum % 10;   // update digit
            carry = sum / 10;      // update carry

            // If no carry → break early
            if (carry == 0) break;

            // If last node and still carry
            if (curr.next == null) {
                curr.next = new ListNode(carry);
                break;
            }

            curr = curr.next;
        }

        // Step 3: Reverse back
        head = reverse(head);

        return head;
    }

    // 🖨️ Print Linked List
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    // 🚀 Main Method
    public static void main(String[] args) {

        // Create List: 9 -> 9
        ListNode head = new ListNode(9);
        head.next = new ListNode(9);

        System.out.print("Original: ");
        printList(head);

        head = addOne(head);

        System.out.print("After +1: ");
        printList(head);
    }
}