package _01_Introduction_To_OOPs;

    /*
=========================================================
Problem Statement:

You are tasked with designing a class Student that stores 
and displays information about students.

The class must have:

Attributes:
1. name (String) -> Stores the name of the student
2. rollNumber (int) -> Stores the roll number of the student

Methods:
1. setDetails(String name, int rollNumber)
   -> Initializes the attributes using user-provided values.

2. displayDetails()
   -> Prints the student details in the following format:

      Name : <Student Name>
      Roll Number : <Roll Number>

Example:
Input:
Name = "Dipan"
Roll Number = 101

Output:
Name : Dipan
Roll Number : 101

=========================================================
Solution Explanation:

1. Create a class Student.
2. Declare private data members (Encapsulation).
3. Create a method setDetails() to assign values.
4. Create a method displayDetails() to print values.
5. In the Main class:
   - Create Student object.
   - Call setDetails().
   - Call displayDetails().

=========================================================
*/

class Student {

    // ============================
    // Attributes (Instance Variables)
    // ============================

    private String name;      // Stores student's name
    private int rollNumber;   // Stores student's roll number


    // ============================
    // Method to Set Details
    // ============================

    /*
     * This method assigns values to instance variables.
     * "this" keyword refers to current object.
     */
    public void setDetails(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
    }


    // ============================
    // Method to Display Details
    // ============================

    /*
     * This method prints student details
     * in required output format.
     */
    public void displayDetails() {
        System.out.println("Name : " + name);
        System.out.println("Roll Number : " + rollNumber);
    }
}
public class _03_Problem1 {
    public static void main(String[] args) {

        // Step 1: Create Student Object
        Student s1 = new Student();

        // Step 2: Set student details
        s1.setDetails("Dipan", 101);

        // Step 3: Display student details
        s1.displayDetails();
    }
}
