class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        int n = nums.length;

        // First number
        for (int i = 0; i < n - 3; i++) {

            // Skip duplicate first numbers
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Second number
            for (int j = i + 1; j < n - 2; j++) {

                // Skip duplicate second numbers
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int l = j + 1;
                int r = n - 1;

                while (l < r) {

                    // Use long to prevent integer overflow
                    long sum = (long) nums[i] + nums[j] + nums[l] + nums[r];

                    if (sum > target) {
                        r--;

                    } else if (sum < target) {
                        l++;

                    } else {
                        res.add(Arrays.asList(
                            nums[i], nums[j], nums[l], nums[r]
                        ));

                        l++;
                        r--;

                        // Skip duplicate left values
                        while (l < r && nums[l] == nums[l - 1]) {
                            l++;
                        }

                        // Skip duplicate right values
                        while (l < r && nums[r] == nums[r + 1]) {
                            r--;
                        }
                    }
                }
            }
        }
        return res;
    }
}

// Time complexity: O(n3)
// Space complexity: O(1) or O(n) space used by sorting algo

// n = length of the given array.
// m = number of unique quadruplets