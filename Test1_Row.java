package Q2;

public class Test1_Row {
    public static void main(String[] args) {

        long startTime = System.nanoTime(); // start time

        int r=5, c=6; // size of matrix
        double row[][]= new double[r][c]; // defining the array
        Q2_main.rowWise(row,r,c);// calling the method to initialize 2d array in row major access

        long endTime = System.nanoTime(); // end time
        long executionTime = endTime - startTime; // the time difference between start and end time to calculate the actual time taken for execution

        System.out.println("Execution Time: " + executionTime + " nanoseconds");// printing the execution time
    }
}
/*
1.00 2.00 3.00 4.00 5.00 6.00
7.00 8.00 9.00 10.00 11.00 12.00
13.00 14.00 15.00 16.00 17.00 18.00
19.00 20.00 21.00 22.00 23.00 24.00
25.00 26.00 27.00 28.00 29.00 30.00
Execution Time: 465600 nanoseconds

Build completed successfully in 2 sec, 242 ms
 */
