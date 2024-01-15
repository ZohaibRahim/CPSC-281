# CPSC-281
Data Structures

**Removing Duplicates from an Array**

**Description:**
The provided Java programs aim to remove duplicate elements from an integer array. Two different implementations are presented, each with its unique approach to achieving this task. The primary purpose is to enhance understanding and flexibility for removing duplicates.

**Implementation - Q1 Class:**
1. **Main Method:**
   - Initializes an integer array with duplicate values.
   - Calls the `removeDuplicate` method to eliminate duplicates.
   - Prints the unique elements of the array.

2. **`removeDuplicate` Method:**
   - Accepts an integer array as a parameter.
   - Iterates through the array, replacing duplicate elements with a sentinel value (`arr[0]-1`).
   - Ensures that the length of the array remains unchanged.
   - Prints the unique elements after processing.

**Output:**
```
1 2 3 4 5
```

**Handling Unsorted Arrays:**
- The program efficiently removes duplicates even if the array is not sorted.
- By comparing consecutive elements, duplicates are identified and replaced.
- To manage unsorted arrays, it fills the rest of the slots with the sentinel value of the smallest element.

**Implementation - abc Class:**
1. **`removeDuplicates` Method:**
   - Accepts an integer array as a parameter.
   - Iterates through the array, keeping track of unique elements.
   - Copies unique elements to the beginning of the array and sets the remaining elements to 0.

2. **Main Method:**
   - Initializes an integer array with duplicate values.
   - Calls the `removeDuplicates` method.
   - Prints the unique elements of the array.

**Output:**
```
1 2 3 4 5 8 10
```

**Key Features:**
1. **Flexibility:** Handles both sorted and unsorted arrays.
2. **Efficient:** Achieves duplicate removal in a single pass.
3. **Maintains Length:** Preserves the original length of the array.
4. **Sentinel Value:** Uses a sentinel value to mark replaced elements.

**GitHub Repository:**
[Removing Duplicates](https://github.com/ZohaibRahim/Removing-Duplicates)

Explore the provided Java programs to understand different approaches for removing duplicate elements from arrays. The implementations showcase flexibility and efficiency, making them suitable for various scenarios. The GitHub repository includes the source code and additional details for a comprehensive reference.
