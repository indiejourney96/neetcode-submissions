class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        boolean[] used = new boolean[nums.length]; //used = [false, false, false] if nums = [1,2,3]: prevent duplicates

        backtrack(nums, cur, used, res);
        return res;
    }

    private void backtrack(int[] nums, List<Integer> cur, boolean[] used, List<List<Integer>> res) {
        // Base case: if current permutation has all numbers
        if (cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }

        // Try every number for the current position
        for (int i = 0; i < nums.length; i++) {
            // Skip numbers already used in this permutation
            if (used[i]) continue;

            // Choose nums[i]
            cur.add(nums[i]);
            used[i] = true;

            // Explore next position
            backtrack(nums, cur, used, res);

            // Undo choice
            cur.remove(cur.size() - 1);
            used[i] = false;
        }
    }
}

//Backtracking
//Time Complexity: O(n! * n)
//Space Complexity: O(n! * n)

//I use standard backtracking. Since permutations require using every number exactly once and order matters, I keep a used array. At each position, I try every number that hasn’t been used yet, add it to the current list, recurse, then undo the choice. When the current list size equals nums.length, I add it to the result.
