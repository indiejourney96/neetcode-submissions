
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        // Handle the edge cases
        if (n == 1) {
            return nums[0];
        }

        int[] dp = new int[n];

        // Base cases: best amount from the first two houses
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        // Calculate the maximum money up to each house
        for (int i = 2; i < n; i++) {
            // Option 1: Skip this house
            // Option 2: Rob this house and skip the previous one
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        // Return the maximum money from all houses
        return dp[n - 1];
    }
}

// Dynamic Programming (Bottom-Up)
// Time Complexity: O(n)
// Space Complexity: O(n)


//Interview explanation
// “I use bottom-up dynamic programming. I define dp[i] as the maximum amount of money I can rob from houses 0 through i without robbing adjacent houses. For each house, I have two choices: skip it and keep dp[i - 1], or rob it and add its money to dp[i - 2]. I take the maximum of these two choices. After processing every house, dp[n - 1] contains the answer.”

// Example walkthrough
// Input: nums = [2, 9, 8, 3, 6]
// House i	Money	Calculation	dp[i]
// 0	2	Base case	2
// 1	9	max(2, 9)	9
// 2	8	max(9, 2 + 8)	10
// 3	3	max(10, 9 + 3)	12
// 4	6	max(12, 10 + 6)	16
