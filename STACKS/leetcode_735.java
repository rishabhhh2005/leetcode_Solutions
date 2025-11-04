// https://leetcode.com/problems/asteroid-collision/description/
// Asteroid Collision
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack  = new Stack<>();
        for(int i = 0; i < asteroids.length; i++) {
            if(asteroids[i] > 0) {
                stack.push(asteroids[i]);
            } else {
                if(!stack.isEmpty() && stack.peek() < 0) {
                    stack.push(asteroids[i]);
                    continue;
                } 
                while(!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroids[i])) {
                    stack.pop();
                }

         
                if(stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroids[i]);
                    continue;
                }

                if(stack.peek() == Math.abs(asteroids[i])) {
                    stack.pop();
                    continue;
                }
            }
        }

        int[] res = new int[stack.size()];
        for(int i = res.length - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }
}
