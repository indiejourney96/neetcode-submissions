class Solution {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k; // Convert kth largest into an index
        
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    public int quickSelect(int[] nums, int left, int right, int k){
        int pivot = nums[right]; //choose last element as pivot
        int p = left; //position where smaller elements should go

        for (int i = left; i < right; i++){
            if (nums[i] <= pivot){
                int temp = nums[p];
                nums[p] = nums[i];
                nums[i] = temp;

                p++;
            }
        }

        //Put pivot in its correct position
        int temp = nums[p];
        nums[p] = nums[right];
        nums[right] = temp;

        //Search the left side
        if (p > k){
            return quickSelect(nums, left, p - 1, k);
        }

        //Search the right side
        if (p < k){
            return quickSelect(nums, p + 1, right, k);
        }

        //Pivot is at the target index
        return nums[p];
    }
}

//Quick Select
//Time Complexity: O(n) in average case, O(n2) in worst case
//Space Complexity: 0(1) 

//QuickSelect has average O(N) time, but choosing a poor pivot repeatedly can lead to O(N²). A randomized pivot can reduce the likelihood of that worst case.

// Convert to ascending index
// nums.length - k
//      ↓
// Choose pivot
//      ↓
// Partition array
//      ↓
// Check pivot index
//      ↓
// p > k → search left
// p < k → search right
// p == k → answer