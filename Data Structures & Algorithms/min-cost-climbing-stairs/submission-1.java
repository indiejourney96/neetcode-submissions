
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] cache = new int[cost.length];

        // -1 means the result has not been calculated yet
        for (int i = 0; i < cost.length; i++) {
            cache[i] = -1;
        }

        // We can start from step 0 or step 1
        return Math.min(
            dfs(cost, 0, cache),
            dfs(cost, 1, cache)
        );
    }

    public int dfs(int[] cost, int i, int[] cache) {
        // Reached or passed the top: no additional cost
        if (i >= cost.length) {
            return 0;
        }

        // Reuse the cached result
        if (cache[i] != -1) {
            return cache[i];
        }

        // Pay for this step, then choose the cheaper next step
        cache[i] = cost[i] + Math.min(
            dfs(cost, i + 1, cache),
            dfs(cost, i + 2, cache)
        );

        return cache[i];
    }
}

// Dynamic Programming (Top-Down with Memoization)
// Time Complexity: O(n)
// Space Complexity: O(n)
