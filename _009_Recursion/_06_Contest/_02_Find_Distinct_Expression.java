package _009_Recursion._06_Contest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _02_Find_Distinct_Expression {
    public int[] distinctExpressions(int[] nums) {

        // Set to store unique results
        Set<Integer> set = new HashSet<>();

        // Start recursion from index 1
        // Initial sum = nums[0]
        dfs(1, nums, nums[0], set);

        // Convert set to list
        List<Integer> list = new ArrayList<>(set);

        // Sort the list
        Collections.sort(list);

        // Convert list to array
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }

    private void dfs(int index, int[] nums, int currentSum, Set<Integer> set) {

        // Base case: all elements processed
        if (index == nums.length) {
            set.add(currentSum);
            return;
        }

        // Choice 1: Add current number
        dfs(index + 1, nums, currentSum + nums[index], set);

        // Choice 2: Subtract current number
        dfs(index + 1, nums, currentSum - nums[index], set);
    }
}
