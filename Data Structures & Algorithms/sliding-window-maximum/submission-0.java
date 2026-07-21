class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];

        for (int i = 0 ; i <= nums.length - k; i++){
            int max = nums[i];
            for (int j = i ; j < i + k ; j++){
                max = Math.max(max, nums[j]);
            }
            ans[i] = max;
        }
        return ans;
    }
}


// The brute-force solution scans all k elements in every window, giving O(nk) time. 
// Instead, I can maintain a deque of candidate maximums in decreasing order. 
// Before adding a new element, 
// I remove smaller elements from the back because 
// they'll never become the maximum while the new, larger element is in the window. 
// I also remove indices from the front once they fall outside the current window. 
// The front of the deque is always the maximum for the current window, 
//so each element is added and removed at most once, giving O(n) time