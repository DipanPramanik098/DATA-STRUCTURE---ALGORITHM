package _06_OOP_Design_AND_Lifecycle_Management;

import java.util.ArrayList;
import java.util.List;

// Demonstrates memory leak scenario

class MemoryLeakExample {

    // Static list lives throughout program
    private static List<Object> staticList = new ArrayList<>();

    public void addObject(Object obj) {
        staticList.add(obj); // Never removed
    }
}

public class _09_Memory_Leak_Example {

    public static void main(String[] args) {

        MemoryLeakExample example = new MemoryLeakExample();

        for (int i = 0; i < 100000; i++) {
            example.addObject(new Object());
        }

        System.out.println("Objects added to static list.");
        // Objects are never GC'ed due to static reference
    }
}