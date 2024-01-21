# Josephus Problem Solver Using Circular Linked List in Java

The Java program, `JosephusProblem`, elegantly solves the classic Josephus problem using a circularly linked list. The Josephus problem involves a group of people standing in a circle, where every k-th person is executed until only one person remains—the survivor. This solution demonstrates the use of a circular linked list to efficiently determine the position of the survivor for any fixed k.

**Key Features:**

1. **Circular Linked List Implementation:**
   - The program defines a `CircularLinkedList` class that efficiently handles the circular linked list structure.
   - Nodes are inserted into the circular linked list, making it circular by connecting the last node to the head.

2. **Elimination Process:**
   - The elimination process is carried out based on the provided skip value (k).
   - People are skipped until only one person remains, and the circular structure is adjusted accordingly.

3. **Survivor Position:**
   - The survivor's position is obtained using the `getSurvivor` method, and the final result is printed.

4. **Test Cases:**
   - The program includes multiple test cases with varying total numbers of people and skip values.
   - It provides a clear demonstration of how the survivor's position changes based on different initial conditions.

**GitHub Repository:**
[Josephus Problem Solver](https://github.com/ZohaibRahim/CPSC-281/tree/Josephus-Problem---Circular-Linked-List)
