/**
 The Josephus problem goes something like this:
    There are people standing in a circle waiting to be executed. After the first person is
    executed, certain number of people (say, k) are skipped, and one person is executed.
    Then again, k people are skipped, and a person is executed. The elimination
    proceeds around the circle (which is becoming smaller and smaller as the executed
    people are removed), until only the last person remains, who is given freedom.
 The task is to choose the place in the initial circle so that you survive (are the last one
 remaining). Use a circularly linked list to implement your solution, for any fixed k
 */

package Q2;

public class JosephusProblem {
    public static void main(String[] args) {
        int total = 9; // Total number of people
        int skip = 9; // Skip skip-1 people before elimination

        CircularLinkedList circle = new CircularLinkedList();

        // Insert people into the circle
        for (int i = 1; i <= total; i++) {
            circle.insert(i);
        }

        circle.eliminate(skip); // Eliminate people until only one remains

        int survivorPosition = circle.getSurvivor();// Get the survivor's position
        System.out.println("Total number of people: "+total);
        System.out.println("Number of people skipped: "+skip);
        System.out.println("The survivor is at position: " + survivorPosition);
    }
}
/*
Total number of people: 7
Number of people skipped: 3
The survivor is at position: 4

Total number of people: 10
Number of people skipped: 4
The survivor is at position: 5

Total number of people: 9
Number of people skipped: 9
The survivor is at position: 8
 */
