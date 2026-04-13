package _014_Stack_Queues._01_Implementation_Using_Dufferent_DS;

import java.util.LinkedList;
import java.util.Queue;

public class _03_Implement_Stack_Using_Queue {
        static class QueueStack {
        private Queue<Integer> q;

        public QueueStack() {
            q = new LinkedList<>();
        }

        public void push(int x) {
            int s = q.size();
            q.add(x);
            // Rotate previous elements to the back
            for (int i = 0; i < s; i++) {
                q.add(q.poll());
            }
        }

        public int pop() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }
            return q.poll();
        }

        public int top() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }
            return q.peek();
        }

        public boolean isEmpty() {
            return q.isEmpty();
        }
    }
}
