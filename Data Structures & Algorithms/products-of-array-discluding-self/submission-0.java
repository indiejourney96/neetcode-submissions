class Solution {
    public int[] productExceptSelf(int[] nums) {

        int zeroCount = 0;
        int product = 1;

        // Product of all NON-ZERO numbers
        for (int num : nums) {
            if (num == 0) {
                zeroCount++;
            } else {
                product *= num;
            }
        }

        int[] ans = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {

            // More than one zero
            if (zeroCount > 1) {
                ans[i] = 0;
            }

            // Exactly one zero
            else if (zeroCount == 1) {

                if (nums[i] == 0) {
                    ans[i] = product;
                } else {
                    ans[i] = 0;
                }
            }

            // No zeros
            else {
                ans[i] = product / nums[i];
            }
        }

        return ans;
    }
}