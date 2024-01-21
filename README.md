# Execution Time Testing (Row-Wise and Column-Wise 2D Array Initialization)

This Java program demonstrates the efficiency of initializing a 2D array in both row-wise and column-wise fashion. The primary focus is on measuring the execution time for various matrix sizes, providing insights into the performance of each initialization approach.

Row-Wise Initialization (Test1_Row and others):
1) The rowWise method in the Q2_main class initializes a 2D array by filling it row by row.
2) Test cases, such as Test1_Row, measure the execution time for different matrix sizes (e.g., r = 5, c = 6).

Column-Wise Initialization (Test1_Column and others):
1) The columnWise method in the Q2_main class initializes a 2D array by filling it column by column.
2) Test cases, like Test1_Column, measure the execution time for various matrix sizes.

Test Cases (Test2_Row, Test2_Column, Test3_Row, Test3_Column, ...):
1) The program includes additional test cases with varying matrix sizes (e.g., r = 50, c = 60, r = 500, c = 600, r = 5000, c = 6000).
2) Each test case measures the execution time for both row-wise and column-wise initialization.

**EXECUTION TIME ANALYSIS:**

Test1_Row and Test1_Column:
1) Size: r = 5, c = 6
2) Row-wise and column-wise initialization times are measured and printed.

Additional Test Cases:

1) Various matrix sizes are tested to observe how execution time scales with input size.

Key Points:
1) Efficient array initialization in both row-wise and column-wise manners.
2) Test cases demonstrate the performance across different matrix sizes.
3) Execution times are measured using System.nanoTime() for accuracy.
