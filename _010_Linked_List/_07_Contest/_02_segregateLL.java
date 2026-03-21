package _010_Linked_List._07_Contest;

// Definition
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class _02_segregateLL {

    public ListNode segregateLinkedList(ListNode head) {

        if (head == null || head.next == null) return head;

        // Dummy nodes for 3 lists
        ListNode zeroHead = new ListNode(-1);
        ListNode oneHead = new ListNode(-1);
        ListNode twoHead = new ListNode(-1);

        ListNode zero = zeroHead;
        ListNode one = oneHead;
        ListNode two = twoHead;

        ListNode temp = head;
        int index = 1;

        // Traverse list
        while (temp != null) {

            if (index % 3 == 0) {
                zero.next = temp;
                zero = zero.next;
            } 
            else if (index % 3 == 1) {
                one.next = temp;
                one = one.next;
            } 
            else {
                two.next = temp;
                two = two.next;
            }

            temp = temp.next;
            index++;
        }

        // Connect lists
        zero.next = oneHead.next != null ? oneHead.next : twoHead.next;
        one.next = twoHead.next;
        two.next = null;

        return zeroHead.next;
    }

    // Insert at end
    public static ListNode insert(ListNode head, int val) {
        ListNode newNode = new ListNode(val);

        if (head == null) return newNode;

        ListNode temp = head;
        while (temp.next != null) temp = temp.next;

        temp.next = newNode;
        return head;
    }

    // Print
    public static void printList(ListNode head) {
        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val);
            if (temp.next != null) System.out.print(" -> ");
            temp = temp.next;
        }
        System.out.println();
    }

    // MAIN
    public static void main(String[] args) {

        _02_segregateLL obj = new _02_segregateLL();

        // Create list
        ListNode head = null;
        head = insert(head, 1);
        head = insert(head, 2);
        head = insert(head, 3);
        head = insert(head, 4);
        head = insert(head, 5);
        head = insert(head, 6);

        System.out.println("Original List:");
        printList(head);

        head = obj.segregateLinkedList(head);

        System.out.println("After Segregation:");
        printList(head);
    }
}