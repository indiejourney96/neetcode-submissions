class KthLargest {
    private PriorityQueue<Integer>minHeap; // min heap store K largest number
    private int k; //which largest number we want

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();

        //Add initial numbers
        for (int num : nums){
            minHeap.offer(num);

            if (minHeap.size() > k){
                minHeap.poll(); //remove smallest
            }
        }
    }
    
    public int add(int val) {
        minHeap.offer(val); //add new number

        if (minHeap.size() > k){
            minHeap.poll(); //if have more than k numbers, remove smallest number
        }
        
        //return kth largest 
        return minHeap.peek();
    }
}


//Min Heap
//Time complexity: O(log k) per add()
//Space complexity: O(k)

//I use a min heap of size K. The heap keeps the K largest elements, and because it's a min heap, the smallest of those K elements is always at the top. Therefore, peek() gives me the Kth largest elemen