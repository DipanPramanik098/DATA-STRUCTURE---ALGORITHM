package _005_ARRAY._05_Contest;

import java.util.*;

public class _03_Number_Of_Jumps {

    // Fenwick Tree (Binary Indexed Tree)
    static class Fenwick {

        int[] tree;

        Fenwick(int n) {
            tree = new int[n + 1];
        }

        // Update tree
        void update(int i) {
            while (i < tree.length) {
                tree[i] += 1;
                i += i & (-i);
            }
        }

        // Query prefix sum
        int query(int i) {

            int sum = 0;

            while (i > 0) {
                sum += tree[i];
                i -= i & (-i);
            }

            return sum;
        }
    }

    public int NumberOfJumps(int[] nums, int k) {

        int n = nums.length;

        List<Integer> values = new ArrayList<>();

        // Store values for compression
        for (int num : nums) {
            values.add(num);
            values.add(num + k);
        }

        Collections.sort(values);

        Map<Integer, Integer> map = new HashMap<>();

        int index = 1;

        // Coordinate compression
        for (int v : values) {
            if (!map.containsKey(v)) {
                map.put(v, index++);
            }
        }

        Fenwick fenwick = new Fenwick(index);

        int result = 0;

        int processed = 0;

        // Traverse from right
        for (int i = n - 1; i >= 0; i--) {

            int threshold = map.get(nums[i] + k);

            // numbers greater than threshold
            int count = processed - fenwick.query(threshold);

            result += count;

            // insert current number
            fenwick.update(map.get(nums[i]));

            processed++;
        }

        return result;
    }

    public static void main(String[] args) {

        _03_Number_Of_Jumps obj = new _03_Number_Of_Jumps();

        int[] nums = {3,1,10,6,5};
        int k = 2;

        int result = obj.NumberOfJumps(nums, k);

        System.out.println("Total Jumps: " + result);
    }
}