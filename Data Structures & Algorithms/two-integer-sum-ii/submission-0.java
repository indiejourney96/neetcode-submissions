class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1; 
        int[] ans = new int[2];

        while ( l < r){
            if (numbers[l] + numbers[r] > target){
                r--;
            }
            if (numbers[l] + numbers[r] < target){
                l++;
            }
            if (numbers[l] + numbers[r] == target){
                ans[0] = l + 1;
                ans[1] = r + 1;
                break;
            }
        }
        return ans;
    }
}

//Time Complexity: O(n)
//Space Complexity: O(1)