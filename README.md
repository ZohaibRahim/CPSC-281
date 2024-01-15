# CPSC-281
Data Structures

**HUFFMAN CODING IMPLEMENTATION**

**Description:**
The Java program presented above implements Huffman coding, a data compression algorithm that assigns variable-length codes to characters based on their frequencies. The primary goal is to generate Huffman codes for each letter in the alphabet, optimizing the encoding to use shorter codes for more frequently occurring characters.

**Implementation:**

1) TreeNode Class: The program defines a TreeNode class to represent nodes in the Huffman tree, containing character data, frequency, left, and right child references.

2) generateHuffmanCodes Method:
    Accepts arrays of character frequencies and corresponding characters.
    Constructs an array of TreeNodes based on the characters and their frequencies.
    Builds the Huffman tree iteratively by merging nodes with the lowest frequencies until a single root node remains.
    Prints the Huffman codes for each letter by traversing the Huffman tree.

3) Auxiliary Methods:
    removeElement: Removes an element from an array at a specified index.
    findMinIndex: Finds the index of the TreeNode with the minimum frequency in an array.

**Execution:**
The program initializes arrays representing the weights assigned to each alphabet letter and the corresponding characters. It then utilizes the generateHuffmanCodes method to construct the Huffman tree and print the Huffman codes for each letter.

**Sample Output:**
The output demonstrates the Huffman codes assigned to each alphabet letter based on their frequencies. Shorter codes are assigned to more frequent letters, contributing to efficient data compression.

**Key Features:**
1) Huffman Tree Construction.
2) Huffman Code Generation.
3) Efficient Data Compression.
4) Alphabet Weights Customizable.
5) Straightforward Implementation.

This Java program provides a clear and concise implementation of Huffman coding, showcasing the efficiency of assigning variable-length codes to characters based on their frequencies. The output illustrates the resulting Huffman codes, highlighting the optimized representation of the alphabet for data compression purposes.
