class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        // dp[i] = Length of the longest increasing subsequence
        //         ending at index i
        int[] dp = new int[n];

        // Every element can form an increasing subsequence of length 1
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        int maxLength = 1;

        // Start from the second element
        for (int i = 1; i < n; i++) {

            // Check all elements before the current index
            for (int j = 0; j < i; j++) {

                // Only extend the subsequence if nums[i] is greater
                // than the previous element nums[j]
                if (nums[i] > nums[j]) {

                    // Extend the previous increasing subsequence
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            // Update the overall longest increasing subsequence
            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
    }
}

// Bottom up DP 
// Time Complexity: O(n^2)
// Space Complexity: O(n)