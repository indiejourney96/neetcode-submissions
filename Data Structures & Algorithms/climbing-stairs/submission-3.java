public class Solution {
    public int climbStairs(int n) {
        if (n <= 2){
            return n;
        }

        // Store only the previous two results
        int prev2 = 1; 
        int prev1 = 2;

        for (int i = 3; i <= n; i++){
            int current = prev1 + prev2;

            // Shift forward the next step
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }
}

// Dynamic Programming (Space Optimized)
// Time Complexity: O(n)
// Space Complexity : O(1)

// I optimize the bottom-up DP solution by removing the array because each step only depends on the previous two steps. I use two variables to store those results, calculate the current number of ways, and update the variables as I iterate. This keeps the time complexity at O(n) while reducing space complexity to O(1)

//Example: n = 5
// Step i	Calculation	    dp[i]
// 1	    Base case	        1
// 2	    Base case	        2
// 3	    dp[2] + dp[1]	    3
// 4	    dp[3] + dp[2]	    5
// 5	    dp[4] + dp[3]	    8