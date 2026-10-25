class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> cur = new ArrayList<>();

        Arrays.sort(candidates);
        dfs(candidates, 0, target, cur, result);

        return result;
    }

    public void dfs(int[] candidates, int index, int target, List<Integer> cur, List<List<Integer>> result){
        if (target == 0){
            result.add(new ArrayList<>(cur));
            return ;
        }

        if (target < 0 || index >= candidates.length){
            return ;
        }

        cur.add(candidates[index]);

        dfs(candidates, index + 1, target - candidates[index], cur, result);

        cur.remove(cur.size() - 1);

        while (index + 1 < candidates.length && candidates[index] == candidates[index + 1]){
            index++;
        }

        dfs(candidates, index + 1, target, cur, result);
    }
}
