class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int stone : stones){
            maxHeap.add(stone);
        }

        while(maxHeap.size() > 1){
            int stone1 = maxHeap.poll();
            int stone2 = maxHeap.poll();

            maxHeap.add(stone1-stone2);
        }
        if (maxHeap.isEmpty()){
            return 0;
        }
        return maxHeap.peek();
    }
}

//Brute Force 
//Time complexity: O(n2 log n)
//Space complexity: O(n)
