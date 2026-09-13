class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        
        Arrays.sort(candidates); // Sort so duplicates are next to each other
        
        backtrack(candidates, 0, cur, target, res);

        return res;
    }

    public void backtrack(int[] candidates, int index, List<Integer> cur, int target, List<List<Integer>> res){
        // Found a valid combination
        if (target == 0){
            res.add(new ArrayList<>(cur));
            return;
        }

        // Stop if target is negative or index is out of bounds
        if (target < 0 || index >= candidates.length){ 
            return ;
        }

        cur.add(candidates[index]);

        // Choice 1: include current number
        backtrack(candidates, index + 1, cur, target - candidates[index], res);

        cur.remove(cur.size() - 1);

        // Skip duplicates before the "exclude" branch
        while (index + 1 < candidates.length && candidates[index] == candidates[index + 1]) {
            index++;
        }

        // Choice 2: exclude current number and its duplicates
        backtrack(candidates, index + 1, cur, target, res);
    }
}

//Backtracking 
//Time Complexity: O(n * 2^n)
//Space Complexity: O(n)


// I sort the array first so duplicates are adjacent. At each index I either include the current number or skip it. The important part is that before the skip branch, I skip all duplicate values, so I don’t generate the same combination multiple times.