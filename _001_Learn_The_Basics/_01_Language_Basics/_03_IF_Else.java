package _01_Language_Basics;

public class _03_IF_Else {

    public static void main(String[] args) {

        System.out.println("===== BASIC IF =====");

        int number = 10;

        // 1️⃣ Basic if
        if (number > 0) {
            System.out.println("Number is Positive");
        }


        System.out.println("\n===== IF - ELSE =====");

        // 2️⃣ if-else
        if (number % 2 == 0) {
            System.out.println("Number is Even");
        } else {
            System.out.println("Number is Odd");
        }


        System.out.println("\n===== IF - ELSE IF - ELSE =====");

        int marks = 82;

        // 3️⃣ if-else-if ladder
        if (marks >= 90) {
            System.out.println("Grade A");
        }
        else if (marks >= 75) {
            System.out.println("Grade B");
        }
        else if (marks >= 50) {
            System.out.println("Grade C");
        }
        else {
            System.out.println("Fail");
        }


        System.out.println("\n===== NESTED IF =====");

        int age = 20;
        boolean hasID = true;

        // 4️⃣ Nested if
        if (age >= 18) {
            if (hasID) {
                System.out.println("Entry Allowed");
            } else {
                System.out.println("ID Required");
            }
        } else {
            System.out.println("Underage");
        }


        System.out.println("\n===== LOGICAL OPERATORS =====");

        double cgpa = 8.2;

        // 5️⃣ Logical Operators (AND)
        if (age >= 18 && cgpa >= 7.5) {
            System.out.println("Eligible for Placement");
        }

        // OR Operator
        if (cgpa > 9.0 || marks > 80) {
            System.out.println("Merit Category");
        }

        // NOT Operator
        if (!hasID) {
            System.out.println("No ID Present");
        }


        System.out.println("\n===== STRING COMPARISON =====");

        String name = "Dipan";

        // 6️⃣ Correct String comparison
        if (name.equals("Dipan")) {
            System.out.println("Name Matched");
        } else {
            System.out.println("Name Not Matched");
        }


        System.out.println("\n===== TERNARY OPERATOR =====");

        // 7️⃣ Ternary Operator
        String result = (number > 0) ? "Positive" : "Negative";
        System.out.println("Ternary Result: " + result);


        System.out.println("\n===== SHORT-CIRCUIT DEMO =====");

        // 8️⃣ Short-circuit evaluation
        if (false && checkMethod()) {
            System.out.println("This will not execute");
        }

        System.out.println("\n===== PROGRAM COMPLETED =====");
    }


    // Method for short-circuit demonstration
    public static boolean checkMethod() {
        System.out.println("checkMethod Executed");
        return true;
    }
}