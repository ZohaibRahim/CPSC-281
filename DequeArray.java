public class DequeArray {
    private int[] array;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    // Constructor to initialize the array-based deque with a given capacity
    public DequeArray(int capacity) {
        this.array = new int[capacity];
        this.front = -1;
        this.rear = -1;
        this.size = 0;
        this.capacity = capacity;
    }

    // Check if the deque is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Check if the deque is full
    public boolean isFull() {
        return size == capacity;
    }

    // Get the current size of the deque
    public int size() {
        return size;
    }

    // Insert an element at the front of the deque
    public void insertFront(int item) {
        // Check if the deque is full
        if (isFull()) {
            System.out.println("Deque is full. Cannot insert at the front.");
            return;
        }

        // Adjust front and rear pointers based on whether the deque is empty
        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else {
            front = (front - 1 + capacity) % capacity;
        }

        // Insert the item and update the size
        array[front] = item;
        size++;
    }

    // Insert an element at the rear of the deque
    public void insertRear(int item) {
        // Check if the deque is full
        if (isFull()) {
            System.out.println("Deque is full. Cannot insert at the rear.");
            return;
        }

        // Adjust front and rear pointers based on whether the deque is empty
        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else {
            rear = (rear + 1) % capacity;
        }

        // Insert the item and update the size
        array[rear] = item;
        size++;
    }

    // Delete an element from the front of the deque
    public int deleteFront() {
        // Check if the deque is empty
        if (isEmpty()) {
            System.out.println("Deque is empty. Cannot delete from the front.");
            return -1; //-1 is a sentinel value in the deque
        }

        // Retrieve the deleted item and adjust front and rear pointers if needed
        int deletedItem = array[front];
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % capacity;
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

        int deletedItem = array[rear];
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            rear = (rear - 1 + capacity) % capacity;
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

        return array[front]; // Return the front element
    }

    // Get the rear element of the deque
    public int getRear() {
        // Check if the deque is empty
        if (isEmpty()) {
            System.out.println("Deque is empty. No rear element.");
            return -1;
        }

        return array[rear]; // Return the rear element
    }

    // Display the elements of the deque
    public void display() {
        if (isEmpty()) {
            System.out.println("Deque is empty.");
            return;
        }

        // Iterate through the deque and print its elements
        int current = front;
        while (current != rear) {
            System.out.print(array[current] + " ");
            current = (current + 1) % capacity;
        }
        System.out.println(array[rear]);
    }

    public static void main(String[] args) {
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
OUTPUT
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
