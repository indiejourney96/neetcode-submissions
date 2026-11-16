class Solution {
    public void sortColors(int[] nums) {

        // Count the occurrences of each color
        int[] count = new int[3];
        for (int num : nums) {
            count[num]++;
        }

        // Overwrite the array with all 0s
        int index = 0;

        // Overwrite the array with 0s first, followed by 1s and 2s
        for (int i = 0; i < 3; i++) {
            while (count[i] > 0) {
                nums[index] = i;
                index++;
                count[i]--;
            }
        }
    }
}

// Counting Sort
// Time Complexity: O(n)
// Space Complexity: O(1)

// 1. Count — Count the number of 0s, 1s and 2s.
// 2. Overwrite — Fill the array with 0s.
// 3. Continue — Fill the remaining positions with 1s, then 2s.
