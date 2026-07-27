class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> count = new HashMap<>(); // HashMap<Number, Frequency>

        for (int num : nums){ // Count frequency of each number
            if(count.containsKey(num)){
                count.put(num , count.get(num) + 1);
            } else {
                count.put(num, 1);
            }
        }
        List<int[]> arr = new ArrayList<>(); //Store the HashMap into a sortable list

        for (int key : count.keySet()){
            arr.add(new int[] {count.get(key), key}); // Store as [frequency, actual number]
        }

        // Sort by frequency descending (highest frequency first)
        // b[0] = frequency of b
        // a[0] = frequency of a
        arr.sort((a,b) -> Integer.compare(b[0], a[0]));

        int[] res = new int[k]; 

        for ( int i = 0 ; i < k ; i++){
            res[i] = (arr.get(i)[1]);   
        // arr.get(i)[1] = actual number      
        // arr.get(i)[0] = frequency
        }
        return res;
    }
}

//Time complexity: O(n log n)
//Space complexity: O(n)