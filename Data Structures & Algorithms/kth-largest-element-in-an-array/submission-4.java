class Solution {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k; 
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    public int quickSelect(int[] nums, int left, int right, int k){
        int pivot = nums[right];
        int p = left;

        for(int i = left; i < right; i++){
            if (nums[i] <= pivot){
                int temp = nums[p];
                nums[p] = nums[i];
                nums[i] = temp;

                p++;
            }
        }

        int temp = nums[p];
        nums[p] = nums[right];
        nums[right] = temp;

        if (p > k){
            return quickSelect(nums, left, p - 1, k);
        }

        if (p < k){
            return quickSelect(nums, p + 1,right, k);
        }
    return nums[p];
    }
}
