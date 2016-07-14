package CC150.LargestRectangleinHistogram;

import java.util.Stack;

/**
 * Created by bliu on 6/14/2016.
 */

public class Solution {
    public int argestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0){
            return 0;
        }

        Stack<Integer> stack = new Stack<Integer>();
        int result = 0;
        stack.push(0);
        for(int i = 1; i <= heights.length; i++){
            int curr = i == heights.length ? -1 : heights[i];
            while(!stack.isEmpty() && curr < heights[stack.peek()]){
                int h = heights[stack.pop()];
                int w;
                if(!stack.isEmpty()){
                    w = i - stack.peek() - 1;
                }
                else{
                    w = i;
                }

                result = Math.max(w*h, result);
            }
            stack.push(i);
        }
        return result;
    }
}
