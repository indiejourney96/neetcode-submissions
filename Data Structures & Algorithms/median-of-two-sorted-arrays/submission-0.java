class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = new int[nums1.length + nums2.length];

        int index = 0; 
        double ans = 0;

        //Copy num1 
        for (int num : nums1){
            merged[index++] = num;
        }

        //Copy num2
        for (int num : nums2){
            merged[index++] = num;
        }

        Arrays.sort(merged);

        int n = merged.length;

        //Odd length 
        if (n % 2 == 1){
            ans = merged[n / 2];
        } 
        else if (n % 2 == 0) { //Even length
            ans = (merged[n / 2 - 1] + merged[n / 2]) / 2.0;
        }
        
        return ans;
    }
}

//Time Complexity: O((m+n) log(m+n))
//Space complexity: O(n+m)O(n+m)


//Create bigger array -> Copy 1st and 2nd array
//Sort and Find median

//The problem explicitly requires O(log(m+n)), 
//So I need a fundamentally different approach. 
//Instead of constructing the merged array, 
//I'll binary search for the correct partition between the two arrays
