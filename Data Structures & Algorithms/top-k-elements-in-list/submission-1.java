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

            if (count.containsKey(num)) {
                count.put(num, count.get(num) + 1);
            } 
            else {
                count.put(num, 1);
            }
        }

        /*
         STEP 2: Create buckets
         freq[i] = list of numbers that appear i times

        Example:
        Frequency map:
        0 ──► []
        1 ──► []
        ....
        3 ──► []
        */
        List<Integer>[] freq = new List[nums.length + 1]; // Create an array that can hold List<Integer> objects

        // Create an empty list for each element
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

//Time complexity: O(n)
//Space complexity: O(n)

// My solution uses a HashMap and bucket sort. 
// First, I count the frequency of every number using a HashMap, 
// so I have mappings like 1 -> 3, 2 -> 2, and 3 -> 1. 
// The key observation is that a number's frequency can never exceed nums.length, 
// so instead of sorting by frequency, I create an array of lists where the index represents 
// the frequency. For each (number, frequency) pair in the map, I place the number into freq[frequency].
// This effectively groups numbers by how often they appear. 
// Finally, I iterate through the bucket array from the highest frequency down,
// adding numbers to the result until I've collected k elements. 
// This avoids sorting entirely, giving a time complexity of O(n) and a space complexity of O(n)