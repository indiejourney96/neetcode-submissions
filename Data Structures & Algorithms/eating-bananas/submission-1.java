class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int left = 1;
        int right = 0;

        for (int pile : piles) {
            right = Math.max(right, pile); //to find the max pile[i]
        }

        int answer = right;

        while (left <= right) {

            int speed = left + (right - left) / 2;
            long totalTime = 0;

            for (int pile : piles) {
                totalTime += (int)Math.ceil((double)pile / speed);
            }

            if (totalTime <= h) {
                answer = speed;
                right = speed - 1; // try smaller speed
            } else {
                left = speed + 1; // need larger speed
            }
        }
        return answer;
    }
}