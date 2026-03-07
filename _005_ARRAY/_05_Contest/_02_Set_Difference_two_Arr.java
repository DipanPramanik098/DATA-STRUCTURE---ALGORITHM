package _005_ARRAY._05_Contest;

import java.util.*;

public class _02_Set_Difference_two_Arr {

    public static int[] setDifference(int[] nums1, int[] nums2) {

        List<Integer> result = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < nums1.length && j < nums2.length) {

            int a = nums1[i];
            int b = nums2[j];

            // Case 1 → element only in nums1
            if (a < b) {

                if (result.isEmpty() || result.get(result.size() - 1) != a) {
                    result.add(a);
                }

                // skip duplicates
                while (i < nums1.length && nums1[i] == a) {
                    i++;
                }
            }

            // Case 2 → element only in nums2
            else if (a > b) {

                if (result.isEmpty() || result.get(result.size() - 1) != b) {
                    result.add(b);
                }

                // skip duplicates
                while (j < nums2.length && nums2[j] == b) {
                    j++;
                }
            }

            // Case 3 → common element
            else {

                while (i < nums1.length && nums1[i] == a) {
                    i++;
                }

                while (j < nums2.length && nums2[j] == b) {
                    j++;
                }
            }
        }

        // Remaining elements of nums1
        while (i < nums1.length) {

            int a = nums1[i];

            if (result.isEmpty() || result.get(result.size() - 1) != a) {
                result.add(a);
            }

            while (i < nums1.length && nums1[i] == a) {
                i++;
            }
        }

        // Remaining elements of nums2
        while (j < nums2.length) {

            int b = nums2[j];

            if (result.isEmpty() || result.get(result.size() - 1) != b) {
                result.add(b);
            }

            while (j < nums2.length && nums2[j] == b) {
                j++;
            }
        }

        // Convert list to array
        int[] ans = new int[result.size()];

        for (int k = 0; k < result.size(); k++) {
            ans[k] = result.get(k);
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] nums1 = {1,5,7,9};
        int[] nums2 = {1,3,4,7};

        int[] result = setDifference(nums1, nums2);

        System.out.println("Set Difference:");

        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}