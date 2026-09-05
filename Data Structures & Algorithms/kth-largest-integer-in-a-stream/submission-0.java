class KthLargest {
    List<Integer> arr; //store all number
    int K; //store k

    public KthLargest(int k, int[] nums) {
        K = k;
        arr = new ArrayList<>();

        //Store all existing numbers
        for (int i = 0; i < nums.length; i++){
            arr.add(nums[i]);
        }
    }
    
    public int add(int val) {
        arr.add(val); //add new number

        Collections.sort(arr);
        
        //return kth largest from end
        return arr.get(arr.size() - K);
    }
}


//Brute Force
//Time complexity: O(n log n) per add() due to sort function 
//Space complexity: O(n)