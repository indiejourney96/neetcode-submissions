class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];

        int curMax = 1;
        int curMin = 1;

        for (int num : nums) {

            // Handle negative numbers by swapping max and min
            if (num < 0) {
                int temp = curMax;
                curMax = curMin;
                curMin = temp;
            }

            // Calculate the maximum and minimum products
            curMax = Math.max(num, curMax * num);
            curMin = Math.min(num, curMin * num);

            // Update the overall maximum product
            res = Math.max(res, curMax);
        }

        return res;
    }
}

// Optimal DP
// Time Complexity: O(n)
// Space Complexity: O(1)

// For Maximum Product Subarray, always track both the maximum and minimum product ending at the current index because a negative number can turn the minimum into the maximum.