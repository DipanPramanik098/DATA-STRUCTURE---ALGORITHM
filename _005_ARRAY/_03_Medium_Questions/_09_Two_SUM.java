package _005_ARRAY._03_Medium_Questions;

import java.util.*;

public class _09_Two_SUM {

    public static int[] twoSum(int[] nums, int target) {

        int n = nums.length;

        int[][] eleIndex = new int[n][2];

        for (int i = 0; i < n; i++) {
            eleIndex[i][0] = nums[i];
            eleIndex[i][1] = i;
        }

        Arrays.sort(eleIndex, (a, b) -> Integer.compare(a[0], b[0]));

        int left = 0;
        int right = n - 1;

        while (left < right) {

            int sum = eleIndex[left][0] + eleIndex[right][0];

            if (sum == target) {

                int i1 = eleIndex[left][1];
                int i2 = eleIndex[right][1];

                if (i1 < i2)
                    return new int[]{i1, i2};
                else
                    return new int[]{i2, i1};
            }

            else if (sum < target) {
                left++;
            }

            else {
                right--;
            }

        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {

        int[] nums = {-6, 7, 1, -7, 6, 2};
        int target = 3;

        int[] ans = twoSum(nums, target);

        System.out.println("Indices: [" + ans[0] + ", " + ans[1] + "]");
    }
}