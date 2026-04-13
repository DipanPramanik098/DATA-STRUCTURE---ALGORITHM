package _014_Stack_Queues._01_Implementation_Using_Dufferent_DS;

public class _05_Implement_Stack_Using_LL {
    // Node class for singly linked list
    static class Node {
        int val;
        Node next;
        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    static class LinkedListStack {
        private Node head;  // top of stack
        private int size;

        public LinkedListStack() {
            head = null;
            size = 0;
        }

        public void push(int x) {
            Node newNode = new Node(x);
            newNode.next = head;
            head = newNode;
            size++;
        }

        public int pop() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }
            int result = head.val;
            head = head.next;
            size--;
            return result;
        }

        public int top() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }
            return head.val;
        }

        public boolean isEmpty() {
            return head == null;
        }

        public int size() {
            return size;
        }
    }
}
