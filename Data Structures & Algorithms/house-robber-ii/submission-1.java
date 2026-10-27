class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int[][] cache = new int[nums.length][2];

        // Initialise both caches to -1 (not calculated)
        for (int i = 0; i < nums.length; i++) {
            cache[i][0] = -1;
            cache[i][1] = -1;
        }

        // Case 1: Rob houses from index 0 to n - 2
        int robFirst = dfs(nums, 0, nums.length - 1, cache, 0);

        // Case 2: Rob houses from index 1 to n - 1
        int robLast = dfs(nums, 1, nums.length, cache, 1);

        return Math.max(robFirst, robLast);
    }

    private int dfs(int[] nums, int i, int end, int[][] cache, int caseNum) {
        if (i >= end) {
            return 0;
        }

        // Return the cached result if already calculated
        if (cache[i][caseNum] != -1) {
            return cache[i][caseNum];
        }

        // Option 1: Skip this house
        // Option 2: Rob this house and skip the next one
        cache[i][caseNum] = Math.max(
            dfs(nums, i + 1, end, cache, caseNum),
            nums[i] + dfs(nums, i + 2, end, cache, caseNum)
        );

        return cache[i][caseNum];
    }
}

// Dynamic Programming (Top-Down)
// Time Complexity: O(n)
// Space Complexity: O(n)

//I use top-down dynamic programming with memoization. I split the circular houses into two linear cases, excluding either the first or last house. For each case, DFS chooses between skipping the current house and robbing it while skipping the next house. I cache each result to avoid recalculating subproblems.
