class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0; 

        // Calculate the total sum of the array 
        for (int num : nums){
            total += num; 
        }

        // Odd total cannot be divided into two equal subsets
        if (total % 2 != 0){
            return false; 
        }

        // We only need to find a subset with half the total sum 
        int target = total / 2;

        // cache[index][target] stores previously calculated results
        // -1 = not calculated
        //  0 = false
        //  1 = true
        int[][] cache = new int[nums.length][target + 1];

        // Initialise every cache position to -1
        for (int i = 0; i < cache.length; i++) {
            for (int j = 0; j < cache[i].length; j++) {
                cache[i][j] = -1;
            }
        }

        return dfs(nums, 0, target, cache);
    }

    private boolean dfs(int[] nums, int index, int target, int[][] cache){
        // We found a subset with required sum 
        if (target == 0){
            return true;
        }

        // Reached the end without finding the target
        if (index == nums.length){
            return false;
        }

        // Return the previously calculated result if available
        if (cache[index][target] != -1){
            return cache[index][target] == 1;
        }

        // Option 1: Skip the current number 
        boolean skip = dfs(nums, index + 1, target, cache);

        // Option 2: Take current number
        boolean take = false; 

        if (nums[index] <= target){
            take = dfs(nums, index + 1, target - nums[index], cache);
        }

        // Store the result in the cache
        boolean result = take || skip;

        cache[index][target] = result ? 1 : 0;

        // Return true if either option finds a valid subset
        return result;
    }
}

// Top-Down DP (Memoization)
// Time Complexity: O(n x S)
// Space Complexity: O(n x S)

//n = number of elements.
//S = target sum (half of the total sum).
