class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int speed = 1; 
        while (true) {
            long totalTime = 0; //total exceed an int
            for (int pile : piles){
                totalTime += (int) Math.ceil((double) pile/speed);
            }
            if (totalTime <= h) {
                return speed;
            }
            speed++;
        }
    }
}

//The brute-force solution tries every possible speed from 1 upward and checks whether Koko can finish within h hours.
//This works but can be too slow because the maximum pile size may be very large. 
//The key observation is that if a speed works, then any larger speed also works, 
//so the answer space is monotonic. Therefore, we can apply binary search on the speed range from 1 to max(piles)
