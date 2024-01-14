package Q2;

public class Test3_Column{
    public static void main(String[] args) {

        long startTime = System.nanoTime(); // start time

        int r=500, c=600; // size of matrix
        double column[][]= new double[r][c]; // defining the array
        Q2_main.columnWise(column,r,c); // calling the method to initialize 2d array in column major access

        long endTime = System.nanoTime();// end time
        long executionTime = endTime - startTime;// the time difference between start and end time to calculate the actual time taken for execution

        System.out.println("Execution Time: " + executionTime + " nanoseconds"); // printing the execution time
    }
}
// Execution Time: 3834100 nanoseconds
// Build completed successfully in 1 sec, 620 ms

