class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        Set<List<Integer>> ans = new HashSet<>();   
        for (int i = 0; i < nums.length; i++){
            for (int j = i + 1; j < nums.length; j++){
                for (int k = j + 1; k < nums.length; k++){
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> tmp = Arrays.asList(nums[i], nums[j], nums[k]);
                        //Alternative way of writing: 
                        // List<Integer> tmp = new ArrayList<>();
                        // tmp.add(nums[i]);
                        // tmp.add(nums[j]);
                        // tmp.add(nums[k]);
                        ans.add(tmp);
                    }
                }
            }
        }
        return new ArrayList<>(ans);

        //Alternative way of writing: 
        // List<List<Integer>> result = new ArrayList<>();
        // result.addAll(ans);
        // return result;
    }
}
