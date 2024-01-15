public class DequeLinkedList {
    private Node front;
    private Node rear;
    private int size;

    // Deque constructor to initialize an empty deque
    public DequeLinkedList() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    // Check if the deque is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Get the current size of the deque
    public int size() {
        return size;
    }

    // Insert an element at the front of the deque
    public void insertFront(int item) {
        // Create a new node with the given item
        Node newNode = new Node(item);

        // Adjust pointers based on whether the deque is empty
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            newNode.next = front;
            front.prev = newNode;
            front = newNode;
        }

        size++; // Update the size
    }

    // Insert an element at the rear of the deque
    public void insertRear(int item) {
        Node newNode = new Node(item); // Create a new node with the given item

        // Adjust pointers based on whether the deque is empty
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            newNode.prev = rear;
            rear = newNode;
        }

        size++;
    }

    // Delete an element from the front of the deque
    public int deleteFront() {
        // Check if the deque is empty
        if (isEmpty()) {
            System.out.println("Deque is empty. Cannot delete from the front.");
            return -1; //-1 is a sentinel value in the deque
        }

        // Retrieve the deleted item and adjust pointers if needed
        int deletedItem = front.data;
        if (front == rear) {
            front = null;
            rear = null;
        } else {
            front = front.next;
            front.prev = null;
        }

        // Update the size and return the deleted item
        size--;
        return deletedItem;
    }

    // Delete an element from the rear of the deque
    public int deleteRear() {
        if (isEmpty()) {
            System.out.println("Deque is empty. Cannot delete from the rear.");
            return -1;
        }

        int deletedItem = rear.data;
        if (front == rear) {
            front = null;
            rear = null;
        } else {
            rear = rear.prev;
            rear.next = null;
        }

        size--;
        return deletedItem;
    }

    // Get the front element of the deque
    public int getFront() {
        if (isEmpty()) {
            System.out.println("Deque is empty. No front element.");
            return -1;
        }

        return front.data; // Return the front element
    }

    // Get the rear element of the deque
    public int getRear() {
        if (isEmpty()) {
            System.out.println("Deque is empty. No rear element.");
            return -1;
        }

        return rear.data;  // Return the rear element
    }

    // Display the elements of the deque
    public void display() {
        // Check if the deque is empty
        if (isEmpty()) {
            System.out.println("Deque is empty.");
            return;
        }

        // Iterate through the deque and print its elements
        Node current = front;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DequeLinkedList deque = new DequeLinkedList();

        //TEST 1
        DequeArray deque1 = new DequeArray(5);
        System.out.println("TEST 1");
        deque1.insertFront(1);
        deque1.insertRear(2);
        deque1.insertFront(3);
        deque1.insertRear(4);

        System.out.println("Front: " + deque1.getFront());
        System.out.println("Rear: " + deque1.getRear());

        System.out.println("Deque after insertions:");
        deque1.display();

        deque1.deleteFront();
        deque1.deleteRear();

        System.out.println("Deque after deletions:");
        deque1.display();

        //TEST 2
        DequeArray deque2 = new DequeArray(10);
        System.out.println("\nTEST 2");
        deque2.insertFront(10);
        deque2.insertRear(1);
        deque2.insertFront(7);
        deque2.insertRear(5);
        deque2.insertFront(9);
        deque2.insertRear(2);
        deque2.insertFront(21);
        deque2.insertRear(3);

        System.out.println("Front: " + deque2.getFront());
        System.out.println("Rear: " + deque2.getRear());

        System.out.println("Deque after insertions:");
        deque2.display();

        deque2.deleteFront();
        deque2.deleteRear();

        System.out.println("Deque after deletions:");
        deque2.display();

        //TEST 3
        DequeArray deque3 = new DequeArray(3);
        System.out.println("\nTEST 3");
        deque3.insertFront(0);
        deque3.insertRear(0);
        deque3.insertFront(0);
        deque3.insertRear(0);

        System.out.println("Front: " + deque3.getFront());
        System.out.println("Rear: " + deque3.getRear());

        System.out.println("Deque after insertions:");
        deque3.display();

        deque3.deleteFront();
        deque3.deleteRear();

        System.out.println("Deque after deletions:");
        deque3.display();
    }
}
/*
OUTPUT:
TEST 1
Front: 3
Rear: 4
Deque after insertions:
3 1 2 4
Deque after deletions:
1 2

TEST 2
Front: 21
Rear: 3
Deque after insertions:
21 9 7 10 1 5 2 3
Deque after deletions:
9 7 10 1 5 2

TEST 3
Deque is full. Cannot insert at the rear.
Front: 0
Rear: 0
Deque after insertions:
0 0 0
Deque after deletions:
0
 */
