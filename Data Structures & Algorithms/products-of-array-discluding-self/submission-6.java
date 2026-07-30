class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int zeroCount = 0; 
        int product = 1;

        for (int i = 0 ; i < nums.length ; i++){
            if (nums[i] == 0){
                zeroCount++;
            } else {
                product = product * nums[i];
            }
        }

        for (int i = 0 ; i < nums.length ; i++){
            if (zeroCount == 2){
                res[i] = 0; 
            }
        }

        for (int i = 0 ; i < nums.length ; i++){
            if (zeroCount == 1){
                if (nums[i] == 0){
                    res[i] = product;
                } else {
                    res[i] = 0;
                }
            }

            if (zeroCount == 0){
                res[i] = product/nums[i];
            }
        }
        return res;
    }
}  

//Time complexity = O(n)
//Space complexity = O(1)