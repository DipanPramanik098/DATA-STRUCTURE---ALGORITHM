package _02_Core_Principles_Of_OOPS;

/*
=========================================================
Concept:
Basic Inheritance

- Parent Class: School
- Child Class: Student
- Child inherits parent method.
=========================================================
*/

// Parent Class
class School {

    private String schoolName;

    School() {
        schoolName = "DPS";
    }

    void printSchoolName() {
        System.out.println("School Name: " + schoolName);
    }
}

// Child Class
class Student extends School {

    private String studentName;

    Student(String name) {
        this.studentName = name;
    }

    void printStudentName() {
        System.out.println("Student Name: " + studentName);
    }
}

// Main
public class _05_Inheritance_Basics {

    public static void main(String[] args) {

        Student student = new Student("Dipan");

        student.printStudentName();
        student.printSchoolName();  // inherited
    }
}