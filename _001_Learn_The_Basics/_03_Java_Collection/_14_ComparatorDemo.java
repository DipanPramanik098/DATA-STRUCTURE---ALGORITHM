import java.util.*;

/*
 * ComparatorCompleteDemo
 * Demonstrates:
 * 1. Anonymous Comparator
 * 2. Lambda Comparator
 * 3. Method Reference Comparator
 * 4. Multi-level Sorting
 * 5. Reverse Sorting
 * 6. PriorityQueue with Comparator
 */

public class _14_ComparatorDemo {

    // Custom Class
    static class Person {
        String name;
        int age;
        double salary;

        Person(String name, int age, double salary) {
            this.name = name;
            this.age = age;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return name + " | Age: " + age + " | Salary: " + salary;
        }
    }

    public static void main(String[] args) {

        List<Person> people = new ArrayList<>();

        people.add(new Person("John", 30, 50000));
        people.add(new Person("Alice", 25, 70000));
        people.add(new Person("Bob", 28, 60000));
        people.add(new Person("David", 25, 65000));

        // 1️⃣ Anonymous Comparator Class (Sort by Age)
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return Integer.compare(p1.age, p2.age);
            }
        });

        System.out.println("Sorted by Age (Anonymous):");
        System.out.println(people);

        // 2️⃣ Lambda Comparator (Sort by Salary)
        people.sort((p1, p2) -> Double.compare(p1.salary, p2.salary));

        System.out.println("\nSorted by Salary (Lambda):");
        System.out.println(people);

        // 3️⃣ Method Reference (Sort by Name)
        people.sort(Comparator.comparing(p -> p.name));

        System.out.println("\nSorted by Name (Method Reference):");
        System.out.println(people);

        // 4️⃣ Multi-Level Sorting (Age then Salary)
        people.sort(
                Comparator.comparingInt((Person p) -> p.age)
                        .thenComparingDouble(p -> p.salary)
        );

        System.out.println("\nSorted by Age then Salary:");
        System.out.println(people);

        // 5️⃣ Reverse Sorting (Salary Descending)
        people.sort(
                Comparator.comparingDouble((Person p) -> p.salary).reversed()
        );

        System.out.println("\nSorted by Salary Descending:");
        System.out.println(people);

        // 6️⃣ PriorityQueue using Comparator (Max Heap)
        PriorityQueue<Person> maxHeap =
                new PriorityQueue<>(
                        Comparator.comparingDouble((Person p) -> p.salary).reversed()
                );

        maxHeap.addAll(people);

        System.out.println("\nPriorityQueue (Max Heap by Salary):");
        while (!maxHeap.isEmpty()) {
            System.out.println(maxHeap.poll());
        }
    }
}