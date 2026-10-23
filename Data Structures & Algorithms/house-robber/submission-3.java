
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        // Handle the edge cases
        if (n == 1) {
            return nums[0];
        }

        // Best amount from the first two houses
        int prev2 = nums[0];
        int prev1 = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
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


//Interview explanation
// “I optimise the dynamic programming solution by keeping only the previous two results instead of storing the entire dp array. For each house, I choose the maximum between skipping it and robbing it while adding the best result from two houses earlier. This reduces the space complexity from O(n) to O(1), while keeping the time complexity at O(n).

// Example walkthrough
// Input: nums = [2, 9, 8, 3, 6]
// House index	    Money	prev2	prev1	current
// Initial	        —	    2	    9	    —
// 2	            8	    9	    10	    10
// 3	            3	    10	    12	    12
// 4	            6	    12	    16	    16
