class Solution {
    public int climbStairs(int n) {
        int[] cache = new int[n];

        // Initialize cache with -1 (not calculated yet)
        for (int i = 0; i < n; i++) {
            cache[i] = -1;
        }

        return dfs(n, 0, cache);
    }

    public int dfs(int n, int i, int[] cache) {
        // Reached the top: 1 valid way; overshot: 0 ways
        if (i >= n) {
            return i == n ? 1 : 0;
        }

        // Return the cached result if already calculated
        if (cache[i] != -1) {
            return cache[i];
        }

        // Try taking 1 step or 2 steps, then save the result
        cache[i] = dfs(n, i + 1, cache) + dfs(n, i + 2, cache);

        return cache[i];
    }
}


// Dynamic Programming (Top - Down)
// Time Complexity: O(n)
// Space Complexity : O(n)