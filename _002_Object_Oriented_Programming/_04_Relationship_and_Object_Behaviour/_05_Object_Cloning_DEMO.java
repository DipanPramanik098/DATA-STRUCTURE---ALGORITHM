package _04_Relationship_and_Object_Behaviour;

/*
============================================================
                    OBJECT CLONING IN JAVA
============================================================

Definition:
Object Cloning means creating an exact copy (or near-identical copy)
of an existing object.

The cloned object:
✔ Has same data
✔ Has same structure
✔ Occupies different memory location

In Java, cloning is supported by:
1) Cloneable interface (Marker Interface)
2) clone() method from Object class

------------------------------------------------------------
PURPOSE OF OBJECT CLONING
------------------------------------------------------------

1) Efficiency
   Instead of recreating object manually, clone it.

2) Reducing Coupling
   Changes in one object should not affect another.

3) Preserving State
   Used in undo/redo, caching systems.

4) Working with Immutable Structures
   Create modifiable copy.

5) Prototype Design Pattern
   Used to duplicate objects efficiently.

------------------------------------------------------------
HOW CLONING WORKS
------------------------------------------------------------

1) Cloneable Interface
   - Marker interface (no methods).
   - Signals JVM that cloning is allowed.

2) clone() Method
   - Defined in Object class.
   - Performs SHALLOW COPY by default.

   super.clone():
   ✔ Creates new memory location.
   ✔ Copies primitive fields.
   ✔ Copies reference values (not referenced objects).

------------------------------------------------------------
TYPES OF CLONING
------------------------------------------------------------

1) Shallow Cloning
   - Copies primitive fields.
   - Copies references (shared reference).
   - Nested objects are NOT cloned.

2) Deep Cloning
   - Copies primitive fields.
   - Also clones referenced objects.
   - Fully independent copy.

============================================================
                DEMONSTRATION CODE
============================================================
*/

public class _05_Object_Cloning_DEMO {

    public static void main(String[] args) throws CloneNotSupportedException {

        System.out.println("=========== SHALLOW CLONING ===========");

        AddressShallow address1 = new AddressShallow("Mumbai");
        PersonShallow person1 = new PersonShallow("Rahul", address1);

        PersonShallow clonedPerson1 = (PersonShallow) person1.clone();

        // Modifying nested object in clone
        clonedPerson1.address.city = "New Delhi";

        // Both reflect change (shared reference)
        System.out.println(person1.name + " lives in " + person1.address.city);
        System.out.println(clonedPerson1.name + " lives in " + clonedPerson1.address.city);

        System.out.println("\n=========== DEEP CLONING ===========");

        AddressDeep address2 = new AddressDeep("Mumbai");
        PersonDeep person2 = new PersonDeep("Rahul", address2);

        PersonDeep clonedPerson2 = (PersonDeep) person2.clone();

        // Modifying nested object in clone
        clonedPerson2.address.city = "New Delhi";

        // Original remains unchanged
        System.out.println(person2.name + " lives in " + person2.address.city);
        System.out.println(clonedPerson2.name + " lives in " + clonedPerson2.address.city);
    }
}

/* ============================================================
                    SHALLOW CLONING
   ============================================================ */

/*
Shallow cloning:
✔ Only top-level object copied
✔ Nested objects share same reference
✔ Changes reflect in both objects
*/

class AddressShallow {
    String city;

    AddressShallow(String city) {
        this.city = city;
    }
}

class PersonShallow implements Cloneable {
    String name;
    AddressShallow address;

    PersonShallow(String name, AddressShallow address) {
        this.name = name;
        this.address = address;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();  // Default shallow copy
    }
}

/* ============================================================
                    DEEP CLONING
   ============================================================ */

/*
Deep cloning:
✔ Clone nested objects manually
✔ Completely independent objects
✔ Changes do NOT reflect
*/

class AddressDeep implements Cloneable {
    String city;

    AddressDeep(String city) {
        this.city = city;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new AddressDeep(this.city); // New object created
    }
}

class PersonDeep implements Cloneable {
    String name;
    AddressDeep address;

    PersonDeep(String name, AddressDeep address) {
        this.name = name;
        this.address = address;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {

        // Step 1: Shallow copy
        PersonDeep cloned = (PersonDeep) super.clone();

        // Step 2: Clone nested object manually
        cloned.address = (AddressDeep) address.clone();

        return cloned;
    }
}

/*
============================================================
          SHALLOW vs DEEP CLONING (EXAM TABLE)
============================================================

Aspect                  Shallow Cloning         Deep Cloning
------------------------------------------------------------
Primitive Fields        Copied                  Copied
Object References       Shared                  New objects created
Nested Objects          Not Independent         Independent
Override Required?      Only main class         Nested classes also
Use Case                Simple objects          Complex objects

============================================================
IMPORTANT INTERVIEW POINTS
============================================================

✔ clone() is protected in Object class.
✔ Must implement Cloneable.
✔ Otherwise → CloneNotSupportedException.
✔ super.clone() performs field-by-field copy.
✔ Deep cloning requires manual cloning.

============================================================
*/