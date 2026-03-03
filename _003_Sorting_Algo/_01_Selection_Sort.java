package _003_Sorting_Algo;
class Solution {

  public int[] selectionSort(int[] nums) {

    // Outer loop: Controls the boundary of sorted and unsorted parts
    // After each iteration, one element is placed correctly
    for (int i = 0; i < nums.length - 1; i++) {

      // Assume the current index is the minimum
      int minIndex = i;

      // Inner loop: Find the actual minimum element
      // in the remaining unsorted part
      for (int j = i + 1; j < nums.length; j++) {

        // If a smaller element is found
        if (nums[j] < nums[minIndex]) {
          minIndex = j;  // Update minIndex
        }
      }

      // Swap only if a smaller element was found
      if (minIndex != i) {
        int temp = nums[i];
        nums[i] = nums[minIndex];
        nums[minIndex] = temp;
      }
    }

    // Return the sorted array
    return nums;
  }
}
public class _01_Selection_Sort {
  public static void main(String[] args) {

    int[] arr = {7, 5, 9, 2, 8};

    System.out.print("Original array: ");
    for (int num : arr) {
      System.out.print(num + " ");
    }
    System.out.println();

    // Create object of Solution class
    Solution solution = new Solution();

    // Call selectionSort method
    int[] sortedArr = solution.selectionSort(arr);

    System.out.print("Sorted array: ");
    for (int num : sortedArr) {
      System.out.print(num + " ");
    }
    System.out.println();
  }
}
