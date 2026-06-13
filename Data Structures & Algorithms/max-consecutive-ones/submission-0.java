class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0 ; i < n ; i++){
            int count = 0; 
            for (int j = i ; j < n; j++){
                if (nums[j] == 0) break;
                count++;
            }
            ans = Math.max(ans,count);
        }
        return ans;
    }
}