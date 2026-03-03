package _06_OOP_Design_AND_Lifecycle_Management;

// Demonstrates eligibility for garbage collection

class GCExample {

    protected void finalize() throws Throwable {
        // finalize() may run before GC (deprecated in modern Java)
        System.out.println("Object is being garbage collected.");
    }
}

public class _08_Garbage_Collection_Process {

    public static void main(String[] args) {

        GCExample obj = new GCExample();

        obj = null;  // Remove reference

        // Request garbage collection (not guaranteed)
        System.gc();

        System.out.println("End of main method.");
    }
}