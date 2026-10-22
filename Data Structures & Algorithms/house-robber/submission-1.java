class Solution {
    public int rob(int[] nums) {
        int[] cache = new int[nums.length];

        // -1 means the result has not been calculated yet
        for (int i = 0; i < nums.length; i++) {
            cache[i] = -1;
        }

        return dfs(nums, 0, cache);
    }

    private int dfs(int[] nums, int i, int[] cache){
        if (i >= nums.length){
            return 0;
        }

        if (cache[i] != -1){
            return cache[i];
        }

        cache[i] = Math.max(dfs(nums, i + 1, cache),
                         nums[i] + dfs(nums, i + 2, cache));
        return cache[i];
    }
}

// Dynamic Programming (Top-Down)
// Time Complexity: O(n)
// Space Complexity : O(n)