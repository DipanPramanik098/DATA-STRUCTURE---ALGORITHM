package _016_Binary_Search_Trees._01_Theory_And_Basics;

public class _01_Introduction_To_BST {

    /*
    =================================================================================================
                                    BINARY SEARCH TREE (BST)
    =================================================================================================

    A Binary Search Tree (BST) is a special type of Binary Tree that follows a specific ordering rule.

    BST Property:
    -------------------------
    1. Left Subtree contains smaller values than the current node.
    2. Right Subtree contains greater values than the current node.
    3. Both left and right subtrees are also BSTs.

    Formula:
    -------------------------
            Left Child < Node < Right Child

    Example:
    -------------------------

                    50
                   /  \
                 30    70
                / \    / \
              20  40  60  80

    Here:
    -------------------------
    Left subtree of 50 contains smaller values.
    Right subtree of 50 contains greater values.

    =================================================================================================
                                        NODE STRUCTURE
    =================================================================================================

    Each node in a BST contains:
    -------------------------
    1. Data (value)
    2. Left Child Reference
    3. Right Child Reference

    Structure:
    -------------------------

            class Node{
                int data;
                Node left;
                Node right;
            }

    =================================================================================================
                                    RECURSIVE NATURE OF BST
    =================================================================================================

    Every subtree inside a BST is itself a BST.

    Example:
    -------------------------

                        50
                       /  \
                     30    70
                    / \    / \
                  20  40  60  80

    Subtree rooted at 30:
    -------------------------

                        30
                       /  \
                     20   40

    This also follows BST rules.

    Subtree rooted at 70:
    -------------------------

                        70
                       /  \
                     60   80

    This also follows BST rules.

    Therefore:
    -------------------------
    Every subtree of a BST is also a BST.

    =================================================================================================
                                        HEIGHT OF BST
    =================================================================================================

    Height:
    -------------------------
    Number of edges in the longest path from the node to a leaf node.

    Example:
    -------------------------

                    50
                   /
                 30
                /
              20

    Height of 50 = 2

    Because:
    50 -> 30 -> 20

    contains 2 edges.

    =================================================================================================
                                        DEPTH OF NODE
    =================================================================================================

    Depth:
    -------------------------
    Number of edges from root node to current node.

    Example:
    -------------------------

                    50
                   /
                 30
                /
              20

    Depth of:
    -------------------------
    50 = 0
    30 = 1
    20 = 2

    =================================================================================================
                                    BALANCED BINARY SEARCH TREE
    =================================================================================================

    A BST is considered balanced when its height remains close to:

                            log2(N)

    where:
    -------------------------
    N = Number of Nodes

    Balanced BST Example:
    -------------------------

                            40
                          /    \
                        20      60
                       / \     / \
                     10  30   50  70

    Advantages:
    -------------------------
    1. Faster Searching
    2. Faster Insertion
    3. Faster Deletion

    Time Complexity:
    -------------------------
    O(log N)

    =================================================================================================
                                    UNBALANCED BST
    =================================================================================================

    If nodes are inserted in sorted order:

            10 -> 20 -> 30 -> 40 -> 50

    Tree becomes:

                    10
                      \
                       20
                         \
                          30
                            \
                             40
                               \
                                50

    This is called a Skewed Tree.

    Height becomes:
    -------------------------
    O(N)

    Searching becomes slower.

    =================================================================================================
                                    SEARCHING IN BST
    =================================================================================================

    Searching is efficient because of BST ordering property.

    Example:
    -------------------------

                            50
                           /  \
                         30    70
                               /
                             60

    Search for 60:
    -------------------------

    Step 1:
    Compare 60 with 50

            60 > 50

    Move to right subtree.

    Step 2:
    Compare 60 with 70

            60 < 70

    Move to left subtree.

    Step 3:
    Found 60.

    =================================================================================================
                                    TIME COMPLEXITIES
    =================================================================================================

    Operation           Balanced BST           Worst Case BST
    ----------------------------------------------------------------
    Search              O(log N)              O(N)
    Insert              O(log N)              O(N)
    Delete              O(log N)              O(N)

    =================================================================================================
                                    DUPLICATE VALUES IN BST
    =================================================================================================

    In standard BST implementation:
    -------------------------
    Duplicate values are NOT allowed.

    Because:
    -------------------------
    BST ordering becomes ambiguous.

    =================================================================================================
                            METHODS TO HANDLE DUPLICATE VALUES
    =================================================================================================

    Method 1:
    -------------------------
    Store duplicates in left subtree.

            Duplicate <= Node

    Method 2:
    -------------------------
    Store duplicates in right subtree.

            Duplicate >= Node

    Method 3:
    -------------------------
    Maintain count field.

    Example:
    -------------------------

            class Node{
                int data;
                int count;
            }

    Best approach for handling duplicates efficiently.

    =================================================================================================
                                BINARY TREE vs BST
    =================================================================================================

    Binary Tree:
    -------------------------
    No ordering property.

    BST:
    -------------------------
    Ordered structure.

    Binary Tree Search:
    -------------------------
    O(N)

    BST Search:
    -------------------------
    O(log N) average

    =================================================================================================
                                    AVL TREE
    =================================================================================================

    AVL Tree is a self-balancing Binary Search Tree.

    Rule:
    -------------------------
    Difference between heights of left and right subtrees should be at most 1.

    Balance Factor Formula:
    -------------------------

            BF = Height(Left) - Height(Right)

    Allowed Values:
    -------------------------
    -1, 0, +1

    Example:
    -------------------------

                        30
                       /  \
                     20    40

    This is balanced.

    =================================================================================================
                                    AVL ROTATIONS
    =================================================================================================

    To maintain balance, AVL Tree uses rotations.

    Types:
    -------------------------
    1. LL Rotation
    2. RR Rotation
    3. LR Rotation
    4. RL Rotation

    Rotations rebalance the tree after insertion/deletion.

    =================================================================================================
                                    RED-BLACK TREE
    =================================================================================================

    Red-Black Tree is also a self-balancing BST.

    Each node contains an extra color bit:
    -------------------------
    1. Red
    2. Black

    =================================================================================================
                                RED-BLACK TREE RULES
    =================================================================================================

    Rule 1:
    -------------------------
    Every node is either Red or Black.

    Rule 2:
    -------------------------
    Root node must be Black.

    Rule 3:
    -------------------------
    Red node cannot have Red child.

    Rule 4:
    -------------------------
    Every root-to-leaf path must contain same number of Black nodes.

    These rules keep tree approximately balanced.

    =================================================================================================
                                AVL TREE vs RED-BLACK TREE
    =================================================================================================

    AVL Tree:
    -------------------------
    1. Strict balancing
    2. Faster searching
    3. More rotations

    Red-Black Tree:
    -------------------------
    1. Less strict balancing
    2. Faster insertion/deletion
    3. Fewer rotations

    =================================================================================================
                                    PRACTICAL APPLICATIONS
    =================================================================================================

    1. Database Indexing
    -------------------------
    Used to quickly locate records.

    Example:
    Searching student records using roll number.

    -------------------------------------------------------------------------------------------------

    2. Symbol Tables
    -------------------------
    Used in:
    - Compilers
    - Interpreters

    Stores:
    - Variable names
    - Function names
    - Identifiers

    -------------------------------------------------------------------------------------------------

    3. Memory Management
    -------------------------
    Used in:
    - Heap structures
    - Dynamic memory allocation
    - Efficient memory management

    =================================================================================================
                                        ADVANTAGES OF BST
    =================================================================================================

    1. Fast Searching
    2. Efficient Insertion
    3. Efficient Deletion
    4. Ordered Data Storage
    5. Supports Range Queries

    =================================================================================================
                                    DISADVANTAGES OF BST
    =================================================================================================

    1. Can become unbalanced
    2. Worst-case complexity becomes O(N)
    3. More complex than arrays
    4. Requires extra memory for pointers

    =================================================================================================
                                        FINAL SUMMARY
    =================================================================================================

    BST is one of the most important hierarchical data structures.

    Key Points:
    -------------------------
    1. Left subtree contains smaller values.
    2. Right subtree contains greater values.
    3. Every subtree is also a BST.
    4. Balanced BST gives O(log N) complexity.
    5. AVL and Red-Black Trees solve balancing problems.

    Real-world Usage:
    -------------------------
    - Databases
    - Compilers
    - STL Libraries
    - Memory Management Systems

    =================================================================================================
    */

}