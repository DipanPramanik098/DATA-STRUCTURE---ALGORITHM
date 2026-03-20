package _010_Linked_List._01_Fundamentals_Singly_LL;

import java.util.ArrayList;
import java.util.List;

public class _02_Traversal_LL {

    // Node class for singly linked list
    static class ListNode {
        int data;         // stores the value of node
        ListNode next;    // stores reference of next node

        // default constructor
        ListNode() {
            this.data = 0;
            this.next = null;
        }

        // constructor to create node with data
        ListNode(int data) {
            this.data = data;
            this.next = null;
        }

        // constructor to create node with data and next reference
        ListNode(int data, ListNode next) {
            this.data = data;
            this.next = next;
        }
    }

    // function to traverse linked list and return elements in a list
    public static List<Integer> LLTraversal(ListNode head) {

        // temp is used for traversal
        // we keep head unchanged
        ListNode temp = head;

        // result list to store linked list values
        List<Integer> ans = new ArrayList<>();

        // continue traversal until end of linked list
        while (temp != null) {

            // store current node's data
            ans.add(temp.data);

            // move to next node
            temp = temp.next;
        }

        // return final list of values
        return ans;
    }

    public static void main(String[] args) {

        // manually creating nodes
        ListNode y1 = new ListNode(2);
        ListNode y2 = new ListNode(5);
        ListNode y3 = new ListNode(8);
        ListNode y4 = new ListNode(7);

        // linking the nodes
        y1.next = y2;
        y2.next = y3;
        y3.next = y4;

        // head of linked list is y1
        ListNode head = y1;

        // function call
        List<Integer> result = LLTraversal(head);

        // printing traversal result
        System.out.println("Linked List Values:");
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}