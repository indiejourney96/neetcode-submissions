class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // Always binary search the smaller array.
        // This guarantees O(log(min(m, n))).
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int[] small = nums1;
        int[] large = nums2;

        int total = small.length + large.length;

        // Number of elements that should be on the LEFT side
        // Example:
        // total = 7 -> half = 4
        // total = 8 -> half = 4
        int half = (total + 1) / 2;

        int left = 0;
        int right = small.length;

        while (left <= right) {

            // Partition position in the smaller array
            int partitionSmall = (left + right) / 2;

            // Remaining elements must come from the larger array
            int partitionLarge = half - partitionSmall;

            // Values immediately beside the partitions
            //
            // small:
            // 1 3 | 8 9
            //     ^
            //
            // leftSmall = 3
            // rightSmall = 8
            int leftSmall =
                (partitionSmall == 0)
                ? Integer.MIN_VALUE
                : small[partitionSmall - 1];

            int rightSmall =
                (partitionSmall == small.length)
                ? Integer.MAX_VALUE
                : small[partitionSmall];

            // Same idea for the larger array
            int leftLarge =
                (partitionLarge == 0)
                ? Integer.MIN_VALUE
                : large[partitionLarge - 1];

            int rightLarge =
                (partitionLarge == large.length)
                ? Integer.MAX_VALUE
                : large[partitionLarge];

            // Correct partition found when
            // largest value on LEFT <= smallest value on RIGHT
            if (leftSmall <= rightLarge &&
                leftLarge <= rightSmall) {

                // Odd number of elements
                if (total % 2 == 1) {
                    return Math.max(leftSmall, leftLarge);
                }

                // Even number of elements
                return (
                    Math.max(leftSmall, leftLarge)
                    + Math.min(rightSmall, rightLarge)
                ) / 2.0;
            }

            // Left side of small array is too large.
            // Move partition LEFT.
            if (leftSmall > rightLarge) {
                right = partitionSmall - 1;
            }

            // Left side of large array is too large.
            // Move partition RIGHT.
            else {
                left = partitionSmall + 1;
            }
        }
        return -1;
    }
}


// Binary search smaller array
//             ↓
// Choose partition
//             ↓
// Get 4 boundary numbers
//             ↓
// Is left <= right ?
//             ↓
// YES → Median
// Odd:
// max(lefts)

// Even:
// (max(left)+min(right))/2

//  NO → Move partition