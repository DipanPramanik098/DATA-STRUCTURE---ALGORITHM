package _007_Binary_Search._04_AdvanceQS;

public class _05_Kth_Element_OF_Two_Sorted_Arr {

    // Function to find kth element of two sorted arrays
    public int kthElement(int[] a, int[] b, int k) {
        int m = a.length;
        int n = b.length;

        // Always binary search on smaller array
        if (m > n) {
            return kthElement(b, a, k);
        }

        int low = Math.max(0, k - n);
        int high = Math.min(k, m);

        while (low <= high) {
            int mid1 = low + (high - low) / 2;
            int mid2 = k - mid1;

            int l1 = (mid1 > 0) ? a[mid1 - 1] : Integer.MIN_VALUE;
            int r1 = (mid1 < m) ? a[mid1] : Integer.MAX_VALUE;

            int l2 = (mid2 > 0) ? b[mid2 - 1] : Integer.MIN_VALUE;
            int r2 = (mid2 < n) ? b[mid2] : Integer.MAX_VALUE;

            // Correct partition
            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            }
            // Too many elements taken from a
            else if (l1 > r2) {
                high = mid1 - 1;
            }
            // Too few elements taken from a
            else {
                low = mid1 + 1;
            }
        }

        // Dummy return
        return -1;
    }

    public static void main(String[] args) {
        _05_Kth_Element_OF_Two_Sorted_Arr obj = new _05_Kth_Element_OF_Two_Sorted_Arr();

        int[] a1 = {2, 3, 6, 7, 9};
        int[] b1 = {1, 4, 8, 10};
        System.out.println(obj.kthElement(a1, b1, 5)); // 6

        int[] a2 = {100, 112, 256, 349, 770};
        int[] b2 = {72, 86, 113, 119, 265, 445, 892};
        System.out.println(obj.kthElement(a2, b2, 7)); // 256

        int[] a3 = {2, 3, 6};
        int[] b3 = {7, 9};
        System.out.println(obj.kthElement(a3, b3, 4)); // 7
    }
}