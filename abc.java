public class abc {
        public static void removeDuplicates(int[] arr) {
            int n = arr.length;
            if (n == 0 || n == 1) {
                return;
            }

            int j = 0; // Index for the unique elements

            for (int i = 0; i < n - 1; i++) {
                if (arr[i] != arr[i + 1]) {
                    arr[j] = arr[i];
                    j++;
                }
            }

            arr[j++] = arr[n - 1]; // Copy the last element

            // Set the remaining elements to 0 (optional)
            for (int i = j; i < n; i++) {
               arr[i] = 0;
            }
        }

        public static void main(String[] args) {
            int arr[] = {1, 2, 2, 3, 3, 3, 4, 5, 5, 8, 10};

            removeDuplicates(arr);

            for (int i = 0; i < arr.length && arr[i] != 0; i++) {
                System.out.print(arr[i] + " ");
            }
        }
    }
