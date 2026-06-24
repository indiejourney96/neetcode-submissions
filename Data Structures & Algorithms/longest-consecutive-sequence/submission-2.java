class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> store  = new HashSet<>();
        for (int num : nums){
            store.add(num);
        }
        int res = 0; 

        for (int num : store){
            // Only start counting if num is the start of a sequence (num-1)
            // Example:
            // num = 1 -> start
            // num = 2 -> skip because 1 exists
            if (!store.contains(num-1)) {
                int streak = 1;
                int current = num;
                // Count consecutive numbers
                while (store.contains(current + 1)){
                    streak++;
                    current++;
                }
            res = Math.max(res, streak); 
            }
        }
        return res;
    }
}