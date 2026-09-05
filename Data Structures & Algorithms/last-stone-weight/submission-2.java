class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int stone : stones){
            maxHeap.add(stone); //add all stones to list
        }

        //keep smashing stones until 0 or 1 remains
        while (maxHeap.size() > 1){
            //remove 2 largest stones
            int stone1 = maxHeap.poll();
            int stone2 = maxHeap.poll();
            if (stone1 > stone2){ //add diff
                maxHeap.add(stone1 - stone2);
            }
        }
        if (maxHeap.isEmpty()){
            return 0;
        }
        return maxHeap.peek();
    }
}

//Max Heap
//Time complexity: O(n log n)
//Space complexity: O(n)

//I use a max heap because I repeatedly need the two largest stones. I remove the two largest stones, and if they are different, I add their difference back into the heap. Each heap operation takes O(log n), so the overall complexity is O(n log n), with O(n) space.