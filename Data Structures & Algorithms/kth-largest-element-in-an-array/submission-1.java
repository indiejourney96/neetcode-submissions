class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums){
            minHeap.offer(num);

            if (minHeap.size() > k){
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
}

//minHeap solution
//Time Complexity: O(n log k)
//Space Complexity: 0(k) 
//where n is length of array nums
//If (k) is small, this is much faster than sorting the whole array.