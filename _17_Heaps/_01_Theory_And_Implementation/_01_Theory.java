package _17_Heaps._01_Theory_And_Implementation;

public class _01_Theory {

    /*
    =================================================================================================
                                            HEAP THEORY
    =================================================================================================

    PREREQUISITE
    ================================================================================================

    A strong understanding of TREES is very important before learning HEAPS.

    Because:
    Heap is a TREE BASED DATA STRUCTURE.

    Specifically:
    Heap internally follows the structure of an ALMOST COMPLETE BINARY TREE.

    ------------------------------------------------------------------------------------------------
    BASIC TREE RECAP
    ------------------------------------------------------------------------------------------------

    Binary Tree:
    A tree in which every node can have AT MOST TWO children.

                        10
                       /  \
                      20   30

    Here:
    10 -> Parent Node
    20 -> Left Child
    30 -> Right Child

    ------------------------------------------------------------------------------------------------
    IMPORTANT TERMINOLOGIES
    ------------------------------------------------------------------------------------------------

    Root Node:
        The topmost node of the tree.

    Parent Node:
        A node having children.

    Child Node:
        Nodes connected below a parent.

    Leaf Node:
        Node having NO children.

    Height:
        Maximum depth of tree.

    Level:
        Distance from root.


    =================================================================================================
                                ALMOST COMPLETE BINARY TREE
    =================================================================================================

    DEFINITION
    ================================================================================================

    A Binary Tree is called an ALMOST COMPLETE BINARY TREE when:

    1. All levels except the LAST level are COMPLETELY FILLED.

    2. The LAST level is FILLED FROM LEFT TO RIGHT.

    This property is EXTREMELY IMPORTANT because HEAP internally uses this structure.

    ------------------------------------------------------------------------------------------------
    CONDITION 1:
    ALL LEVELS EXCEPT LAST ARE COMPLETELY FILLED
    ------------------------------------------------------------------------------------------------

    Example:

                            1
                          /   \
                         2     3
                        / \   /
                       4   5 6

    Here:
    Level 0 -> Completely filled
    Level 1 -> Completely filled
    Last level -> Filled left to right

    So this is an Almost Complete Binary Tree.


    ------------------------------------------------------------------------------------------------
    CONDITION 2:
    LAST LEVEL FILLED FROM LEFT TO RIGHT
    ------------------------------------------------------------------------------------------------

    VALID TREE:

                            1
                          /   \
                         2     3
                        / \
                       4   5

    Here:
    Last level nodes are filled LEFT TO RIGHT.

    So VALID.


    INVALID TREE:

                            1
                          /   \
                         2     3
                          \   /
                           5 6

    Here:
    Left side has gaps.

    So NOT an Almost Complete Binary Tree.


    ------------------------------------------------------------------------------------------------
    WHY THIS PROPERTY IS IMPORTANT?
    ------------------------------------------------------------------------------------------------

    Because:
    Heap is stored INSIDE AN ARRAY.

    Array representation only works efficiently when tree is almost complete.

    Advantages:
    1. No wasted space
    2. Fast indexing
    3. Easy parent-child calculation
    4. Efficient insertion and deletion


    =================================================================================================
                                                HEAP
    =================================================================================================

    DEFINITION
    ================================================================================================

    Heap is a SPECIAL TREE-BASED DATA STRUCTURE
    that follows the HEAP PROPERTY.

    Heap is mainly used for:
    1. Priority Queue
    2. Heap Sort
    3. Finding Largest Element
    4. Finding Smallest Element
    5. Scheduling Problems
    6. Graph Algorithms

    Heap is ALWAYS:
    1. Almost Complete Binary Tree
    2. Follows Heap Property


    =================================================================================================
                                            HEAP PROPERTY
    =================================================================================================

    The HEAP PROPERTY defines the relationship between:

        Parent Node
                and
        Child Nodes

    There are TWO TYPES of Heap:

    1. MIN HEAP
    2. MAX HEAP


    =================================================================================================
                                            MIN HEAP
    =================================================================================================

    RULE
    ================================================================================================

    Parent node must be SMALLER THAN OR EQUAL TO its children.

    Formula:

            Parent <= Left Child
            Parent <= Right Child

    ------------------------------------------------------------------------------------------------
    EXAMPLE
    ------------------------------------------------------------------------------------------------

                            10
                          /    \
                        20      30
                       /  \    /
                     40   50  60

    Check:
    10 < 20 and 30
    20 < 40 and 50
    30 < 60

    So this is a MIN HEAP.

    IMPORTANT:
    Smallest element is ALWAYS at ROOT.

    Here:
    Smallest = 10


    =================================================================================================
                                            MAX HEAP
    =================================================================================================

    RULE
    ================================================================================================

    Parent node must be GREATER THAN OR EQUAL TO its children.

    Formula:

            Parent >= Left Child
            Parent >= Right Child

    ------------------------------------------------------------------------------------------------
    EXAMPLE
    ------------------------------------------------------------------------------------------------

                            90
                          /    \
                        70      60
                       /  \    /
                     40   50  30

    Check:
    90 > 70 and 60
    70 > 40 and 50
    60 > 30

    So this is a MAX HEAP.

    IMPORTANT:
    Largest element is ALWAYS at ROOT.

    Here:
    Largest = 90


    =================================================================================================
                                IMPORTANT POINTS ABOUT HEAP PROPERTY
    =================================================================================================

    1. LOCAL RELATIONSHIP
    ================================================================================================

    Heap property only checks relationship between:

            Parent and Immediate Children

    It DOES NOT check:
    1. Sibling order
    2. Entire tree ordering

    ------------------------------------------------------------------------------------------------
    EXAMPLE
    ------------------------------------------------------------------------------------------------

                            10
                          /    \
                        50      20

    This is STILL a valid MIN HEAP because:

    10 < 50
    10 < 20

    Even though:
    50 > 20


    ------------------------------------------------------------------------------------------------
    2. PRESERVATION DURING OPERATIONS
    ------------------------------------------------------------------------------------------------

    During:
    1. Insertion
    2. Deletion

    Heap property may get violated temporarily.

    Then HEAPIFY operation restores heap property.


    =================================================================================================
                                INTERNAL REPRESENTATION OF HEAP
    =================================================================================================

    IMPORTANT CONCEPT
    ================================================================================================

    Internally:
    Heap is NOT stored as tree nodes.

    Instead:
    Heap is stored using ARRAY REPRESENTATION.

    WHY?
    1. Saves memory
    2. Faster access
    3. No pointers required
    4. Efficient calculations


    =================================================================================================
                            ARRAY REPRESENTATION OF BINARY TREE
    =================================================================================================

    Consider this tree:

                                10
                              /    \
                            20      30
                           /  \    /  \
                         40   50  60   70

    ------------------------------------------------------------------------------------------------
    ARRAY REPRESENTATION
    ------------------------------------------------------------------------------------------------

    Array:

            index : 0   1   2   3   4   5   6
            value :10  20  30  40  50  60  70

    ------------------------------------------------------------------------------------------------
    INDEXING RULES
    ------------------------------------------------------------------------------------------------

    For a node at index i:

    LEFT CHILD:
            2*i + 1

    RIGHT CHILD:
            2*i + 2

    PARENT:
            (i - 1) / 2

    NOTE:
    Integer division is used.


    =================================================================================================
                                    INDEXING EXPLANATION
    =================================================================================================

    ARRAY:

            index : 0   1   2   3   4   5   6
            value :10  20  30  40  50  60  70

    ------------------------------------------------------------------------------------------------
    NODE 10
    ------------------------------------------------------------------------------------------------

    Index = 0

    Left Child:
        2*0 + 1 = 1
        arr[1] = 20

    Right Child:
        2*0 + 2 = 2
        arr[2] = 30


    ------------------------------------------------------------------------------------------------
    NODE 20
    ------------------------------------------------------------------------------------------------

    Index = 1

    Left Child:
        2*1 + 1 = 3
        arr[3] = 40

    Right Child:
        2*1 + 2 = 4
        arr[4] = 50

    Parent:
        (1 - 1) / 2 = 0
        arr[0] = 10


    ------------------------------------------------------------------------------------------------
    NODE 30
    ------------------------------------------------------------------------------------------------

    Index = 2

    Left Child:
        2*2 + 1 = 5
        arr[5] = 60

    Right Child:
        2*2 + 2 = 6
        arr[6] = 70

    Parent:
        (2 - 1) / 2 = 0
        arr[0] = 10


    =================================================================================================
                            LEAF NODES AND NON-LEAF NODES
    =================================================================================================

    Suppose:
    Total number of elements = N

    Example:
            N = 7

    Array:

            index : 0   1   2   3   4   5   6


    =================================================================================================
                                            LEAF NODES
    =================================================================================================

    DEFINITION
    ================================================================================================

    Nodes having NO children.

    ------------------------------------------------------------------------------------------------
    RANGE OF LEAF NODE INDICES
    ------------------------------------------------------------------------------------------------

            floor(N/2) to N-1

    Formula:

            Leaf Nodes Start =
                    floor(N/2)

    ------------------------------------------------------------------------------------------------
    EXAMPLE
    ------------------------------------------------------------------------------------------------

    N = 7

    floor(7/2) = 3

    So:
    Leaf node indices:

            3, 4, 5, 6

    Which are:
            40, 50, 60, 70

    These nodes have NO children.


    =================================================================================================
                                        NON-LEAF NODES
    =================================================================================================

    DEFINITION
    ================================================================================================

    Nodes having at least ONE child.

    ------------------------------------------------------------------------------------------------
    RANGE OF NON-LEAF NODE INDICES
    ------------------------------------------------------------------------------------------------

            0 to floor(N/2)-1

    ------------------------------------------------------------------------------------------------
    EXAMPLE
    ------------------------------------------------------------------------------------------------

    N = 7

    floor(7/2)-1
    = 3-1
    = 2

    So:
    Non-leaf indices:

            0, 1, 2

    Values:
            10, 20, 30

    These nodes have children.


    =================================================================================================
                                        COMPLETE SUMMARY
    =================================================================================================

    1. Heap is a Tree-Based Data Structure.

    2. Heap follows:
            a) Almost Complete Binary Tree
            b) Heap Property

    3. Types of Heap:
            a) Min Heap
            b) Max Heap

    4. Min Heap:
            Parent <= Children

    5. Max Heap:
            Parent >= Children

    6. Heap is internally stored using ARRAY.

    7. Important formulas:

            Left Child  = 2*i + 1
            Right Child = 2*i + 2
            Parent      = (i - 1)/2

    8. Leaf Node Range:
            floor(N/2) to N-1

    9. Non-Leaf Node Range:
            0 to floor(N/2)-1


    =================================================================================================
                                                END
    =================================================================================================
    */
}