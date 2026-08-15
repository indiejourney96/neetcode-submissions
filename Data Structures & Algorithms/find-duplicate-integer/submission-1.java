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
        // Move both pointers one step at a time
        // They will meet at the start of the cycle
        while (true){
            slow = nums[slow];
            slow2 = nums[slow2];
            if (slow == slow2){
                return slow;
            }
        }
    }
}

//Linked List - Floyd detection cycle 
//Time complexity: O(n)
//Space complexity: O(1)

//I can treat the array like a linked list, where the index is the current node and nums[index] tells me the next node. Because there are n + 1 values but only values from 1 to n, there must be a duplicate. That duplicate causes two positions to point to the same index, which creates a cycle. So I can use Floyd's cycle detection algorithm to find the cycle entrance, which gives me the duplicate number."