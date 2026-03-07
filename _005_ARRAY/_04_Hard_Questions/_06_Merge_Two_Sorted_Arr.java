package _005_ARRAY._04_Hard_Questions;

public class _06_Merge_Two_Sorted_Arr {

    // Function to merge nums2 into nums1
    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        // Pointer for last element in nums1
        int i = m - 1;

        // Pointer for last element in nums2
        int j = n - 1;

        // Pointer for last position of nums1
        int k = m + n - 1;

        // Traverse until nums2 is exhausted
        while (j >= 0) {

            // If nums1 element is greater
            if (i >= 0 && nums1[i] > nums2[j]) {

                nums1[k] = nums1[i];

                i--;
            } else {

                nums1[k] = nums2[j];

                j--;
            }

            k--;
        }
    }

    public static void main(String[] args) {

        int[] nums1 = {1,3,5,0,0,0,0};
        int[] nums2 = {2,4,6,7};

        int m = 3;
        int n = 4;

        merge(nums1, m, nums2, n);

        System.out.println("Merged array:");

        for(int num : nums1)
            System.out.print(num + " ");
    }
}