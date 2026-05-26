package _015_Binary_Trees._04_Construction_Problems;

/*
===========================================================
PROBLEM STATEMENT
===========================================================

Given two tree traversals,
determine whether a UNIQUE Binary Tree
can be constructed.

Traversal Encoding:

1 = Preorder
2 = Inorder
3 = Postorder

Return:
true  -> Unique tree possible
false -> Multiple trees possible

-----------------------------------------------------------
Example 1:

Input:
1 2

Meaning:
Preorder + Inorder

Output:
true

Why?

Preorder gives root first.
Inorder separates left and right subtree.

So unique construction possible.

-----------------------------------------------------------
Example 2:

Input:
2 2

Meaning:
Inorder + Inorder

Output:
false

Why?

Same traversal repeated.
No extra information.
Cannot uniquely construct.

===========================================================
INTUITION
===========================================================

Unique binary tree construction needs enough information
to identify:

1. Root node
2. Left subtree
3. Right subtree

-----------------------------------------------------------
CASE 1:
PREORDER + INORDER
-----------------------------------------------------------

Preorder:
Root -> Left -> Right

Example:
[1,2,4,5,3]

Root known immediately:
1

Inorder:
Left -> Root -> Right

Example:
[4,2,5,1,3]

Root = 1 divides tree into:

Left:
[4,2,5]

Right:
[3]

Unique construction possible.

-----------------------------------------------------------
CASE 2:
POSTORDER + INORDER
-----------------------------------------------------------

Postorder:
Left -> Right -> Root

Example:
[4,5,2,3,1]

Root known from end:
1

Inorder divides left/right.

Unique construction possible.

-----------------------------------------------------------
CASE 3:
PREORDER + POSTORDER
-----------------------------------------------------------

Preorder:
Root -> Left -> Right

Postorder:
Left -> Right -> Root

Problem:
No clear separation between left and right subtree.

Example:

Tree A:
    1
   /
  2

Preorder:
[1,2]

Postorder:
[2,1]

Tree B:
    1
     \
      2

Preorder:
[1,2]

Postorder:
[2,1]

Same traversals
Different trees

NOT UNIQUE

-----------------------------------------------------------
CASE 4:
SAME TRAVERSALS
-----------------------------------------------------------

Examples:
Pre + Pre
In + In
Post + Post

Same info repeated.

NOT UNIQUE

===========================================================
RULE
===========================================================

Unique possible ONLY IF:

1. One traversal is INORDER
AND
2. Other traversal is DIFFERENT

So:

Pre + In   -> TRUE
In + Pre   -> TRUE
Post + In  -> TRUE
In + Post  -> TRUE

Everything else:
FALSE

===========================================================
APPROACH
===========================================================

Check:

If both traversals same:
return false

If Pre + Post OR Post + Pre:
return false

Else:
return true

===========================================================
DRY RUN
===========================================================

Input:
1 3

Meaning:
Preorder + Postorder

Check:

Same?
1 == 3 → NO

Pre + Post?
YES

Return:
false

===========================================================
MCQ ANSWER
===========================================================

Input:
1 3

Correct Answer:
false

===========================================================
*/

public class _01_RequireMents_Needed_To_Construc_A_Unique_BT {

    /*
     * Function to check unique construction
     */
    public static boolean uniqueBinaryTree(int a, int b) {

        /*
         * Same traversal
         */
        if (a == b) {
            return false;
        }

        /*
         * Pre + Post
         */
        if ((a == 1 && b == 3) ||
            (a == 3 && b == 1)) {

            return false;
        }

        /*
         * Unique possible
         */
        return true;
    }

    /*
     * Main method
     */
    public static void main(String[] args) {

        System.out.println(uniqueBinaryTree(1, 2)); // true
        System.out.println(uniqueBinaryTree(2, 3)); // true
        System.out.println(uniqueBinaryTree(1, 3)); // false
        System.out.println(uniqueBinaryTree(2, 2)); // false
    }
}

/*
===========================================================
TIME COMPLEXITY
===========================================================

Only constant comparisons performed.

O(1)

===========================================================
SPACE COMPLEXITY
===========================================================

No extra space used.

O(1)

===========================================================
*/