// https://leetcode.com/problems/largest-rectangle-in-histogram/description/
// 84. Largest Rectangle in Histogram
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        if(n == 0) return 0;
        if(n==1) return heights[0];
        int maxarea = 0;
        // Optimal approach is to 
        //Find Prev Smaller elem  , Next Smaller elem
        // At every Bar Area  = heights[i] * (next smaller - prev smaller -1);
        // Keep Comparing it with max
        int[] prevSmaller = findPrevSmallerArray(heights);
        int[] nextSmaller = findNextSmallerArray(heights);
        for(int i=0;i<n;i++){
            int currArea = (heights[i])*(nextSmaller[i] - prevSmaller[i] - 1);
            maxarea = Math.max(maxarea,currArea);

        }
        return maxarea;
        
    }

    public int[] findPrevSmallerArray(int[] heights){
        int[]prevsmaller = new int[heights.length];
        Stack<Integer> st = new Stack<>();
        int n = heights.length;

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]) st.pop();
            prevsmaller[i] = st.isEmpty()?-1:st.peek();
            st.push(i);

        }
        return prevsmaller;
    }

    public int[] findNextSmallerArray(int[]heights){
        int[]nextsmaller = new int[heights.length];
        Stack<Integer> st = new Stack<>();
        int n = heights.length;

        for(int i=n-1;i>=0;i--){

            while(!st.isEmpty() && heights[st.peek()] >= heights[i]) st.pop();

            nextsmaller[i] = st.isEmpty()?n:st.peek();
            st.push(i);
        }
        return nextsmaller;
    }
}

/* 
                                // Brute force approach:


class Solution {
  
   // For every bar, expand to left and right
   // until a smaller height bar is found.
   // Calculate the maximum rectangle area
   // using the current bar as the limiting height.
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        if(n == 1) return heights[0];
        int maxarea = heights[0];
        
        for(int i =0 ; i < n;i++){
            int left =i;
            int right=i;
            int bars_in_curr_range=1;
            while(left>0 && heights[left-1] >= heights[i]){
                left--;
                bars_in_curr_range++;
            }
            while(right < n-1 && heights[right+1] >= heights[i]){
                right++;
                bars_in_curr_range++;
            }
            int currmax = bars_in_curr_range * heights[i];
            maxarea = Math.max(maxarea , currmax);
        }

        return maxarea;


        
    }
}*/