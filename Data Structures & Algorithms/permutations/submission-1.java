class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        backtrack(nums, cur, used, res);
        return res;
    }

    private void backtrack(int[] nums, List<Integer>cur, boolean[] used, List<List<Integer>> res){
        if (cur.size() == nums.length){
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = 0; i < nums.length; i++){
            if (used[i]) continue;

            cur.add(nums[i]);
            used[i] = true;

            backtrack(nums,cur,used,res);

            cur.remove(cur.size() - 1);
            used[i] = false;
        }
    }
}
