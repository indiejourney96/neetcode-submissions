public class Solution {
    public int climbStairs(int n) {
        // Base cases: 1 way for 1 step, 2 ways for 2 steps
        if (n <= 2) {
            return n;
        }

        int[] dp = new int[n + 1];

        // Store the number of ways to reach step 1 and step 2
        dp[1] = 1;
        dp[2] = 2;

        // Ways to reach step i = ways from i-1 + ways from i-2
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}


// Dynamic Programming (Down - Top)
// Time Complexity: O(n)
// Space Complexity : O(n)


// I use bottom-up dynamic programming. I know there is one way to reach step 1 and two ways to reach step 2. For every subsequent step, I can arrive from either the previous step by taking one stair or the step before that by taking two stairs. Therefore, I add those two results and store them in the DP array. Finally, I return dp[n].


//Example: n = 5
// Step i	Calculation	    dp[i]
// 1	    Base case	        1
// 2	    Base case	        2
// 3	    dp[2] + dp[1]	    3
// 4	    dp[3] + dp[2]	    5
// 5	    dp[4] + dp[3]	    8