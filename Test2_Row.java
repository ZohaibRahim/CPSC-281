package Q2;
public class Test2_Row {
    public static void main(String[] args) {

        long startTime = System.nanoTime(); // start time

        int r=50, c=60; // size of matrix
        double row[][]= new double[r][c]; // defining the array
        Q2_main.rowWise(row,r,c);// calling the method to initialize 2d array in row major access

        long endTime = System.nanoTime(); // end time
        long executionTime = endTime - startTime; // the time difference between start and end time to calculate the actual time taken for execution

        System.out.println("Execution Time: " + executionTime + " nanoseconds");// printing the execution time
        System.out.printf("Hello %.5f bye %d",row[r][c], r);
        System.out.print("Hello "+ row[r][c]+ " bye " + r);
    }
}

// Execution Time: Execution Time: 437600 nanoseconds
// Build completed successfully in 1 sec, 548 ms