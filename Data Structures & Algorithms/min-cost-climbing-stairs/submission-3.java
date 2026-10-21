
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];

        // Base cases: start at step 0 or step 1
        dp[0] = 0;
        dp[1] = 0;

        // Calculate the minimum cost to reach each step
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(
                dp[i - 1] + cost[i - 1],
                dp[i - 2] + cost[i - 2]
            );
        }

        // dp[n] is the minimum cost to reach the top
        return dp[n];
    }
}

// Dynamic Programming (Bottom-Up)
// Time Complexity: O(n)
// Space Complexity: O(n)
