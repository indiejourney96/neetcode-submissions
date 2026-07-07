class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        // No cars
        if (position.length == 0) {
            return 0;
        }

        int n = position.length;
        // Pair each position with its speed
        int[][] pair = new int[n][2];

        for (int i = 0; i < n; i++) {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }
        // Sort cars from closest to target -> farthest
        Arrays.sort(pair, (a, b) -> Integer.compare(b[0], a[0]));

        // The closest car always starts as one fleet
        int fleets = 1;

        // Time needed for the fleet in front
        double prevTime =
            (double)(target - pair[0][0]) / pair[0][1];

        // Process remaining cars
        for (int i = 1; i < n; i++) {

            // Time needed for current car
            double currTime =
                (double)(target - pair[i][0]) / pair[i][1];

            /*
             If current car takes longer,
             it cannot catch the fleet ahead,
             so it forms a new fleet.
            */
            if (currTime > prevTime) {
                fleets++;
                prevTime = currTime;
            }

            // Otherwise it catches the fleet ahead.
        }

        return fleets;
    }
}