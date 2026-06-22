class Solution {
    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] res = new int[n];

        /*
         Build PREFIX products directly into res

         nums = [1,2,3,4]
         res:
         [1,1,2,6]

         res[i] = product of all elements LEFT of i
        */
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        /*
         postfix = product of all elements RIGHT of i
         Traverse from right to left and combine:
         answer = left product * right product
        */
        int postfix = 1;

        for (int i = n - 1; i >= 0; i--) {
            // Multiply prefix product by suffix product
            res[i] *= postfix;
            // Update suffix product for next iteration
            postfix *= nums[i];
        }

        return res;
    }
}