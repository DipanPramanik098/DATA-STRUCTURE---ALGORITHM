package _005_ARRAY._02_Logic_Building;

import java.util.*;

public class _04_Union_Of_Two_Sorted_Array {

    // Method to find union of two sorted arrays
    public static int[] unionArray(int[] nums1, int[] nums2) {

        // List to store union elements
        List<Integer> unionList = new ArrayList<>();

        int i = 0; // pointer for nums1
        int j = 0; // pointer for nums2

        int n = nums1.length;
        int m = nums2.length;

        // Traverse both arrays
        while (i < n && j < m) {

            // Case 1: element in nums1 is smaller or equal
            if (nums1[i] <= nums2[j]) {

                // Add element only if list is empty OR last element is different
                if (unionList.isEmpty() || unionList.get(unionList.size() - 1) != nums1[i]) {
                    unionList.add(nums1[i]);
                }

                i++; // move pointer of nums1
            }

            // Case 2: element in nums2 is smaller
            else {

                if (unionList.isEmpty() || unionList.get(unionList.size() - 1) != nums2[j]) {
                    unionList.add(nums2[j]);
                }

                j++; // move pointer of nums2
            }
        }

        // Add remaining elements from nums1
        while (i < n) {

            if (unionList.isEmpty() || unionList.get(unionList.size() - 1) != nums1[i]) {
                unionList.add(nums1[i]);
            }

            i++;
        }

        // Add remaining elements from nums2
        while (j < m) {

            if (unionList.isEmpty() || unionList.get(unionList.size() - 1) != nums2[j]) {
                unionList.add(nums2[j]);
            }

            j++;
        }

        // Convert List to Array
        int[] union = new int[unionList.size()];

        for (int k = 0; k < unionList.size(); k++) {
            union[k] = unionList.get(k);
        }

        return union;
    }

    public static void main(String[] args) {

        int[] nums1 = {1,2,3,4,5,6,7,8,9,10};
        int[] nums2 = {2,3,4,4,5,11,12};

        // Call union method
        int[] result = unionArray(nums1, nums2);

        // Print union array
        System.out.println("Union of arrays:");

        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}