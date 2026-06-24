class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0; 
        Set<Integer> store = new HashSet<>();
        for (int num : nums){
            store.add(num); //Store all values in HashSet
        }

        for (int num : nums){
            int streak = 0, current = num; 
            while (store.contains(current)){
                streak++;
                current++; //to check for next consecutive value
            }
            res = Math.max(res,streak); //update the res if higher consective value exists
        }

    return res; 
    }
}
