package _014_Stack_Queues._01_Implementation_Using_Dufferent_DS;

import java.util.Stack;

public class _04_Implement_Queue_Using_Stack {
    static class StackQueue {
        private Stack<Integer> st1;
        private Stack<Integer> st2;

        public StackQueue() {
            st1 = new Stack<>();
            st2 = new Stack<>();
        }

        // Push element to the back of queue (O(N))
        public void push(int x) {
            // Move all elements from st1 to st2
            while (!st1.isEmpty()) {
                st2.push(st1.pop());
            }
            // Push new element onto st1 (now empty)
            st1.push(x);
            // Move everything back from st2 to st1
            while (!st2.isEmpty()) {
                st1.push(st2.pop());
            }
        }

        // Remove and return front element
        public int pop() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return st1.pop();
        }

        // Return front element without removing
        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return st1.peek();
        }

        // Check if queue is empty
        public boolean isEmpty() {
            return st1.isEmpty();
        }
    }

    public static void main(String[] args) {
        
    }
}
