package _04_Relationship_and_Object_Behaviour;

import java.util.*;

/*
 * AGGREGATION DEMO
 *
 * Aggregation is a specialized form of Association.
 *
 * It represents a weak "HAS-A" relationship.
 *
 * Key Properties:
 * 1. Whole–Part relationship.
 * 2. Part can exist independently of the whole.
 * 3. Whole does NOT create parts.
 * 4. Whole does NOT control lifecycle of parts.
 * 5. Represented by Hollow Diamond (◇) in UML.
 *
 * Example:
 * Department ◇── Employee
 */

public class _02_Aggregation_DEMO {

    public static void main(String[] args) {

        System.out.println("===== DEPARTMENT - EMPLOYEE =====");

        // Employees are created independently
        Employee e1 = new Employee("Rahul");
        Employee e2 = new Employee("Aman");

        // Employees passed to Department
        List<Employee> empList = new ArrayList<>();
        empList.add(e1);
        empList.add(e2);

        Department dept = new Department("IT", empList);

        dept.showEmployees();

        System.out.println("\nEmployees still exist independently:");
        System.out.println(e1.getName());
        System.out.println(e2.getName());

        System.out.println("\n===== LIBRARY - BOOK =====");

        Book b1 = new Book("Java Basics");
        Book b2 = new Book("Data Structures");

        List<Book> books = new ArrayList<>();
        books.add(b1);
        books.add(b2);

        Library library = new Library("City Library", books);
        library.showBooks();

        System.out.println("\n===== TEAM - PLAYER =====");

        Player p1 = new Player("Virat");
        Player p2 = new Player("Rohit");

        List<Player> players = new ArrayList<>();
        players.add(p1);
        players.add(p2);

        Team team = new Team("India", players);
        team.showPlayers();

        System.out.println("\n===== SCHOOL - TEACHER =====");

        Teacher t1 = new Teacher("Mr. Sen");
        Teacher t2 = new Teacher("Mrs. Roy");

        List<Teacher> teachers = new ArrayList<>();
        teachers.add(t1);
        teachers.add(t2);

        School school = new School("ABC School", teachers);
        school.showTeachers();
    }
}

/* ============================================================
   1️⃣ Department ◇── Employee
   Employees exist independently.
   Department just holds references.
   ============================================================ */

class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Department {
    private String deptName;
    private List<Employee> employees;

    // Employees are passed from outside (NOT created here)
    public Department(String deptName, List<Employee> employees) {
        this.deptName = deptName;
        this.employees = employees;
    }

    void showEmployees() {
        System.out.println("Department: " + deptName);
        for (Employee e : employees) {
            System.out.println("Employee: " + e.getName());
        }
    }
}

/* ============================================================
   2️⃣ Library ◇── Book
   Books exist even if Library is destroyed.
   ============================================================ */

class Book {
    private String title;

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

class Library {
    private String name;
    private List<Book> books;

    public Library(String name, List<Book> books) {
        this.name = name;
        this.books = books;
    }

    void showBooks() {
        System.out.println("Library: " + name);
        for (Book b : books) {
            System.out.println("Book: " + b.getTitle());
        }
    }
}

/* ============================================================
   3️⃣ Team ◇── Player
   Players exist without Team.
   ============================================================ */

class Player {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Team {
    private String teamName;
    private List<Player> players;

    public Team(String teamName, List<Player> players) {
        this.teamName = teamName;
        this.players = players;
    }

    void showPlayers() {
        System.out.println("Team: " + teamName);
        for (Player p : players) {
            System.out.println("Player: " + p.getName());
        }
    }
}

/* ============================================================
   4️⃣ School ◇── Teacher
   Teachers can exist without School.
   ============================================================ */

class Teacher {
    private String name;

    public Teacher(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class School {
    private String schoolName;
    private List<Teacher> teachers;

    public School(String schoolName, List<Teacher> teachers) {
        this.schoolName = schoolName;
        this.teachers = teachers;
    }

    void showTeachers() {
        System.out.println("School: " + schoolName);
        for (Teacher t : teachers) {
            System.out.println("Teacher: " + t.getName());
        }
    }
}