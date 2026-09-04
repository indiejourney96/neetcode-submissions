class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1; 
        int right = 0; 
        for (int pile : piles){
            right = Math.max(pile, right);
        }

        int result = right; //Store min valid speed found

        while (left <= right){
            int mid = left + (right - left)/2 ;

            if (canFinish(piles, h, mid)){
                result = mid; //valid speed found
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    public boolean canFinish(int[] piles, int h, int k){
        int totalHours = 0;
        for (int pile : piles){
            totalHours += (pile + k - 1) / k;
        }

        return totalHours <= h;
    }
}

//Binary Search 
//Time Complexity: O(n log m), where n is the number of piles  m = max(piles)
//Space Complexity: O(1).