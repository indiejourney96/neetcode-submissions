
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        // Case 1: Exclude the last house
        int robFirst = dp(nums, 0, nums.length - 1);

        // Case 2: Exclude the first house
        int robLast = dp(nums, 1, nums.length);

        return Math.max(robFirst, robLast);
    }

    private int dp(int[] nums, int start, int end) {
        int n = end - start;

        if (n == 1) {
            return nums[start];
        }

        int[] dp = new int[n];

        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);

        for (int i = 2; i < n; i++) {
            // Skip current house OR rob it and skip the previous one
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[start + i]);
        }

        return dp[n - 1];
    }
}

// Dynamic Programming (Bottom-Up)
// Time Complexity: O(n)
// Space Complexity: O(n)

//Because the houses are circular, I solve two linear problems: one excluding the last house and one excluding the first. Each uses bottom-up DP to calculate the maximum amount, and I return the larger result.
