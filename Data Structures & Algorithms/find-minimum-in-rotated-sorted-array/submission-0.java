class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int min = nums[0];

        while (l <= r) {
            // Entire search range is sorted
            if (nums[l] <= nums[r]) {
                min = Math.min(min, nums[l]);
                break;
            }

            int mid = l + (r - l) / 2;
            min = Math.min(min, nums[mid]);

            // Left half is sorted
            if (nums[mid] >= nums[l]) {
                l = mid + 1;
            }
            // Right half is sorted
            else {
                r = mid - 1;
            }
        }

        return min;
    }
}