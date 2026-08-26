class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>(); //Set-to prevent duplicates
        Arrays.sort(nums);

        for (int i = 0 ; i < nums.length ; i++){
            for (int j = i + 1 ; j < nums.length ; j++){
                for (int k = j + 1 ; k < nums.length ; k++){
                    if (nums[i] + nums[j] + nums[k] == 0){
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[k]);
                        res.add(tmp);
                    }
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        ans.addAll(res);
        return ans;
    }
}

//Time complexity: O(n3)
//Space complexity: O(m) + space used by sorting algo

//n = length of the given array.
//m = number of unique triplets