package _06_Basic_Hashing;

import java.util.*;

public class _01_Hashing_DEMO {

    // ===============================
    // 1️⃣ Number Hashing using Array
    // ===============================
    public static void numberHashingDemo() {

        System.out.println("----- Number Hashing (Array Based) -----");

        int[] arr = {5, 6, 5, 6, 9, 6};

        // Assuming numbers are <= 10
        int[] hash = new int[10];

        // Preprocessing (O(N))
        for (int num : arr) {
            hash[num]++;
        }

        // Query (O(1))
        System.out.println("Frequency of 6: " + hash[6]);
        System.out.println("Frequency of 5: " + hash[5]);
    }

    // ===============================
    // 2️⃣ Character Hashing (ASCII)
    // ===============================
    public static void characterHashingASCII() {

        System.out.println("\n----- Character Hashing (Full ASCII) -----");

        String str = "abacaba";

        int[] hash = new int[123];  // ASCII range

        for (char ch : str.toCharArray()) {
            hash[ch]++;
        }

        System.out.println("Frequency of 'a': " + hash['a']);
        System.out.println("Frequency of 'b': " + hash['b']);
        System.out.println("Frequency of 'c': " + hash['c']);
    }

    // ===============================
    // 3️⃣ Optimized Character Hashing (Lowercase)
    // ===============================
    public static void characterHashingOptimized() {

        System.out.println("\n----- Character Hashing (Lowercase Only) -----");

        String str = "programming";

        int[] hash = new int[26];

        for (char ch : str.toCharArray()) {
            hash[ch - 'a']++;
        }

        System.out.println("Frequency of 'g': " + hash['g' - 'a']);
        System.out.println("Frequency of 'r': " + hash['r' - 'a']);
    }

    // ===============================
    // 4️⃣ HashMap Frequency Counting
    // ===============================
    public static void hashMapDemo() {

        System.out.println("\n----- HashMap Frequency Counting -----");

        int[] arr = {10, 20, 10, 30, 20, 10};

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        System.out.println("Frequency Map: " + map);
        System.out.println("Frequency of 10: " + map.get(10));
    }

    // ===============================
    // 5️⃣ Division Method (Manual Hash Function)
    // ===============================
    public static void divisionMethodDemo() {

        System.out.println("\n----- Division Method (h(k) = k % p) -----");

        int[] keys = {56, 75, 42, 88, 91};
        int p = 7;  // prime number

        for (int key : keys) {
            int index = key % p;
            System.out.println("Key " + key + " -> Index " + index);
        }
    }

    // ===============================
    // 6️⃣ Chaining for Collision Handling
    // ===============================
    public static void chainingDemo() {

        System.out.println("\n----- Chaining Collision Handling -----");

        int[] keys = {56, 75, 42, 88, 91};
        int p = 7;

        // Hash table with LinkedList
        LinkedList<Integer>[] hashTable = new LinkedList[p];

        // Initialize
        for (int i = 0; i < p; i++) {
            hashTable[i] = new LinkedList<>();
        }

        // Insert elements
        for (int key : keys) {
            int index = key % p;
            hashTable[index].add(key);
        }

        // Print hash table
        for (int i = 0; i < p; i++) {
            System.out.println("Index " + i + " -> " + hashTable[i]);
        }
    }

    // ===============================
    // 7️⃣ Load Factor Demo
    // ===============================
    public static void loadFactorDemo() {

        System.out.println("\n----- Load Factor Calculation -----");

        int numberOfElements = 5;
        int tableSize = 7;

        double loadFactor = (double) numberOfElements / tableSize;

        System.out.println("Load Factor = " + loadFactor);
    }

    // ===============================
    // MAIN METHOD
    // ===============================
    public static void main(String[] args) {

        numberHashingDemo();

        characterHashingASCII();

        characterHashingOptimized();

        hashMapDemo();

        divisionMethodDemo();

        chainingDemo();

        loadFactorDemo();
    }
}