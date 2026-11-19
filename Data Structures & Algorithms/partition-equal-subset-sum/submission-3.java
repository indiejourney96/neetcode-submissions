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

        // dp[j] = Can we achieve sum j using the numbers processed so far?
        boolean[] dp = new boolean[target + 1];

        // A sum of 0 is always possible by selecting no elements
        dp[0] = true;

        // Process each number
        for (int num : nums) {

            // Iterate backwards to avoid using the same number twice
            for (int j = target; j >= num; j--) {

                // Either we already achieved j,
                // or we can achieve j by taking the current number
                dp[j] = dp[j] || dp[j - num];
            }
        }

        // Check whether we can achieve half of the total sum
        return dp[target];
    }
}

// Bottom-Up DP Space Optimised
// Time Complexity: O(n x S)
// Space Complexity: O(S)

// n = number of elements.
// S = target sum (half of the total sum).