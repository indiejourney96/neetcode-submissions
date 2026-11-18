class Solution {
    public boolean canPartition(int[] nums) {

        int total = 0;

        // Calculate the total sum
        for (int num : nums) {
            total += num;
        }

        // If total is odd, equal partition is impossible
        if (total % 2 != 0) {
            return false;
        }

        int target = total / 2;
        int n = nums.length;

        // dp[i][j] = Can we achieve sum j using the first i numbers?
        boolean[][] dp = new boolean[n + 1][target + 1];

        // Base case: sum 0 is always possible using no numbers
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // Process each number
        for (int i = 1; i <= n; i++) {

            int num = nums[i - 1];

            // Check every possible sum from 1 to target
            for (int j = 1; j <= target; j++) {

                // Option 1: Skip the current number
                dp[i][j] = dp[i - 1][j];

                // Option 2: Take the current number if it does not exceed j
                if (num <= j) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - num];
                }
            }
        }

        // Can we achieve the target using all numbers?
        return dp[n][target];
    }
}


// Bottom-Up DP
// Time Complexity: O(n x S)
// Space Complexity: O(n x S)

// n = number of elements.
// S = target sum (half of the total sum).
