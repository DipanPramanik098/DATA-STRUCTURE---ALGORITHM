package _007_Binary_Search._04_AdvanceQS;

public class _03_Find_Peek_Element {

    // Function to find index of any peak element
    public int findPeakElement(int[] arr) {
        int n = arr.length;

        // Edge cases
        if (n == 1) return 0;
        if (arr[0] > arr[1]) return 0;
        if (arr[n - 1] > arr[n - 2]) return n - 1;

        int low = 1;
        int high = n - 2;

        // Binary search in the middle part
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Check if mid is peak
            if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) {
                return mid;
            }

            // We are on increasing slope, move right
            if (arr[mid] > arr[mid - 1]) {
                low = mid + 1;
            }
            // We are on decreasing slope, move left
            else {
                high = mid - 1;
            }
        }

        // Dummy return, logically a peak always exists
        return -1;
    }

    public static void main(String[] args) {
        _03_Find_Peek_Element obj = new _03_Find_Peek_Element();

        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 5, 1};
        System.out.println(obj.findPeakElement(arr1)); // 7

        int[] arr2 = {1, 2, 1, 3, 5, 6, 4};
        System.out.println(obj.findPeakElement(arr2)); // 1 or 5

        int[] arr3 = {-2, -1, 3, 4, 5};
        System.out.println(obj.findPeakElement(arr3)); // 4
    }
}