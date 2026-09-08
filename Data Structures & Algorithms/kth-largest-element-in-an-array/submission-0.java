class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}

//Sorting
//Time Complexity: O(n log n)
//Space Complexity: 0(n) or O(1) depending on the sorting algo