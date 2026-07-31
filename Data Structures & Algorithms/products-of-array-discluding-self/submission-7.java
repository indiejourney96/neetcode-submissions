class Solution {
        public int[] productExceptSelf(int[] nums) {
                int n = nums.length; 
                        int[] res = new int[n];

                                // Prefix products
                                        res[0] = 1;
                                                for (int i = 1; i < n; i++){
                                                            res[i] = res[i - 1] * nums[i - 1];
                                                                    }

                                                                            // Postfix products
                                                                                    int postfix = 1;
                                                                                            for (int i = n - 1; i >= 0 ; i--){
                                                                                                        res[i] = res[i] * postfix; 
                                                                                                                    postfix = postfix * nums[i];
                                                                                                                            }
                                                                                                                                    return res; 
                                                                                                                                        }
                                                                                                                                    }  

                                                                                                                                        //Time Complexity: O(n)
                                                                                                                                        //Space Complexity: O(1)

                                                                                                                                        //For each index, we need the product of all elements to the left and all elements to the right. 
                                                                                                                                        //I first store the left products directly in the result array. 
                                                                                                                                        //Then I traverse from right to left while maintaining a running postfix product. 
                                                                                                                                //Multiplying the stored prefix product by the current postfix product gives the answer for each index. 
                                                                //This avoids allocating a separate suffix array, reducing the extra space from O(n) to O(1).
