package _02_Core_Principles_Of_OOPS;

import java.util.*;

/*
====================================================================
Practice Problem: Encapsulation (Medium)

You are tasked to design a class Book to manage book details in a
library system.

Specifications:

Attributes:
1. title (List<String>)        → Public
2. author (List<String>)       → Public
3. isAvailable (List<Boolean>) → Private

Methods:
1. Parameterized constructor
   → Initializes title, author and isAvailable lists.

2. borrowBook(String bookName)
   → If book is available (true), mark it false.
   → If not available, print:
     "Book is not available."

3. returnBook(String bookName)
   → Mark book as available (true).

4. getAvailability(String bookName)
   → Print availability status (true / false)

Input Operations:
"1 bookName" → borrowBook
"2 bookName" → returnBook
"3 bookName" → getAvailability

Goal:
Demonstrate encapsulation by:
- Keeping availability private
- Allowing controlled modification via methods
====================================================================
*/

// ==============================
// Book Class (Encapsulation)
// ==============================

class Book {

    // Public attributes
    public List<String> title;
    public List<String> author;

    // Private attribute (Data Hiding)
    private List<Boolean> isAvailable;

    // Parameterized Constructor
    public Book(List<String> title, List<String> author, List<Boolean> isAvailable) {
        this.title = title;
        this.author = author;
        this.isAvailable = isAvailable;
    }

    // Borrow Book
    public void borrowBook(String bookName) {

        int index = title.indexOf(bookName);

        if (index == -1) {
            System.out.println("Book not found.");
            return;
        }

        if (isAvailable.get(index)) {
            isAvailable.set(index, false);
        } else {
            System.out.println("Book is not available.");
        }
    }

    // Return Book
    public void returnBook(String bookName) {

        int index = title.indexOf(bookName);

        if (index == -1) {
            System.out.println("Book not found.");
            return;
        }

        isAvailable.set(index, true);
    }

    // Get Availability
    public void getAvailability(String bookName) {

        int index = title.indexOf(bookName);

        if (index == -1) {
            System.out.println("Book not found.");
            return;
        }

        System.out.println(isAvailable.get(index));
    }
}


// ==============================
// Main Class
// ==============================

public class _02_Encapsulation_Problem {

    public static void main(String[] args) {

        List<String> title = Arrays.asList(
                "Sherlock_Holmes",
                "Frankenstein",
                "King_Arthur_and_the_Round_Table",
                "Treasure_Island"
        );

        List<String> author = Arrays.asList(
                "Arthur_Conan_Doyle",
                "Mary_Shelley",
                "Roger_Lancelyn_Green",
                "Robert_Louis_Stevenson"
        );

        List<Boolean> isAvailable = new ArrayList<>(
                Arrays.asList(false, true, false, false)
        );

        Book library = new Book(title, author, isAvailable);

        // Simulated method calls
        String[][] methodCalls = {
                {"1", "Frankenstein"},
                {"1", "Sherlock_Holmes"},
                {"2", "King_Arthur_and_the_Round_Table"},
                {"3", "Sherlock_Holmes"},
                {"1", "Frankenstein"}
        };

        for (String[] call : methodCalls) {

            String operation = call[0];
            String bookName = call[1];

            switch (operation) {
                case "1":
                    library.borrowBook(bookName);
                    break;
                case "2":
                    library.returnBook(bookName);
                    break;
                case "3":
                    library.getAvailability(bookName);
                    break;
            }
        }
    }
}