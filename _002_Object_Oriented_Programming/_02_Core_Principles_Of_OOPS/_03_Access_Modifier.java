package _02_Core_Principles_Of_OOPS;

/*
====================================================================

Access Modifiers in Java:
1. private
2. default (package-private)
3. protected
4. public

They control the visibility of:
- Variables
- Methods
- Constructors
- Classes

Access Scope Table:

Modifier      Same Class   Same Package   Subclass   World
------------------------------------------------------------
private       ✔            ❌             ❌         ❌
default       ✔            ✔              ❌         ❌
protected     ✔            ✔              ✔          ❌
public        ✔            ✔              ✔          ✔

====================================================================
*/


// ==============================
// Parent Class Demonstrating All Access Modifiers
// ==============================

class AccessDemo {

    // ------------------------------
    // 1️⃣ PRIVATE
    // ------------------------------
    // Accessible only inside this class
    private int privateVar = 10;

    private void privateMethod() {
        System.out.println("Private Method Accessed");
    }


    // ------------------------------
    // 2️⃣ DEFAULT (Package-Private)
    // ------------------------------
    // Accessible inside same package only
    int defaultVar = 20;

    void defaultMethod() {
        System.out.println("Default Method Accessed");
    }


    // ------------------------------
    // 3️⃣ PROTECTED
    // ------------------------------
    // Accessible in same package + subclass (even different package)
    protected int protectedVar = 30;

    protected void protectedMethod() {
        System.out.println("Protected Method Accessed");
    }


    // ------------------------------
    // 4️⃣ PUBLIC
    // ------------------------------
    // Accessible everywhere
    public int publicVar = 40;

    public void publicMethod() {
        System.out.println("Public Method Accessed");
    }


    // Method inside same class accessing all members
    public void accessInsideClass() {
        System.out.println("\nAccessing inside same class:");

        System.out.println(privateVar);
        System.out.println(defaultVar);
        System.out.println(protectedVar);
        System.out.println(publicVar);

        privateMethod();
        defaultMethod();
        protectedMethod();
        publicMethod();
    }
}


// ==============================
// Subclass (Same Package)
// ==============================

class ChildDemo extends AccessDemo {

    public void accessFromSubclass() {

        System.out.println("\nAccessing from Subclass (Same Package):");

        // privateVar ❌ NOT accessible
        // privateMethod() ❌ NOT accessible

        System.out.println(defaultVar);      // ✔ accessible
        System.out.println(protectedVar);    // ✔ accessible
        System.out.println(publicVar);       // ✔ accessible

        defaultMethod();      // ✔
        protectedMethod();    // ✔
        publicMethod();       // ✔
    }
}



// ==============================
// Main Class
// ==============================

public class _03_Access_Modifier {

    public static void main(String[] args) {

        AccessDemo obj = new AccessDemo();

        // Access from same package (non-subclass)
        System.out.println("Accessing from Main (Same Package):");

        // obj.privateVar ❌ NOT accessible

        System.out.println(obj.defaultVar);     // ✔
        System.out.println(obj.protectedVar);   // ✔
        System.out.println(obj.publicVar);      // ✔

        obj.defaultMethod();    // ✔
        obj.protectedMethod();  // ✔
        obj.publicMethod();     // ✔


        // Access inside same class
        obj.accessInsideClass();


        // Access from subclass
        ChildDemo child = new ChildDemo();
        child.accessFromSubclass();
    }
}