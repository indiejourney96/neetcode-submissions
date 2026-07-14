class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // Left half is sorted
            if (nums[l] <= nums[mid]) {
                // Target is inside the left half
                if (target >= nums[l] && target < nums[mid]) {
                    r = mid - 1;
                }
                // Target is in the right half
                else {
                    l = mid + 1;
                }
            }

            // Right half is sorted
            else {
                // Target is inside the right half
                if (target > nums[mid] && target <= nums[r]) {
                    l = mid + 1;
                }
                // Target is in the left half
                else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}


// Step 1:
// Which half is sorted?
//       /        \
//  Left          Right


// Step 2:
// Is target inside that sorted half?
//       /        \
//    Yes          No
//  Search it    Search the other half