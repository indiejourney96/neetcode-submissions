class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>(); 
        Arrays.sort(nums);

        for (int i = 0 ; i < nums.length ; i++){
            if(nums[i] > 0) break; //Since num > 0, others also > 0
            if (i > 0 && nums[i] == nums[i - 1]) continue; //skip duplicates
            int l = i + 1; int r = nums.length - 1;
            while (l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if (sum > 0){
                    r--;
                } else if (sum < 0){
                    l++;
                } else {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++; r--;
                    while (l < r && nums[l] == nums[l - 1]){
                    l++; //Skip duplicate left values
                    }
                    while (l < r && nums[r] == nums[r + 1]){
                    r--; //Skip duplicate right values
                    } 
                } 
            }
        }
        return res;
    }
}

// Time Complexity: O(n²)
// Space Complexity: O(1) excluding the output list
// (or O(log n) depending on the sorting algorithm implementation)