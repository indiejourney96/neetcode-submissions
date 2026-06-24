class Solution {
    public int longestConsecutive(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int streak = 1;
        int ans = 1;

        for (int i = 1; i < nums.length; i++) {

            // Skip duplicates
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            // Consecutive number
            if (nums[i] == nums[i - 1] + 1) {
                streak++;
            }
            // Sequence broken
            else {
                streak = 1;
            }
            ans = Math.max(ans, streak);
        }

        return ans;
    }
}