class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();

        backtrack(nums, 0, cur, res, target);
        return res;
    }

    public void backtrack(int[] nums, int i, List<Integer> cur, List<List<Integer>> res, int target){
        if (target == 0){
            res.add(new ArrayList<>(cur));
            return ;
        }

        if (target < 0 || i >= nums.length){
            return ;
        }

        cur.add(nums[i]);

        backtrack(nums, i, cur, res, target - nums[i]);

        cur.remove(cur.size() - 1);

        backtrack(nums, i + 1, cur, res, target);
    }
}
