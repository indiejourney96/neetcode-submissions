class Solution {
    public int findDuplicate(int[] nums) {
        // Use Floyd's slow and fast pointers
        int slow = 0 , fast = 0; 
        
        // Find a meeting point inside the cycle
        while (true){
            slow = nums[slow]; //move by 1
            fast = nums[nums[fast]]; //move by 2
            if (slow == fast){
                break;
            }
        }

        // Start another pointer from the beginning
        int slow2 = 0; 
        while (true){
            slow = nums[slow];
            slow2 = nums[slow2];
        }
    }
}
