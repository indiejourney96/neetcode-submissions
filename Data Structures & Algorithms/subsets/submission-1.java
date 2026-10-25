class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs(nums, 0,subset, result);
        return result;
    }

    public void dfs(int[] nums, int index, List<Integer> subset, List<List<Integer>> result){
        //Reached the end -> save subset
        if (index == nums.length){
            result.add(new ArrayList<>(subset));
            return;
        }

        //Choose: include nums[index]
        subset.add(nums[index]);

        dfs(nums, index + 1, subset, result);

        //Undo the choice
        subset.remove(subset.size() - 1);

        //Don't choose nums[index]
        dfs(nums, index + 1, subset, result);
    }
}

//Backtracking
//Time complexity: O(n x 2^n)
//Space complexity: O(n x 2^n)

//Since every number can either be included or excluded from a subset, I can use backtracking to explore both choices for each number."

//"For each number, I first choose to include it and recursively continue. Then I undo that choice and recursively explore the option where I don't include it."

//"When I've processed all the numbers, I have one complete subset, so I add a copy of it to the result."

//There are 2ⁿ possible subsets because each of the n numbers has two choices. Each subset can contain up to n elements, so the time complexity is O(n × 2ⁿ). The recursion uses O(n) space, excluding the output.

//Backtracking is suitable because I need to generate all possible combinations. I can make a decision for each element, explore that decision, then undo it before trying the other decision."