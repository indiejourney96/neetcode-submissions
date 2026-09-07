class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
         // Min Heap: point with the smallest distance is at the top
         //Create a Min Heap of integer arrays, and compare them using the first value (dist) in the array.
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparing(a -> a[0]));
        
        // Calculate distance for every point
        for (int[] point : points){
            int dist = point[0] * point[0] + point[1] * point[1];
            minHeap.offer(new int[]{dist, point[0], point[1]});
        }

        int[][] result = new int [k][2];
        // Get the K closest points
        for (int i = 0 ; i < k; i++){
            int[] point = minHeap.poll();
            // point[0] = distance
            // point[1] = x
            // point[2] = y
            result[i] = new int[]{point[1], point[2]};
        }
        return result;
    }
}

//Min heap 
//Time Complexity: O(n  + k log n)
//Space Complexity: O(n)

//Distance = sqrt((x1 - x2)^2 + (y1 - y2)^2))
//Distance^2 = (x1 - x2)^2 + (y1 - y2)^2
//Distance^2 = (x1 - 0)^2 + (y1 - 0)^2
//Distance^2 = (x1)^2 + (y1)^2

//I use a min-heap to efficiently find the k closest points to the origin. I calculate the squared Euclidean distance for each point and insert it into the heap along with its coordinates. The heap ensures that the closest points are always at the top, and I extract the k closest by polling the heap k times. The squared distance avoids the need for expensive square root calculations while still allowing accurate sorting by distance.”