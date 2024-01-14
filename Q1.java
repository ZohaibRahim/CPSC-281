public class Q1 {
        public static void main(String[] args) {
            int arr[]={1,2,2,3,3,3,4,5,5};
            try {
                removeDuplicate(arr); // calling the method to remove duplicate(s)
                for (int i = 0; i < arr.length; i++)
                    if (arr[i] != (arr[0]-1))
                        System.out.print(arr[i] + " ");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Error: Index out of bounds. Please check your array and indexing logic.");
            }
        }
        public static void removeDuplicate( int arr[]){ // method to remove duplicate(s) which is taking array as an argument for the parameter arr []
            int arrSize= arr.length; // size of the array
            if (arrSize<=1) return; // if there are less than 1 or only 1 element in the array, it will return without any operation.
            int j=0; //
            for (int i=0; i<arrSize-1;i++){ //loop to check the duplicate
                if (arr[i]!= arr[i+1]) { // condition to check the 2 consecutive value
                    arr[j] = arr[i];// if the condition is true, the previous value is replaced with the later value
                    j++; //
                }
            }
            arr[j]=arr[arrSize-1];// the next j value is replaced by the last value of the list
            j++;
            for (int i=j; i<arrSize;i++) arr[i]= arr[0]-1; // the rest of the values are replaced with the -1 value of the first number in the list
        }
}
/*
OUTPUT:
1 2 3 4 5
 */

/*
Q: Does the length of the array change after removing duplicates? Why or why not, and how do you deal with this issue?
A: The length of the array doesn't change after removing the duplicates because once the size of array is defined, it cannot be changed. For this issue, the rest of the slots are filled in with the -1 value of the first element. And at the time of printing, once that value is encounter, that number isn't printed.

Q: What modifications to your program are required if the array is not sorted?
A: If the array is not sorted, then there are 2 options which can be done. 1st is sorting but it is expensive. 2nd option is to check the whole array to find the smallest value and then keep checking until the end for each element to find duplicate and if there are any duplicates, the value would be replaced by the -1 value of the smallest value. If -1 value of the smallest number is encountered, then it skips that element and moves to the next element.
 */

