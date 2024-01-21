# Deque Implementations in Java: Doubly Linked List and Fixed-Capacity Array

This Java program provides comprehensive implementations of a double-ended queue (deque) using two different underlying data structures: a doubly linked list and a fixed-capacity array. The program consists of two classes,  "DequeArray" and "DequeLinkedList", each offering a distinct approach to managing elements in a deque.

**Deque Implementation with Fixed-Capacity Array:**
In contrast, the class "DequeArray" utilizes a fixed-capacity array to store elements in the deque. This approach guarantees that each update method runs in O(1) time, providing efficiency for scenarios where a fixed-size deque is preferred. The program includes methods for insertion, deletion, and retrieval, along with error handling, full capacity checks, and display functionality.

**Deque Implementation with Doubly Linked List:**
The class "DequeLinkedList" employs a doubly linked list to facilitate efficient insertion and deletion at both the front and rear ends of the deque. This implementation ensures flexibility and dynamic sizing. The program includes fundamental deque operations, such as insertion, deletion, and retrieval, along with error handling and display functionalities.

**Key Features:**
1. Dynamic Sizing with Doubly Linked List.
2. Constant Time Updates with Fixed-Capacity Array.
3. Error Handling for Edge Cases.
4. Display Functionality for Visualization.
5. Sentinel Values for Error Indication.

**Sample Tests:**
The program's main method conducts three test scenarios for each implementation, showcasing the versatility and reliability of both the doubly linked list and fixed-capacity array-based deques.

This combined program serves as a comprehensive exploration of deque implementations in Java, demonstrating the advantages and use cases of employing either a doubly linked list or a fixed-capacity array as the underlying data structure for a double-ended queue.
