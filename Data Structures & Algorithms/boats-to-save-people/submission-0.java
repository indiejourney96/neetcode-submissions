class Solution {
    public int numRescueBoats(int[] people, int limit) {

        Arrays.sort(people);

        int res = 0;
        int l = 0;
        int r = people.length - 1;

        while (l <= r) {

            // Try to pair the lightest and heaviest person
            if (people[l] + people[r] <= limit) {
                l++;
            }

            // The heaviest person always gets a boat
            r--;
            res++;
        }

        return res;
    }
}

// Sorting + Two Pointers 
// Time Complexity: O(n log n)
// Space Complexity: O(1) or O(n) depending on sorting algo