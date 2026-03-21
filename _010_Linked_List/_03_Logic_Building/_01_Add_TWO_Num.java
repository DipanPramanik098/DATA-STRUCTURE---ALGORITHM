package _010_Linked_List._03_Logic_Building;

public class _01_Add_TWO_Num {

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

    // Function to add two numbers represented by linked lists
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // Dummy node helps in easy creation of result list
        ListNode dummy = new ListNode(-1);

        // temp is used to build the answer list
        ListNode temp = dummy;

        // carry stores carry generated after sum
        int carry = 0;

        // Continue till both lists end and no carry remains
        while (l1 != null || l2 != null || carry != 0) {

            int sum = carry; // start sum with carry

            // Add value from first linked list if present
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            // Add value from second linked list if present
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            // Create node with current digit
            int digit = sum % 10;
            temp.next = new ListNode(digit);

            // Update carry for next iteration
            carry = sum / 10;

            // Move temp ahead
            temp = temp.next;
        }

        // dummy.next is the actual head of result
        return dummy.next;
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

        // l1 = 5 -> 4   (represents 45)
        ListNode l1 = new ListNode(5, new ListNode(4));

        // l2 = 4   (represents 4)
        ListNode l2 = new ListNode(4);

        System.out.print("Linked List 1: ");
        printList(l1);

        System.out.print("Linked List 2: ");
        printList(l2);

        // Add two numbers
        ListNode result = addTwoNumbers(l1, l2);

        System.out.print("Result: ");
        printList(result);
    }
}