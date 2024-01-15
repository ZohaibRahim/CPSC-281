/**
 Q1) Write a Java program which merges two ordered singly linked lists of integers into a single
 ordered doubly linked list. The resulting list should not contain any duplicate elements. In
 addition to routine testing, demonstrate special cases, for example, one or both lists might be
 empty, there may be elements which occur in both lists, and traversal in both directions.
 Discuss the complexity of your solution.
 Note: No Java built-in classes (LinkedList, etc) are allowed.
 */

package Q1;

public class MergeLists {
    public static DoublyLinkedList mergeOrderedLists(Node head1, Node head2) {
        DoublyLinkedList mergedList = new DoublyLinkedList();
        Node current1 = head1;
        Node current2 = head2;

        // Traverse both lists and merge them into the new doubly linked list
        while (current1 != null && current2 != null) {
            if (current1.data < current2.data) {
                // If the element from the first list is smaller, add it to the merged list
                mergedList.insert(current1.data);
                current1 = current1.next;
            } else if (current1.data > current2.data) {
                // If the element from the second list is smaller, add it to the merged list
                mergedList.insert(current2.data);
                current2 = current2.next;
            } else {
                // If elements are equal, skip duplicates and move both pointers
                mergedList.insert(current1.data);
                current1 = current1.next;
                current2 = current2.next;
            }
        }

        // Add remaining elements from both lists
        while (current1 != null) {
            mergedList.insert(current1.data);
            current1 = current1.next;
        }

        while (current2 != null) {
            mergedList.insert(current2.data);
            current2 = current2.next;
        }

        return mergedList;
    }

    // Main method for testing the program
    public static void main(String[] args) {
        // Testing the program with two ordered singly linked lists
        //TEST 1
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);

        Node head2 = new Node(4);
        head2.next = new Node(5);
        head2.next.next = new Node(6);
        head2.next.next.next = new Node(7);
        head2.next.next.next.next = new Node(8);

        // Merge the lists and display the result
        DoublyLinkedList test1 = mergeOrderedLists(head1, head2);
        System.out.println("TEST 1:");
        test1.display();
        System.out.println("TEST 1 Reverse:");
        test1.displayReverse();  // Display in reverse direction

        // TEST 2
        Node head3 = null;
        Node head4 = new Node(6);

        DoublyLinkedList test2 = mergeOrderedLists(head3, head4);
        System.out.println("\nTEST 2:");
        test2.display();

        // TEST 3
        Node head5 = null;
        Node head6 = null;

        DoublyLinkedList test3 = mergeOrderedLists(head5, head6);
        System.out.println("\nTEST 3:");
        test3.display();

    }
}

/*
OUTPUT:
TEST 1:
1 2 3 4 5 6 7 8
TEST 1 Reverse:
8 7 6 5 4 3 2 1

TEST 2:
6

TEST 3:

*/

/**
Discuss the complexity of your solution.

TIME COMPLEXITY:
 Merging Algorithm (mergeOrderedLists method):
   The algorithm iterates through both input linked lists once.
   For each comparison, a constant time operation is performed to insert elements into the merged doubly linked list.
   The time complexity is O(m + n), where m and n are the lengths of the two input linked lists.

 Displaying Algorithm (display and displayReverse methods):
   Both methods traverse the entire doubly linked list once.
   The time complexity for both methods is O(m + n), where m and n are the lengths of the doubly linked list.


SPACE COMPLEXITY:
 Merged Doubly Linked List:
   The space complexity of the merged doubly linked list is O(m + n), where m and n are the lengths of the two input
   linked lists. This is because the merged list can contain all elements from both lists without duplication.

 Other Data Structures:
   The space complexity for other data structures (variables, pointers, etc.) used in the program is O(1), as the
   amount of additional space used remains constant regardless of the size of the input linked lists.


The overall time complexity of the program is dominated by the merging algorithm, which is O(m + n), and the
overall space complexity is also O(m + n) due to the space required for the merged doubly linked list.

 */