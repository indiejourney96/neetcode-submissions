class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] ans = new int[nums.length - k + 1];

        Deque<Integer> deque = new ArrayDeque<>();

        int index = 0;

        for (int i = 0; i < nums.length; i++) {

            // Remove indices outside current window
            if (!deque.isEmpty() &&
                deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Remove smaller values
            while (!deque.isEmpty() &&
                   nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // Add current index
            deque.offerLast(i);

            // Window formed
            if (i >= k - 1) {
                ans[index++] = nums[deque.peekFirst()];
            }
        }

        return ans;
    }
}