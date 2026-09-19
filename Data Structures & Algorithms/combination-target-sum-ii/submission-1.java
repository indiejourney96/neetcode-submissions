class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, 0, cur, res, target);
        return res;
    }
    
    public void backtrack(int[] candidates, int i, List<Integer> cur, List<List<Integer>> res, int target){
        if (target == 0){
            res.add(new ArrayList<>(cur));
            return ;
        }

        if (target < 0 || i >= candidates.length){
            return ;
        }

        cur.add(candidates[i]);

        backtrack(candidates, i + 1, cur, res, target - candidates[i]);

        cur.remove(cur.size() - 1);

        while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]){
            i++;
        }

        backtrack(candidates, i + 1, cur, res, target);
    }
}
