
// Custom class

import java.util.ArrayList;
import java.util.List;

class Person {
    String name;
    int age;

    // Constructor to initialize object
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Overriding toString() to print object properly
    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}
public class _01_CustomClass {
    public static void main(String[] args) {

        // Creating a List to store Person objects
        List<Person> people = new ArrayList<>();

        // Adding objects
        people.add(new Person("Dipan", 21));
        people.add(new Person("Rahul", 23));

        // Printing list (calls toString internally)
        System.out.println(people);
    }
}
