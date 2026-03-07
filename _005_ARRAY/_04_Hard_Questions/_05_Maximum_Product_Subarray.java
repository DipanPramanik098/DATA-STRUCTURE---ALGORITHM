package _005_ARRAY._04_Hard_Questions;

public class _05_Maximum_Product_Subarray {

    public static int maxProduct(int[] nums) {

        int n = nums.length;

        int prefix = 1;
        int suffix = 1;

        int maxProduct = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {

            // Reset prefix if it becomes zero
            if (prefix == 0)
                prefix = 1;

            // Reset suffix if it becomes zero
            if (suffix == 0)
                suffix = 1;

            // Prefix multiplication
            prefix *= nums[i];

            // Suffix multiplication
            suffix *= nums[n - i - 1];

            // Update maximum product
            maxProduct = Math.max(maxProduct, Math.max(prefix, suffix));
        }

        return maxProduct;
    }

    public static void main(String[] args) {

        int[] nums = {1, -2, 3, 4, -4, -3};

        int result = maxProduct(nums);

        System.out.println("Maximum Product Subarray = " + result);
    }
}