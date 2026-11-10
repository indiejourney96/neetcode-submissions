class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        // Cache: index and prevIndex
        int[][] cache = new int[n][n + 1];

        // -1 means the state has not been calculated
        for (int[] row : cache) {
            Arrays.fill(row, -1);
        }

        return dfs(nums, 0, -1, cache);
    }

    private int dfs(int[] nums, int index, int prevIndex, int[][] cache) {

        // Base case: Reached the end of the array
        if (index == nums.length) {
            return 0;
        }

        // Convert prevIndex into a valid cache column
        // prevIndex = -1 maps to column 0
        int cacheCol = prevIndex + 1;

        // Return previously calculated result
        if (cache[index][cacheCol] != -1) {
            return cache[index][cacheCol];
        }

        // Choice 1: Skip the current number
        int skip = dfs(nums, index + 1, prevIndex, cache);

        // Choice 2: Take the current number (if increasing)
        int take = 0;

        if (prevIndex == -1 || nums[index] > nums[prevIndex]) {
            take = 1 + dfs(nums, index + 1, index, cache);
        }

        // Store the maximum result
        cache[index][cacheCol] = Math.max(take, skip);

        return cache[index][cacheCol];
    }
}

// DP Top down 
// Time Complexity:O(n^2)
// Space Complexity: O(n^2)