class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();

        backtrack(nums, 0, cur, target, res);

        return res;    
    }

    public void backtrack(int[] nums, int index, List<Integer> cur, int target, List<List<Integer>> res){
        //Found a combination that adds up to target
        if (target == 0){
            res.add(new ArrayList<>(cur));
            return ;
        }

        // Invalid: Target exceeded or no numbers left
        if (target < 0 || index >= nums.length){
            return ;
        }

        // Choose nums[index]
        cur.add(nums[index]);

        // Use nums[index] again -> same index
        backtrack(nums, index, cur, target - nums[index], res);

        // Undo the choice
        cur.remove(cur.size() - 1);

        // skip nums[index]
        backtrack(nums, index + 1, cur, target, res);
    }
}

//Backtracking
//Time Complexity: O(2^(T/m)) Explore many possible combinations
//Space Complexity: O(T/m)  Recursion depth + cur


//"I'll use backtracking because I need to generate all possible combinations that sum to the target."
//"At each number, I have two choices: use the current number or skip it."
//"If I use the number, I keep the same index because the same number can be reused."
//"If I skip it, I move to i + 1."
//"When the target becomes zero, I've found a valid combination and add a copy of it to the result."
//"If the target becomes negative or I run out of numbers, I stop that branch."


//"The time complexity is exponential, approximately O(2^(T/m)), where T is the target and m is the smallest candidate. This is because we explore two choices at each level: either use the current number or skip it.The auxiliary space is O(T/m) because that's the maximum recursion depth and the maximum size of the current combination
