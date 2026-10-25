class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs(nums, 0, subset, result);
        return result;
    }

    public void dfs(int[] nums, int index, List<Integer> subset, List<List<Integer>> result){
        if (index == nums.length){
            result.add(new ArrayList<>(subset));
            return ;
        }

        subset.add(nums[index]);

        dfs(nums, index + 1, subset, result);

        subset.remove(subset.size() - 1);

        dfs(nums,index + 1, subset, result);
    }
}
