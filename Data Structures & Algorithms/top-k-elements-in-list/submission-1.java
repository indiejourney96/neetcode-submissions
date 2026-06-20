public class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // Step 1: Count frequency of each number
        // Example:
        // nums = [1,1,1,2,2,3]
        // count = {1=3, 2=2, 3=1}
        Map<Integer, Integer> count = new HashMap<>();

        // Step 2: Create "buckets"
        // freq[i] = list of numbers that appear exactly i times
        // Index = frequency, Value = list of numbers
        //
        // Example after building:
        // freq[3] = [1]
        // freq[2] = [2]
        // freq[1] = [3]
        List<Integer>[] freq = new List[nums.length + 1];

        // Initialize each bucket list
        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        // Build frequency map
        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        // Place numbers into their frequency bucket
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int number = entry.getKey();
            int frequency = entry.getValue();

            freq[frequency].add(number);
        }

        // Step 3: Collect results starting from highest frequency
        int[] res = new int[k];
        int index = 0;

        // Go from high frequency -> low frequency
        for (int i = freq.length - 1; i > 0 && index < k; i--) {

            // Add all numbers in this frequency bucket
            for (int n : freq[i]) {
                res[index++] = n;

                // Stop early once we have k elements
                if (index == k) {
                    return res;
                }
            }
        }

        return res;
    }
}