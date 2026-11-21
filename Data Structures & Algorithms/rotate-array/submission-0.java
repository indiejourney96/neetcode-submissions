class Solution {
    public void rotate(int[] nums, int k) {

        int n = nums.length;

        // Handle cases where k is greater than the array length
        k = k % n;

        // Rotate the array one step to the right, k times
        for (int i = 0; i < k; i++) {

            // Store the last element
            int last = nums[n - 1];

            // Shift every element one position to the right
            for (int j = n - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }

            // Move the last element to the first position
            nums[0] = last;
        }
    }
}

// Brute Force
// Time Complexity: O(n*k)
// Space Complexity: O(1)