class Solution {
    public void rotate(int[] nums, int k) {

        int n = nums.length;

        // Handle cases where k is greater than the array length
        k = k % n;

        // Step 1: Reverse the entire array
        reverse(nums, 0, n - 1);

        // Step 2: Reverse the first k elements
        reverse(nums, 0, k - 1);

        // Step 3: Reverse the remaining elements
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int left, int right) {

        while (left < right) {

            // Swap the left and right elements
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }
}


// Three-Reversal Approach
// Time Complexity: O(n)
// Space Complexity: O(1)