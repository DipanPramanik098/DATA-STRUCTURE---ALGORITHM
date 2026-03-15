package _007_Binary_Search._04_AdvanceQS;

public class _04_Median_Of_Two_Sorted_Array {

    // Function to find median of two sorted arrays
    public double median(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;

        // Always binary search on smaller array
        if (n1 > n2) {
            return median(arr2, arr1);
        }

        int total = n1 + n2;
        int left = (total + 1) / 2;

        int low = 0;
        int high = n1;

        while (low <= high) {
            int mid1 = low + (high - low) / 2;
            int mid2 = left - mid1;

            int l1 = (mid1 > 0) ? arr1[mid1 - 1] : Integer.MIN_VALUE;
            int r1 = (mid1 < n1) ? arr1[mid1] : Integer.MAX_VALUE;

            int l2 = (mid2 > 0) ? arr2[mid2 - 1] : Integer.MIN_VALUE;
            int r2 = (mid2 < n2) ? arr2[mid2] : Integer.MAX_VALUE;

            // Correct partition found
            if (l1 <= r2 && l2 <= r1) {
                if (total % 2 == 1) {
                    return Math.max(l1, l2);
                } else {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                }
            }
            // Too many elements taken from arr1
            else if (l1 > r2) {
                high = mid1 - 1;
            }
            // Too few elements taken from arr1
            else {
                low = mid1 + 1;
            }
        }

        // Dummy return
        return 0.0;
    }

    public static void main(String[] args) {
        _04_Median_Of_Two_Sorted_Array obj = new _04_Median_Of_Two_Sorted_Array();

        int[] arr1 = {2, 4, 6};
        int[] arr2 = {1, 3, 5};
        System.out.println(obj.median(arr1, arr2)); // 3.5

        int[] arr3 = {2, 4, 6};
        int[] arr4 = {1, 3};
        System.out.println(obj.median(arr3, arr4)); // 3.0

        int[] arr5 = {2, 4, 5};
        int[] arr6 = {1, 6};
        System.out.println(obj.median(arr5, arr6)); // 4.0
    }
}