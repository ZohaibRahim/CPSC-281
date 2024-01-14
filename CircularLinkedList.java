package Q2;

class CircularLinkedList {
    Node head; // Reference to the first node in the circular linked list

    // Method to insert a new node with data into the circular linked list
    public void insert(int data) {
        Node newNode = new Node(data);

        // If the list is empty, set the new node as the head and make it circular
        if (head == null) {
            head = newNode;
            head.next = head; // Make it circular
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
        }
    }

    // Method to perform the elimination process based on the given skip
    public void eliminate(int skip) {
        Node current = head;
        Node prev = null;

        // Continue eliminating until only one person remains
        while (current.next != current) {
            for (int i = 0; i < skip - 1; i++) {
                prev = current;
                current = current.next;
            }

            // Eliminate the current person by adjusting the pointers
            prev.next = current.next;
            current = prev.next;
        }

        head = current; // Set the head to the last remaining person
    }

    // Method to get the position of the survivor
    public int getSurvivor() {
        return head.data;
    }
}
