
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

//“I use bottom-up dynamic programming, where dp[i] represents the minimum cost to reach step i. The first two positions have zero cost because we can start at step 0 or step 1 without paying. For each subsequent step, I compare reaching it from the previous step or from two steps before, adding the cost of the step I came from. Finally, dp[n] gives the minimum cost to reach the top.”

// Example: cost = [10, 15, 20]
// Step	Calculation	Minimum     cost
// dp[0]	Starting position	    0
// dp[1]	Starting position	    0
// dp[2]	min(0 + 15, 0 + 10)	    10
// dp[3]	min(10 + 20, 0 + 15)	15