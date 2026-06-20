class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> count = new HashMap<>();

        for (int num : nums) {
            if (count.containsKey(num)) {
                count.put(num, count.get(num) + 1);
            } else {
                count.put(num, 1); 
            }
        }

        List<int[]> arr = new ArrayList<>();

        for (int key : count.keySet()) {
            arr.add(new int[] {count.get(key), key});
        }

        arr.sort((a, b) -> Integer.compare(b[0], a[0]));

        int[] res = new int[k];

        for (int i = 0; i < k; i++) {
            res[i] = arr.get(i)[1];
        }

        return res;
    }
}