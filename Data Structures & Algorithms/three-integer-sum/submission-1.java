class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); //Two pointers only work on a sorted array

        List<List<Integer>> ans = new ArrayList<>();

        // Fix the first number
        for (int i = 0; i < nums.length; i++){
            if (nums[i] > 0) break; // Since the first num > 0, others also > 0
            if (i > 0 && nums[i] == nums[i - 1]) continue; //to skip duplicates

            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum > 0) {
                    r--;
                } else if (sum < 0) { 
                    l++;
                } else {
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));  // Found a valid triplet.
                    l++;
                    r--;
                    // Skip duplicate left values.
                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }
                    // Skip duplicate right values.
                    while (l < r && nums[r] == nums[r + 1]) {
                        r--;
                    }
                }
            }
        }
        return ans;
    }
}
