public class _02_GENERIC {

    // ===============================
    // 1️⃣ Generic Class
    // ===============================
    static class Box<T> {

        private T value;

        public void set(T value) {
            this.value = value;
        }

        public T get() {
            return value;
        }
    }

    // ===============================
    // 2️⃣ Multiple Type Parameters
    // ===============================
    static class Pair<K, V> {

        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    // ===============================
    // 3️⃣ Bounded Type Parameter
    // ===============================
    static class NumericBox<T extends Number> {

        private T num;

        public NumericBox(T num) {
            this.num = num;
        }

        public double square() {
            // Because T extends Number,
            // we can use Number methods like doubleValue()
            return num.doubleValue() * num.doubleValue();
        }
    }

    // ===============================
    // 4️⃣ Generic Interface
    // ===============================
    interface Repository<T> {
        void save(T obj);
    }

    static class User {
        String name;

        User(String name) {
            this.name = name;
        }
    }

    static class UserRepository implements Repository<User> {

        @Override
        public void save(User user) {
            System.out.println("Saving user: " + user.name);
        }
    }

    // ===============================
    // 5️⃣ Generic Method
    // ===============================
    public static <T> void printData(T data) {
        System.out.println("Data: " + data);
    }

    // ===============================
    // 6️⃣ Wildcards - PECS
    // ===============================

    // Producer → Extends (Read only)
    public static void printNumbers(java.util.List<? extends Number> list) {
        for (Number n : list) {
            System.out.println("Number: " + n);
        }

        // list.add(10); ❌ Not allowed
    }

    // Consumer → Super (Write allowed)
    public static void addNumbers(java.util.List<? super Integer> list) {
        list.add(100);  // ✔ Safe to add Integer
    }

    // Unbounded wildcard
    public static void printAnyList(java.util.List<?> list) {
        for (Object obj : list) {
            System.out.println("Element: " + obj);
        }
    }

    // ===============================
    // 7️⃣ Generic Constructor
    // ===============================
    static class Test {

        <T> Test(T data) {
            System.out.println("Generic Constructor Data: " + data);
        }
    }

    // ===============================
    // MAIN METHOD - All Concepts Demo
    // ===============================
    public static void main(String[] args) {

        // 1️⃣ Generic Class
        Box<Integer> intBox = new Box<>();
        intBox.set(10);
        System.out.println("Box Integer: " + intBox.get());

        Box<String> strBox = new Box<>();
        strBox.set("Java");
        System.out.println("Box String: " + strBox.get());

        // 2️⃣ Multiple Type Parameters
        Pair<Integer, String> pair = new Pair<>(1, "One");
        System.out.println("Pair: " + pair.getKey() + " - " + pair.getValue());

        // 3️⃣ Bounded Type Parameter
        NumericBox<Double> numBox = new NumericBox<>(5.5);
        System.out.println("Square: " + numBox.square());

        // 4️⃣ Generic Interface
        UserRepository repo = new UserRepository();
        repo.save(new User("Dipan"));

        // 5️⃣ Generic Method
        printData(100);
        printData("Generics");
        printData(3.14);

        // 6️⃣ Wildcards Example
        java.util.List<Integer> intList = new java.util.ArrayList<>();
        intList.add(10);
        intList.add(20);

        printNumbers(intList);
        addNumbers(intList);
        printAnyList(intList);

        // 7️⃣ Generic Constructor
        Test t1 = new Test("Hello");
        Test t2 = new Test(500);

        // ===============================
        // 8️⃣ Raw Type (Not Recommended)
        // ===============================
        Box rawBox = new Box();   // Raw type
        rawBox.set("Unsafe");     // No type safety

        // ===============================
        // 9️⃣ Type Erasure Concept
        // ===============================
        /*
           At runtime, Box<Integer> and Box<String>
           both become simply Box.

           Type parameters exist only at compile time.
        */

        // ===============================
        // 🔟 Invariance Demonstration
        // ===============================
        java.util.List<Integer> list1 = new java.util.ArrayList<>();
        // java.util.List<Number> list2 = list1; ❌ Not allowed

        // ✔ Correct way using wildcard
        java.util.List<? extends Number> list2 = list1;

        // ===============================
        // 1️⃣1️⃣ Autoboxing Reminder
        // ===============================
        // java.util.List<int> list; ❌ Not allowed
        java.util.List<Integer> validList = new java.util.ArrayList<>();
    }
}