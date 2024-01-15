package Q1;

class DoublyLinkedList {
    Node head;
    Node tail;

    // Insert method adds a new element to the end of the list
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            // If the list is empty, set the new node as both head and tail
            head = newNode;
            tail = newNode;
        }
        else {
            // Otherwise, add the new node to the end of the list
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Display method prints the elements of the list
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    //displayReverse method prints the elements of the list in reverse order
    public void displayReverse() {
        Node current = tail;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.prev;
        }
        System.out.println();
    }
}
