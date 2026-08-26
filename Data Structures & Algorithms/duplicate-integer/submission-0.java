class Solution {
    public boolean hasDuplicate(int[] nums) {
        int n = nums.length; 
        for (int i = 0; i < n; i++){
            for (int j = 1; j < n; j++){
                if (nums[i] == nums[j]){
                    return false;
                }
            }
        }
        return true;
    }
}