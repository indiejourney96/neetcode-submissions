class Solution {
    public int coinChange(int[] coins, int amount) {
        HashMap<Integer, Integer> cache = new HashMap<>();

        int result = dfs(coins, amount, cache);

        // If no valid combination exists, return -1
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int dfs(int[] coins, int amount, HashMap<Integer, Integer> cache) {

        // Successfully reached the target amount
        if (amount == 0) {
            return 0;
        }

        // Cannot make a negative amount
        if (amount < 0) {
            return Integer.MAX_VALUE;
        }

        // Return previously calculated result
        if (cache.containsKey(amount)) {
            return cache.get(amount);
        }

        int minCoins = Integer.MAX_VALUE;

        // Try every available coin
        for (int coin : coins) {

            // Use this coin and solve the remaining amount
            int result = dfs(coins, amount - coin, cache);

            // If the remaining amount is possible, update minimum
            if (result != Integer.MAX_VALUE) {
                minCoins = Math.min(minCoins, result + 1);
            }
        }

        // Store the result in cache
        cache.put(amount, minCoins);

        return minCoins;
    }
}

// Top-Down DP (Memoization)
// Time Complexity: O(amount * n)
// Space Complexity: O(amount)


// 1. Create cache
// HashMap<Integer, Integer> cache = new HashMap<>();

// 2. Check cache
// if (cache.containsKey(amount)) {
//     return cache.get(amount);
// }

// 3. Store result
// cache.put(amount, minCoins);