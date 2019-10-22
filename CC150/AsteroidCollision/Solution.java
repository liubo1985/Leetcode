public class Solution {
    /**
     * @param asteroids: a list of integers
     * @return: return a list of integers
     */
    public int[] asteroidCollision(int[] asteroids) {
        // write your code here
        if (asteroids == null || asteroids.length == 0){
            return new int[]{};
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++){
            int cur = asteroids[i];
            // if asteroid is going to right, add to stack
            if (cur > 0){
                stack.push(cur);
            } else {
                if (stack.isEmpty() || stack.peek() < 0){
                    stack.push(cur);
                } else {
                    // if top asteroid is going to right and current asteroid is going to left
                    // compare abs value and remove the right-going asteroid until break the condition
                    while (!stack.isEmpty() && stack.peek() > 0 && Math.abs(cur) > Math.abs(stack.peek())){
                        stack.pop();
                    }
                    if (stack.isEmpty()){
                        stack.push(cur);
                    } else {
                        // if they have equal size but different direction, both died.
                        if (stack.peek() > 0 && Math.abs(cur) == Math.abs(stack.peek())){
                            stack.pop();
                            continue;
                        }
                        if (stack.peek() < 0){
                            stack.push(cur);
                        }
                    }
                }
            }
        }
        int size = stack.size();
        int[] res = new int[size];
        int i = 0;
        while (!stack.isEmpty()){
            res[size - i - 1] = stack.pop();
            i++;
        }
        return res;
    }
}