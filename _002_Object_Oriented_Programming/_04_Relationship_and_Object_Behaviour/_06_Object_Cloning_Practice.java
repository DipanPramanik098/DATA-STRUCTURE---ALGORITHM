package _04_Relationship_and_Object_Behaviour;

import java.util.*;

/*
================================================================
Practice (Object Cloning) – Medium

Design a class hierarchy to demonstrate object cloning
using shallow and deep copying in a library system.

Classes:

Book :
    Attributes :
        title (String)
        author (String)

Library :
    Attributes :
        name (String)
        books (List<Book>)

Methods :
    shallowClone()  → Creates shallow copy of Library.
    deepClone()     → Creates deep copy of Library.
    display()       → Displays library details.
    addBook(Book b) → Adds book to library.

Goal:
After modifying original library book details,
    - Shallow clone reflects change.
    - Deep clone remains unchanged.

================================================================
Explanation:

Shallow Copy:
    - Copies list reference.
    - Books are shared.
    - Changes reflect in both objects.

Deep Copy:
    - Creates new list.
    - Clones each Book object.
    - Fully independent copy.

================================================================
*/

public class _06_Object_Cloning_Practice {

    public static void main(String[] args) {

        // Input simulation
        String name = "Central_Library";

        String[] titles = {
                "Frankestein",
                "King_Arthur_and_the_Round_Table"
        };

        String[] authors = {
                "Mary_Shelley",
                "Rosemary_Sutcliff"
        };

        int changeIndex = 1;
        String newTitle = "Treasure_Island";
        String newAuthor = "Robert_Louis_Stevenson";

        // Create original library
        Library library = new Library(name);

        for (int i = 0; i < titles.length; i++) {
            library.addBook(new Book(titles[i], authors[i]));
        }

        System.out.println("Original Library :\n");
        library.display();

        // Create shallow clone
        Library shallowClone = library.shallowClone();

        // Create deep clone
        Library deepClone = library.deepClone();

        // Modify original library
        library.books.get(changeIndex).setTitle(newTitle);
        library.books.get(changeIndex).setAuthor(newAuthor);

        System.out.println("\nAfter Modifications :\n");

        System.out.println("Original Library :\n");
        library.display();

        System.out.println("Shallow Clone :\n");
        shallowClone.display();

        System.out.println("Deep Clone :\n");
        deepClone.display();
    }
}

/* ============================================================
                        Book Class
   ============================================================ */

class Book implements Cloneable {

    private String title;
    private String author;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDetails() {
        return "Book : " + title + ", Author : " + author;
    }

    @Override
    protected Book clone() {
        return new Book(this.title, this.author);
    }
}

/* ============================================================
                        Library Class
   ============================================================ */

class Library {

    String name;
    List<Book> books;

    Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    // Shallow Copy
    public Library shallowClone() {
        Library cloned = new Library(this.name);
        cloned.books = this.books;  // Same reference
        return cloned;
    }

    // Deep Copy
    public Library deepClone() {
        Library cloned = new Library(this.name);
        cloned.books = new ArrayList<>();

        for (Book b : this.books) {
            cloned.books.add(b.clone());  // Clone each book
        }

        return cloned;
    }

    public void display() {
        System.out.println("Library : " + name);
        for (Book b : books) {
            System.out.println(b.getDetails());
        }
        System.out.println();
    }
}