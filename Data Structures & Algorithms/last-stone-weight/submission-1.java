class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); //need to add collections.xx for maxHeap

        for (int stone :stones){
            maxHeap.offer(stone);
        }

        //Keep smashing the 2 largest stones
        while (maxHeap.size() > 1){
            //Get 2 largest stones
            int first = maxHeap.poll();
            int second = maxHeap.poll();
            
            //If diff, add the diff back
            if (first != second){
                maxHeap.offer(first - second);
            }
        }
        //If no stones remain, return 0
        if (maxHeap.isEmpty()){
            return 0;
        }

        return maxHeap.peek();
    }
}

//Brute Force 
//Time complexity: O(n log n)
//Space complexity: O(n)

//I use a max heap because I repeatedly need the two largest stones. I remove the two largest stones, and if they are different, I add their difference back into the heap. Each heap operation takes O(log n), so the overall complexity is O(n log n), with O(n) space.