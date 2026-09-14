class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, subset, res);
        return res;
    }

    public void backtrack(int[] nums, int index, List<Integer> subset, List<List<Integer>> res){
        if (index == nums.length){
            res.add(new ArrayList<>(subset));
            return ;
        }

        subset.add(nums[index]);

        backtrack(nums, index + 1, subset, res);

        subset.remove(subset.size() - 1);

        while (index + 1 < nums.length && nums[index] == nums[index + 1]){
             index++; //prevents duplicate subsets - duplicate [[1,1,2],[1,1],[1,2],[1],[1,2],[1],[2],[]]
        }

        backtrack(nums, index + 1, subset, res);
    }
}

//Backtracking 
//Time Complexity: O(n * 2^n)
//Space Complexity: O(n) extra space, O(2^n) space for output list
