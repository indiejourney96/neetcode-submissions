class Solution {
    public int leastInterval(char[] tasks, int n) {
        // Step 1: Count frequency of each task (A=0, B=1, ... Z=25)
        int[] count = new int[26];
        for (char task : tasks){
            count[task - 'A']++;
        }

        // Step 2: Max-heap — always process the most frequent task first
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int cnt : count){
            if (cnt > 0){ //only add count > 0
                maxHeap.add(cnt);
            }
        }

        int time = 0;

        // Cooldown queue stores [remaining_count, time_when_available]
        Queue<int[]> q = new LinkedList<>();
        
        // Keep going until both heap and cooldown queue are empty
        while (!maxHeap.isEmpty() || !q.isEmpty()){
            time++;

            if (maxHeap.isEmpty()){
                // No task available — CPU is idle - Jump time forward to when the next task is ready (avoids counting idle time one by one)
                time = q.peek()[1];
            } else {
                int cnt = maxHeap.poll() - 1; // Run the most frequent available task
                // If this task still has remaining count, add it to cooldown queue
                // It becomes available again at time + n
                if (cnt > 0){
                    q.add(new int[]{cnt, time + n});
                }
            }
            // Check if the front of the cooldown queue is ready to run again
            if (!q.isEmpty() && q.peek()[1] == time){
                maxHeap.add(q.poll()[0]);
            }
        }

        return time;
    }
}

//MaxHeap
// TIME COMPLEXITY:  O(m)
//   where m is the number of tasks
//
// SPACE COMPLEXITY: O(1)
//   - count array is fixed size 26
//   - heap and queue hold at most 26 unique tasks
//   - effectively O(1) since task types are bounded by alphabet size

//I count task frequencies and use a max-heap to always run the most frequent task first — this greedy choice minimizes idle time. After running a task, I put it in a cooldown queue with the earliest time it can run again. Each tick I either run a task or jump time forward to when the next task is available. This avoids counting idle time one by one and keeps it efficient
