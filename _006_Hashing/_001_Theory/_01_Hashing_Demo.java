package _006_Hashing._001_Theory;

import java.util.HashMap;
import java.util.Map;

public class _01_Hashing_Demo {

    public static void main(String[] args) {

        /*
         * ------------------------------------------------------
         * HASHING BASIC CONCEPT
         * ------------------------------------------------------
         * 
         * Hashing is a technique used to store and retrieve data quickly.
         * 
         * A Hash Function converts a KEY into an index (bucket) where the value is
         * stored.
         * 
         * Example:
         * Key -> Hash Function -> Index -> Value stored
         * 
         * HashMap internally uses:
         * - Array of buckets
         * - Hash function
         * - Collision handling (LinkedList / Tree)
         * 
         * Time Complexity (Average):
         * Insert : O(1)
         * Search : O(1)
         * Delete : O(1)
         */

        /*
         * ------------------------------------------------------
         * CREATING A HASHMAP
         * ------------------------------------------------------
         * 
         * Syntax:
         * HashMap<KeyType, ValueType> map = new HashMap<>();
         */

        HashMap<Integer, String> students = new HashMap<>();

        /*
         * ------------------------------------------------------
         * put() METHOD
         * ------------------------------------------------------
         * 
         * Adds a key-value pair to the HashMap.
         * 
         * If key already exists → value will be replaced.
         */

        students.put(1, "Rahul");
        students.put(2, "Amit");
        students.put(3, "Priya");
        students.put(4, "Neha");

        System.out.println("HashMap after insertion: " + students);

        /*
         * ------------------------------------------------------
         * get() METHOD
         * ------------------------------------------------------
         * 
         * Retrieves the value associated with a key.
         */

        String name = students.get(2);

        System.out.println("Student with ID 2: " + name);

        /*
         * ------------------------------------------------------
         * containsKey()
         * ------------------------------------------------------
         * 
         * Checks if a key exists in HashMap.
         */

        boolean hasKey = students.containsKey(3);

        System.out.println("Key 3 exists: " + hasKey);

        /*
         * ------------------------------------------------------
         * containsValue()
         * ------------------------------------------------------
         * 
         * Checks if a value exists in HashMap.
         */

        boolean hasValue = students.containsValue("Rahul");

        System.out.println("Value Rahul exists: " + hasValue);

        /*
         * ------------------------------------------------------
         * remove()
         * ------------------------------------------------------
         * 
         * Removes a key-value pair using the key.
         */

        students.remove(4);

        System.out.println("After removing key 4: " + students);

        /*
         * ------------------------------------------------------
         * size()
         * ------------------------------------------------------
         * 
         * Returns number of elements in HashMap.
         */

        System.out.println("Size of HashMap: " + students.size());

        /*
         * ------------------------------------------------------
         * isEmpty()
         * ------------------------------------------------------
         * 
         * Checks whether HashMap is empty.
         */

        System.out.println("Is HashMap empty? " + students.isEmpty());

        /*
         * ------------------------------------------------------
         * replace()
         * ------------------------------------------------------
         * 
         * Replaces value for a given key.
         */

        students.replace(1, "Rohit");

        System.out.println("After replace: " + students);

        /*
         * ------------------------------------------------------
         * putIfAbsent()
         * ------------------------------------------------------
         * 
         * Inserts value only if key is NOT already present.
         */

        students.putIfAbsent(5, "Karan");

        System.out.println("After putIfAbsent: " + students);

        /*
         * ------------------------------------------------------
         * getOrDefault()
         * ------------------------------------------------------
         * 
         * Returns value if key exists,
         * otherwise returns default value.
         */

        String result = students.getOrDefault(10, "Not Found");

        System.out.println("GetOrDefault result: " + result);

        /*
         * ------------------------------------------------------
         * keySet()
         * ------------------------------------------------------
         * 
         * Returns all keys in HashMap.
         */

        System.out.println("All Keys: " + students.keySet());

        /*
         * ------------------------------------------------------
         * values()
         * ------------------------------------------------------
         * 
         * Returns all values in HashMap.
         */

        System.out.println("All Values: " + students.values());

        /*
         * ------------------------------------------------------
         * entrySet()
         * ------------------------------------------------------
         * 
         * Returns key-value pairs.
         * Used for iteration.
         */

        System.out.println("Iterating using entrySet:");

        for (Map.Entry<Integer, String> entry : students.entrySet()) {

            System.out.println(
                    "Key: " + entry.getKey()
                            + " Value: " + entry.getValue());
        }

        /*
         * ------------------------------------------------------
         * clear()
         * ------------------------------------------------------
         * 
         * Removes all elements from HashMap.
         */

        students.clear();

        System.out.println("After clear(): " + students);
    }
}