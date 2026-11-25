class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {

            // Handle collisions
            while (asteroid < 0 && !stack.isEmpty() && stack.peek() > 0) {

                if (stack.peek() < Math.abs(asteroid)) {
                    stack.pop(); // Previous asteroid explodes

                } else if (stack.peek() == Math.abs(asteroid)) {
                    stack.pop(); // Both explode
                    asteroid = 0;
                    break;

                } else {
                    asteroid = 0; // Current asteroid explodes
                    break;
                }
            }

            // Push only if the current asteroid survives
            if (asteroid != 0) {
                stack.push(asteroid);
            }
        }

        int[] result = new int[stack.size()];

        for (int i = 0; i < stack.size(); i++) {
            result[i] = stack.get(i);
        }

        return result;
    }
}


// Stack
// Complexity	Value	Explanation
// Time	    O(n)	Each asteroid is pushed and popped at most once
// Space	    O(n)	Stack can hold up to n asteroids