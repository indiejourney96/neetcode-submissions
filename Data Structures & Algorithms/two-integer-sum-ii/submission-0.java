class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0; int r = numbers.length - 1;
        int[] ans = new int[2];

        if (numbers.length == 2){
            ans[0] = 1;
            ans[1] = 2;
        }
        
        
        while (l < r){
            if ((numbers[l] + numbers[r]) > target){
                r--;
            }
            if ((numbers[l] + numbers[r]) < target){
                l++;
            }
            if (numbers[l] + numbers[r] == target){
            ans[0] = l+1;
            ans[1] = r+1;
            break;
            }
        }
        return ans;
    }
}
