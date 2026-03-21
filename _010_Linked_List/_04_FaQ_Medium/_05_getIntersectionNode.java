package _010_Linked_List._04_FaQ_Medium;

public class _05_getIntersectionNode {

    // Definition of singly linked list node
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // Function to find intersection node
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        // Edge case: if any list is empty, no intersection is possible
        if (headA == null || headB == null) {
            return null;
        }

        // Two pointers for both linked lists
        ListNode p1 = headA;
        ListNode p2 = headB;

        // Move until both pointers become equal
        // They may meet at intersection node or at null
        while (p1 != p2) {

            // If p1 reaches end, move it to headB
            // otherwise move to next node
            if (p1 == null) {
                p1 = headB;
            } else {
                p1 = p1.next;
            }

            // If p2 reaches end, move it to headA
            // otherwise move to next node
            if (p2 == null) {
                p2 = headA;
            } else {
                p2 = p2.next;
            }
        }

        // Either intersection node or null
        return p1;
    }

    // Utility function to print linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        // Common part
        ListNode common = new ListNode(4);
        common.next = new ListNode(5);

        // List A: 1 -> 2 -> 3 -> 4 -> 5
        ListNode headA = new ListNode(1);
        headA.next = new ListNode(2);
        headA.next.next = new ListNode(3);
        headA.next.next.next = common;

        // List B: 7 -> 8 -> 4 -> 5
        ListNode headB = new ListNode(7);
        headB.next = new ListNode(8);
        headB.next.next = common;

        System.out.print("List A: ");
        printList(headA);

        System.out.print("List B: ");
        printList(headB);

        ListNode ans = getIntersectionNode(headA, headB);

        if (ans != null) {
            System.out.println("Intersection Node Value: " + ans.val);
        } else {
            System.out.println("No Intersection");
        }
    }
}