class MedianFinder {
    // Max-heap: stores smaller half (largest element on top)
    private PriorityQueue<Integer> smallHeap;

    // Min-heap: stores larger half (smallest element on top)
    private PriorityQueue<Integer> largeHeap;

    public MedianFinder() {
        smallHeap = new PriorityQueue<>(Collections.reverseOrder()); // max-heap
        largeHeap = new PriorityQueue<>(); // min-heap   
    }
    
    public void addNum(int num) {
    // Step 1: Add the number to the max-heap (smallHeap)
    smallHeap.add(num);

    // Step 2: Balance the heaps
    // Check if smallHeap has more than one extra element than largeHeap
    if (
        smallHeap.size() - largeHeap.size() > 1 ||  // Case 1: too many elements in smallHeap
        (!largeHeap.isEmpty() &&                    // Case 2: If largeHeap is not empty,
         smallHeap.peek() > largeHeap.peek())       // and the largest in smallHeap is greater than smallest in largeHeap
    ) {
        // Move the top element from smallHeap (the largest of the smaller half)
        // to largeHeap (the smallest of the larger half)
        largeHeap.add(smallHeap.poll());
    }

    // Step 3: Further balance if largeHeap has more than one extra element
    if (largeHeap.size() - smallHeap.size() > 1) {
        // Move the top element from largeHeap to smallHeap
        // (the smallest of the larger half goes to the smaller half)
        smallHeap.add(largeHeap.poll());
    }
    }
    
    public double findMedian() {
        if (smallHeap.size() > largeHeap.size()) return smallHeap.peek();
        if (largeHeap.size() > smallHeap.size()) return largeHeap.peek();
        return (smallHeap.peek() + largeHeap.peek()) / 2.0;
    }
}

//Sorting 
// addNum(num):     O(log n)
// findMedian():    O(1)  — sorts every time
// Space:           O(N)
