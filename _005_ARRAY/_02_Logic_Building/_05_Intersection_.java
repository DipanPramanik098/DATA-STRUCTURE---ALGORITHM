package _005_ARRAY._02_Logic_Building;

import java.util.*;

public class _05_Intersection_ {

    // Method to find intersection of two sorted arrays
    public static int[] intersectionArray(int[] nums1, int[] nums2) {

        // List to store intersection elements
        List<Integer> list = new ArrayList<>();

        // Two pointers for both arrays
        int i = 0;
        int j = 0;

        // Traverse both arrays
        while (i < nums1.length && j < nums2.length) {

            // If element in nums1 is smaller
            if (nums1[i] < nums2[j]) {
                i++;
            }

            // If element in nums2 is smaller
            else if (nums2[j] < nums1[i]) {
                j++;
            }

            // If elements are equal
            else {

                // Add element to intersection
                list.add(nums1[i]);

                // Move both pointers
                i++;
                j++;
            }
        }

        // Convert list to array
        int[] result = new int[list.size()];

        for (int k = 0; k < list.size(); k++) {
            result[k] = list.get(k);
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums1 = {-45, -45, 0, 0, 2};
        int[] nums2 = {-50, -45, 0, 0, 5, 7};

        int[] ans = intersectionArray(nums1, nums2);

        System.out.println("Intersection of arrays:");

        for (int num : ans) {
            System.out.print(num + " ");
        }
    }
}