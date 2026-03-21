package _010_Linked_List._05_FAQ_Hard;

public class _04_Flattening_LL {

    // Definition of special linked list node
    static class ListNode {
        int val;
        ListNode next;
        ListNode child;

        ListNode(int val) {
            this.val = val;
            this.next = null;
            this.child = null;
        }
    }

    // Function to merge two sorted child linked lists
    public static ListNode merge(ListNode list1, ListNode list2) {

        // Dummy node to simplify merging
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        // Merge based on smaller value
        while (list1 != null && list2 != null) {

            if (list1.val <= list2.val) {
                temp.child = list1;
                temp = list1;
                list1 = list1.child;
            } else {
                temp.child = list2;
                temp = list2;
                list2 = list2.child;
            }

            // next should be null in flattened list
            temp.next = null;
        }

        // Attach remaining nodes
        if (list1 != null) {
            temp.child = list1;
        } else {
            temp.child = list2;
        }

        return dummy.child;
    }

    // Function to flatten the linked list
    public static ListNode flatten(ListNode head) {

        // Base case
        if (head == null || head.next == null) {
            return head;
        }

        // Recursively flatten the right side
        head.next = flatten(head.next);

        // Merge current vertical list with flattened right side
        head = merge(head, head.next);

        return head;
    }

    // Utility function to print flattened list
    public static void printChildList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.child != null) {
                System.out.print(" -> ");
            }
            head = head.child;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // Creating sample structure

        ListNode head = new ListNode(5);
        head.child = new ListNode(7);
        head.child.child = new ListNode(8);
        head.child.child.child = new ListNode(30);

        head.next = new ListNode(10);
        head.next.child = new ListNode(20);

        head.next.next = new ListNode(19);
        head.next.next.child = new ListNode(22);
        head.next.next.child.child = new ListNode(50);

        head.next.next.next = new ListNode(28);
        head.next.next.next.child = new ListNode(35);
        head.next.next.next.child.child = new ListNode(40);
        head.next.next.next.child.child.child = new ListNode(45);

        // Flatten the list
        ListNode flatHead = flatten(head);

        // Print result
        System.out.print("Flattened List: ");
        printChildList(flatHead);
    }
}