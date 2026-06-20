public class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        /*
         STEP 1: Count frequency of each number
         Example:
         nums = [1,1,1,2,2,3]
         count:
         1 -> 3
         2 -> 2
         3 -> 1
        */
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {

            // If number already exists, increase its frequency
            if (count.containsKey(num)) {
                count.put(num, count.get(num) + 1);
            } 
            // Otherwise start frequency at 1
            else {
                count.put(num, 1);
            }
        }

        /*
         STEP 2: Create buckets
         freq[i] = list of numbers that appear i times

         Example:
         freq[3] = [1]
         freq[2] = [2]
         freq[1] = [3]
        */
        List<Integer>[] freq = new List[nums.length + 1];

        // initialize each bucket
        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        /*
         STEP 3: Fill buckets manually (no Map.Entry)
        */
        for (int key : count.keySet()) {

            int frequency = count.get(key);
            int number = key;

            freq[frequency].add(number);
        }

        /*
         STEP 4: Collect top K frequent elements
         Start from highest frequency bucket
        */
        int[] res = new int[k];
        int index = 0;

        for (int i = freq.length - 1; i > 0; i--) {

            for (int num : freq[i]) {

                res[index] = num;
                index++;

                // stop once we have k elements
                if (index == k) {
                    return res;
                }
            }
        }

        return res;
    }
}