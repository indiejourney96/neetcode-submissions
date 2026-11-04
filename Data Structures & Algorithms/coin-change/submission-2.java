class Solution {
    public int coinChange(int[] coins, int amount) {

        // dp[i] = minimum number of coins needed to make amount i
        int[] dp = new int[amount + 1];

        // Initialise all amounts as impossible
        Arrays.fill(dp, amount + 1);

        // Base case: 0 coins needed to make amount 0
        dp[0] = 0;

        // Calculate the minimum coins for every amount
        for (int i = 1; i <= amount; i++) {

            // Try every available coin
            for (int coin : coins) {

                // Only use the coin if it does not exceed the amount
                if (i >= coin) {

                    // Use this coin and add 1 to the previous result
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        // Return -1 if the target amount cannot be made
        return dp[amount] > amount ? -1 : dp[amount];
    }
}

// Bottom-Up DP (Tabulation)
// Time Complexity: O(amount * n)
// Space Complexity: O(amount)