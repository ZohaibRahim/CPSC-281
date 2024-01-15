/**
 Huffman code makes character storage more efficient by assigning shorter codes to characters
 that occur more frequently and longer codes to those that occur less frequently. This involves
 construction and traversal of a binary tree, as explained in the class. Consider the following
 weights assigned to the alphabet:
 A = 7 B = 2 C = 2 D = 3 E = 11 F = 2 G = 2
 H = 6 I = 6 J = 1 K = 1 L = 4 M = 3 N = 7
 O = 9 P = 2 Q = 1 R = 6 S = 6 T = 8 U = 4
 V = 1 W = 2 X = 1 Y = 2 Z = 1
 Write a Java program which generates and prints code for each letter in the alphabet.
 */
package Q2;
public class HuffmanCoding {
    public static void generateHuffmanCodes(int[] frequencies, char[] characters) {
        int n = frequencies.length;

        // Create an array of TreeNodes to represent characters and their frequencies
        TreeNode[] nodes = new TreeNode[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new TreeNode(characters[i], frequencies[i]);
        }

        // Build the Huffman tree
        while (n > 1) {
            int min1 = findMinIndex(nodes, n);
            TreeNode node1 = nodes[min1];
            removeElement(nodes, min1, n);

            int min2 = findMinIndex(nodes, n - 1);
            TreeNode node2 = nodes[min2];
            removeElement(nodes, min2, n - 1);

            // Create a new internal node with the sum of frequencies
            TreeNode internalNode = new TreeNode('\0', node1.frequency + node2.frequency);
            internalNode.left = node1;
            internalNode.right = node2;

            // Insert the new internal node back into the array
            nodes[n - 2] = internalNode;
            n--;
        }

        // Print Huffman codes
        printHuffmanCodes(nodes[0], "");
    }

    private static void removeElement(TreeNode[] arr, int index, int size) {
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
    }

    private static int findMinIndex(TreeNode[] nodes, int size) {
        int minIndex = 0;
        for (int i = 1; i < size; i++) {
            if (nodes[i].frequency < nodes[minIndex].frequency) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    private static void printHuffmanCodes(TreeNode root, String code) {
        if (root != null) {
            if (root.data != '\0') {
                System.out.println(root.data + ": " + code);
            }
            printHuffmanCodes(root.left, code + "0");
            printHuffmanCodes(root.right, code + "1");
        }
    }

    public static void main(String[] args) {
        // Alphabet weights
        int[] weights = {7, 2, 2, 3, 11, 2, 2, 6, 6, 1, 1, 4, 3, 7, 9, 2, 1, 6, 6, 8, 4, 1, 2, 1, 2, 1};
        char[] characters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

        generateHuffmanCodes(weights, characters);
    }
}
 /*
 OUTPUT:
O: 000
Q: 001000
V: 001001
X: 001010
Z: 001011
H: 0011
E: 010
I: 0110
R: 0111
S: 1000
D: 10010
M: 10011
A: 1010
N: 1011
T: 1100
L: 11010
U: 11011
B: 111000
C: 111001
F: 111010
G: 111011
P: 111100
W: 111101
Y: 111110
J: 1111110
K: 1111111
  */