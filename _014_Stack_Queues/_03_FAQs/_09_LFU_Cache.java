package _014_Stack_Queues._03_FAQs;

import java.util.HashMap;
import java.util.Map;

class Node {
    int key, value, cnt;
    Node prev, next;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.cnt = 1;
    }
}

class DoublyLinkedList {
    int size;
    Node head, tail;

    DoublyLinkedList() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    void addFront(Node node) {
        Node nextNode = head.next;
        head.next = node;
        node.prev = head;
        node.next = nextNode;
        nextNode.prev = node;
        size++;
    }

    void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }
}

public class _09_LFU_Cache {
    private final int capacity;
    private final Map<Integer, Node> keyNode;
    private final Map<Integer, DoublyLinkedList> freqListMap;
    private int minFreq;
    private int curSize;

    public _09_LFU_Cache(int capacity) {
        this.capacity = capacity;
        this.keyNode = new HashMap<>();
        this.freqListMap = new HashMap<>();
        this.minFreq = 0;
        this.curSize = 0;
    }

    private void updateFreq(Node node) {
        // remove from current freq list
        freqListMap.get(node.cnt).removeNode(node);
        if (node.cnt == minFreq && freqListMap.get(node.cnt).size == 0) {
            minFreq++;
        }
        // move to next freq
        node.cnt++;
        freqListMap.computeIfAbsent(node.cnt, k -> new DoublyLinkedList()).addFront(node);
    }

    public int get(int key) {
        if (!keyNode.containsKey(key))
            return -1;
        Node node = keyNode.get(key);
        updateFreq(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0)
            return;
        if (keyNode.containsKey(key)) {
            Node node = keyNode.get(key);
            node.value = value;
            updateFreq(node);
            return;
        }
        if (curSize == capacity) {
            DoublyLinkedList list = freqListMap.get(minFreq);
            Node toRemove = list.tail.prev;
            keyNode.remove(toRemove.key);
            list.removeNode(toRemove);
            curSize--;
        }
        Node newNode = new Node(key, value);
        keyNode.put(key, newNode);
        freqListMap.computeIfAbsent(1, k -> new DoublyLinkedList()).addFront(newNode);
        minFreq = 1;
        curSize++;
    }

    public static void main(String[] args) {
        _09_LFU_Cache cache = new _09_LFU_Cache(1);
        // simulate quiz operations
        cache.put(1, 10);
        System.out.print(cache.get(1) + " ");
        cache.put(2, 20);
        System.out.print(cache.get(1) + " ");
        System.out.print(cache.get(2) + " ");
    }
}