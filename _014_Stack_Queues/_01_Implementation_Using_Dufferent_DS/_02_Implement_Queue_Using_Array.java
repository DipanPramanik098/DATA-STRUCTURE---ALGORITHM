package _014_Stack_Queues._01_Implementation_Using_Dufferent_DS;

public class _02_Implement_Queue_Using_Array {
    static class ArrayQueue {
        private int[] arr;
        private int start, end;
        private int currSize, maxSize;

        public ArrayQueue() {
            maxSize = 10;          // default capacity
            arr = new int[maxSize];
            start = -1;
            end = -1;
            currSize = 0;
        }

        public ArrayQueue(int size) {
            maxSize = size;
            arr = new int[maxSize];
            start = -1;
            end = -1;
            currSize = 0;
        }

        public void push(int x) {
            if (currSize == maxSize) {
                System.out.println("Queue is full");
                return;
            }
            if (end == -1) {        // first element
                start = 0;
                end = 0;
            } else {
                end = (end + 1) % maxSize;
            }
            arr[end] = x;
            currSize++;
        }

        public int pop() {
            if (currSize == 0) {
                System.out.println("Queue is empty");
                return -1;
            }
            int popped = arr[start];
            if (currSize == 1) {    // queue becomes empty
                start = -1;
                end = -1;
            } else {
                start = (start + 1) % maxSize;
            }
            currSize--;
            return popped;
        }

        public int peek() {
            if (currSize == 0) {
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[start];
        }

        public boolean isEmpty() {
            return currSize == 0;
        }
    }
}
