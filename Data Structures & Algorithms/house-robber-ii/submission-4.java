
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        // Handle the edge case
        if (n == 1) {
            return nums[0];
        }

        // Case 1: Exclude the last house
        int robFirst = robRange(nums, 0, n - 2);

        // Case 2: Exclude the first house
        int robLast = robRange(nums, 1, n - 1);

        return Math.max(robFirst, robLast);
    }

    private int robRange(int[] nums, int start, int end) {
        // Handle a range containing only one house
        if (start == end) {
            return nums[start];
        }


        // Best amount from the first two houses in this range
        int prev2 = nums[start];
        int prev1 = Math.max(nums[start], nums[start + 1]);

        for (int i = start + 2; i <= end; i++) {
            // Choose between skipping or robbing this house
            int current = Math.max(prev1, prev2 + nums[i]);

            // Move the values forward
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}

// Dynamic Programming (Space Optimised)
// Time Complexity: O(n)
// Space Complexity: O(1)

// I split the circular houses into two linear ranges: one excludes the last house, and the other excludes the first. For each range, I use two variables to track the best results from the previous two positions, choosing between skipping or robbing the current house. I return the maximum of the two ranges.


//Example walkthrough
//Input: nums = [2, 9, 8, 3, 6]

// Case 1: Exclude the last house — [2, 9, 8, 3]
// House money	prev2	prev1	current
// Initial	    2	    9	    —
// 8	        9	    10	    10
// 3	        10	    10	    12

// Result: 12 (rob 9 + 3)
