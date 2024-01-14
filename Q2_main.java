package Q2;
public class Q2_main {

        public static void rowWise(double arr[][], int row, int col){ // row major 2d Array method
            double k=1; //value for the array
            for (int i=0; i<row; i++) // row
                for (int j=0; j<col; j++){ // column
                    arr[i][j] = k; // putting value in the array
                    k++; // incrementing the value
                }
        }
                public static void columnWise(double arr[][], int row, int col){ //column major 2d Array method
            double k=1; //value for the array
                for (int j=0; j<col; j++) //column
                    for (int i=0; i<row; i++){ //row
                        arr[i][j] = k; // putting value in the array
                        k++; // incrementing the value
                    }
        }
        public static void printing2dArray(double arr[][], int row, int col){ // method to print the values
            for (int i=0; i<row; i++) { //row
                for (int j = 0; j < col; j++) { //column
                    System.out.printf("%.2f ", arr[i][j]); // printing out values rounding up to 2 decimal places
                }
                System.out.println(); // going to next line after printing all the numbers in a row
            }
        }
    }


