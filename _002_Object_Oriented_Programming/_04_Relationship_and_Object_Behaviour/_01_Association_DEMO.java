package _04_Relationship_and_Object_Behaviour;

import java.util.*;

/*
 * ASSOCIATION DEMO
 *
 * Association is a structural relationship where one class
 * uses or interacts with another class.
 *
 * It represents a:
 *  - "uses-a"
 *  - "works-with"
 * relationship
 *
 * Key Points:
 * 1. No ownership.
 * 2. No lifecycle dependency.
 * 3. Objects can exist independently.
 * 4. Implemented using object reference, method parameter, or collection.
 */

public class _01_Association_DEMO {

    public static void main(String[] args) {

        System.out.println("===== ONE TO ONE ASSOCIATION =====");

        Passport passport = new Passport("IND12345");
        Person person = new Person("Dipan", passport); // Person uses Passport

        person.showDetails();

        System.out.println("\n===== ONE TO MANY ASSOCIATION =====");

        Teacher teacher = new Teacher("Mr. Sharma");

        Student s1 = new Student("Rahul");
        Student s2 = new Student("Aman");

        teacher.addStudent(s1);
        teacher.addStudent(s2);

        teacher.showStudents();

        System.out.println("\n===== MANY TO MANY ASSOCIATION =====");

        Course java = new Course("Java");
        Course dsa = new Course("DSA");

        Student s3 = new Student("Priya");

        s3.enrollCourse(java);
        s3.enrollCourse(dsa);

        s3.showCourses();

        System.out.println("\n===== BIDIRECTIONAL ASSOCIATION =====");

        Doctor doctor = new Doctor("Dr. Sen");
        Patient patient = new Patient("Riya");

        doctor.addPatient(patient);
        patient.setDoctor(doctor);

        doctor.showPatients();
        patient.showDoctor();
    }
}

/* ============================================================
   1️⃣ ONE-TO-ONE ASSOCIATION
   Example: Person ↔ Passport
   Each person has one passport.
   Both objects can exist independently.
   ============================================================ */

class Passport {
    private String number;

    Passport(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }
}

class Person {
    private String name;
    private Passport passport;  // Association (One-to-One)

    Person(String name, Passport passport) {
        this.name = name;
        this.passport = passport;
    }

    void showDetails() {
        System.out.println("Name: " + name);
        System.out.println("Passport No: " + passport.getNumber());
    }
}

/* ============================================================
   2️⃣ ONE-TO-MANY ASSOCIATION
   Example: Teacher → Students
   One teacher teaches many students.
   Students can exist without teacher.
   ============================================================ */

class Teacher {
    private String name;
    private List<Student> students = new ArrayList<>();

    Teacher(String name) {
        this.name = name;
    }

    void addStudent(Student s) {
        students.add(s);
    }

    void showStudents() {
        System.out.println("Teacher: " + name);
        for (Student s : students) {
            System.out.println("Student: " + s.getName());
        }
    }
}

/* ============================================================
   3️⃣ MANY-TO-MANY ASSOCIATION
   Example: Student ↔ Course
   One student can enroll in many courses.
   One course can have many students.
   ============================================================ */

class Course {
    private String courseName;
    private List<Student> students = new ArrayList<>();

    Course(String courseName) {
        this.courseName = courseName;
    }

    String getCourseName() {
        return courseName;
    }

    void addStudent(Student s) {
        students.add(s);
    }
}

class Student {
    private String name;
    private List<Course> courses = new ArrayList<>();

    Student(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    void enrollCourse(Course c) {
        courses.add(c);
        c.addStudent(this);  // maintain bidirectional link
    }

    void showCourses() {
        System.out.println("Student: " + name);
        for (Course c : courses) {
            System.out.println("Enrolled in: " + c.getCourseName());
        }
    }
}

/* ============================================================
   4️⃣ BIDIRECTIONAL ASSOCIATION
   Example: Doctor ↔ Patient
   Both classes know about each other.
   ============================================================ */

class Doctor {
    private String name;
    private List<Patient> patients = new ArrayList<>();

    Doctor(String name) {
        this.name = name;
    }

    void addPatient(Patient p) {
        patients.add(p);
    }

    void showPatients() {
        System.out.println("Doctor: " + name);
        for (Patient p : patients) {
            System.out.println("Patient: " + p.getName());
        }
    }

    String getName() {
        return name;
    }
}

class Patient {
    private String name;
    private Doctor doctor;   // Bidirectional association

    Patient(String name) {
        this.name = name;
    }

    void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    void showDoctor() {
        System.out.println("Patient: " + name);
        System.out.println("Consulting Doctor: " + doctor.getName());
    }

    String getName() {
        return name;
    }
}