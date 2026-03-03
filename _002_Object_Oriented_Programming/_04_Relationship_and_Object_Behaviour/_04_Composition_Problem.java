package _04_Relationship_and_Object_Behaviour;

import java.util.*;

/*
 Practice (Composition) – Medium

 Design a system to manage a composition relationship between
 a University and its Colleges.

 University Class:
 - Attribute:
     name (String)
     colleges (List of College objects)

 - Methods:
     addCollege(collegeName, collegeId)
     displayDetails()

 College Class:
 - Attributes:
     name (String)
     id (String)

 Example:
 Input:
 name = "Global_University"
 collegeNames = [ "COEP", "PICT", "VJTI", "WCE", "PCCOE" ]
 collegeIds   = [ "CO8543", "PI9514", "VJ8643", "VF569", "PC9246" ]

 Output:
 University Name : Global_University
 College Name : COEP
 College ID : CO8543
 ...
*/

/*
 ================================
 Explanation (Composition Concept)
 ================================

 This is Composition because:

 1. University creates College objects internally.
 2. Colleges cannot exist independently outside University.
 3. Lifecycle dependency exists.
 4. If University object is destroyed → its colleges are also destroyed.
 5. Strong ownership relationship (Strong HAS-A).

 University ◆── College
*/

public class _04_Composition_Problem {

    public static void main(String[] args) {

        // Creating University object
        University university = new University("Global_University");

        // Adding colleges (created inside University class)
        university.addCollege("COEP", "CO8543");
        university.addCollege("PICT", "PI9514");
        university.addCollege("VJTI", "VJ8643");
        university.addCollege("WCE", "VF569");
        university.addCollege("PCCOE", "PC9246");

        // Displaying details
        university.displayDetails();
    }
}

/* ================================
   University Class (Whole)
   ================================ */
class University {

    private String name;
    private List<College> colleges;

    // Constructor
    public University(String name) {
        this.name = name;
        this.colleges = new ArrayList<>();
    }

    // Composition: University creates College internally
    public void addCollege(String collegeName, String collegeId) {
        College college = new College(collegeName, collegeId);
        colleges.add(college);
    }

    public void displayDetails() {
        System.out.println("University Name : " + name);

        for (College c : colleges) {
            System.out.println("College Name : " + c.getName());
            System.out.println("College ID : " + c.getId());
        }
    }
}

/* ================================
   College Class (Part)
   ================================ */
class College {

    private String name;
    private String id;

    // Constructor
    College(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}