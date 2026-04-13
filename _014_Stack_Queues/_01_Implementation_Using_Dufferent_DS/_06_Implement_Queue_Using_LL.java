package _014_Stack_Queues._01_Implementation_Using_Dufferent_DS;

public class _06_Implement_Queue_Using_LL {
    // Node class for singly linked list
    static class Node {
        int val;
        Node next;
        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    static class LinkedListQueue {
        private Node front;  // front of queue (for dequeue/peek)
        private Node rear;   // rear of queue (for enqueue)
        private int size;

        public LinkedListQueue() {
            front = null;
            rear = null;
            size = 0;
        }

        // Add element to the end (rear)
        public void push(int x) {
            Node newNode = new Node(x);
            if (isEmpty()) {
                front = rear = newNode;
            } else {
                rear.next = newNode;
                rear = newNode;
            }
            size++;
        }

        // Remove and return front element
        public int pop() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            int result = front.val;
            front = front.next;
            // If queue becomes empty, rear must also be null
            if (front == null) {
                rear = null;
            }
            size--;
            return result;
        }

        // Return front element without removing
        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return front.val;
        }

        // Check if queue is empty
        public boolean isEmpty() {
            return front == null;
        }

        public int size() {
            return size;
        }
    }
}
