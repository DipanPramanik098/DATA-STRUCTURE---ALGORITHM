package _014_Stack_Queues._03_FAQs;

import java.util.Stack;

public class _01_Implement_Min_Stack {
    static class MinStack {
        private Stack<Integer> stack;
        private int mini;

        public MinStack() {
            stack = new Stack<>();
        }

        public void push(int val) {
            if (stack.isEmpty()) {
                mini = val;
                stack.push(val);
            } else if (val >= mini) {
                stack.push(val);
            } else {
                // encoded value: 2*val - mini
                stack.push(2 * val - mini);
                mini = val;
            }
        }

        public void pop() {
            if (stack.isEmpty())
                return;
            int x = stack.pop();
            if (x < mini) {
                // restore previous minimum
                mini = 2 * mini - x;
            }
        }

        public int top() {
            if (stack.isEmpty())
                return -1;
            int x = stack.peek();
            return x < mini ? mini : x;
        }

        public int getMin() {
            return mini;
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        // Example 1
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.print(minStack.getMin() + " "); // -3
        minStack.pop();
        System.out.print(minStack.top() + " "); // 0
        System.out.print(minStack.getMin() + " "); // -2

        System.out.println();

        // Quiz input
        MinStack quiz = new MinStack();
        quiz.push(10);
        quiz.push(15);
        quiz.push(5);
        System.out.print(quiz.top() + " "); // 5
        System.out.print(quiz.getMin() + " "); // 5
        quiz.pop();
        System.out.print(quiz.getMin() + " "); // 10
    }
}
