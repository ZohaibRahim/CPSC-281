package Q2;

public class Test1_Column {
    public static void main(String[] args) {

        long startTime = System.nanoTime(); // start time

        int r=5, c=6; // size of matrix
        double column[][]= new double[r][c]; // defining the array
        Q2_main.columnWise(column,r,c); // calling the method to initialize 2d array in column major access

        long endTime = System.nanoTime();// end time
        long executionTime = endTime - startTime;// the time difference between start and end time to calculate the actual time taken for execution

        System.out.println("Execution Time: " + executionTime + " nanoseconds"); // printing the execution time
    }
}

/*
1.00 6.00 11.00 16.00 21.00 26.00
2.00 7.00 12.00 17.00 22.00 27.00
3.00 8.00 13.00 18.00 23.00 28.00
4.00 9.00 14.00 19.00 24.00 29.00
5.00 10.00 15.00 20.00 25.00 30.00

Execution Time: 476200 nanoseconds
Build completed successfully in 1 sec, 536 ms
*/