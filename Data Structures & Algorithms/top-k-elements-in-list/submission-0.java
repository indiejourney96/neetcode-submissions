class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // HashMap<Number, Frequency>
        // Example:
        // nums = [1,1,1,2,2,3]
        // count = {1=3, 2=2, 3=1}
        Map<Integer, Integer> count = new HashMap<>();

        // Count frequency of each number
        for (int num : nums) {
            if (count.containsKey(num)) {
                count.put(num, count.get(num) + 1);
            } else {
                count.put(num, 1);
            }
        }

        // Convert HashMap into a sortable list
        // Store as [frequency, number]
        // Example:
        // {1=3, 2=2, 3=1}
        // ->
        // [[3,1], [2,2], [1,3]]
        List<int[]> arr = new ArrayList<>();

        for (int key : count.keySet()) {
            arr.add(new int[] {count.get(key), key});
        }

        // Sort by frequency descending (highest frequency first)
        // b[0] = frequency of b
        // a[0] = frequency of a
        // Example after sort:
        // [[3,1], [2,2], [1,3]]
        arr.sort((a, b) -> Integer.compare(b[0], a[0]));

        int[] res = new int[k];

        // Take the first k numbers after sorting
        // arr.get(i)[1] = actual number
        // arr.get(i)[0] = frequency
        for (int i = 0; i < k; i++) {
            res[i] = arr.get(i)[1];
        }

        return res;
    }
}