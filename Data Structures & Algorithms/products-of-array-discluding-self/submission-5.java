class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0 ; i < nums.length ; i++){
            res[i] = 1;
            for (int j = 0 ; j < nums.length ; j++){
                
                if (j != i){
                    res[i] = res[i] * nums[j]; 
                }
            }
        }
        return res;
    }
}  

//Time complexity = O(n2)
//Space complexity = O(1)