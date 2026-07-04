class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        Map<Integer,Integer> seen = new HashMap<>();
        for (int i = 0 ; i < nums.length ; i++){
            int diff = target - nums[i];
            if(seen.containsKey(diff)){
                ans[0] = seen.get(diff);
                ans[1] = i;
            }
            seen.put(nums[i], i);
        }

        return ans;
    }
}
