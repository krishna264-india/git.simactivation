
/*
 * Given an array of integers heights representing the histogram's
 *  bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.
 *  Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.
 */
import java.util.Stack;

public class StackHeights {
    public static void main(String[] args){
        int[] heights={2,1,5,6,2,3};
        System.out.println(largestRectangleArea(heights));
    }
    public static int largestRectangleArea(int[] heights){
        int maxArea=0;
        Stack<Integer> stack=new Stack<>();
        stack.push(0);
        for(int i=1;i<heights.length;i++){
            while(!stack.isEmpty() && heights[i]<heights[stack.peek()]){
                maxArea=getMax(heights,stack,maxArea,i);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            maxArea=getMax(heights,stack,maxArea,heights.length);
        }
          return maxArea;
            }
            private static int  getMax(int[] heights,Stack<Integer> stack,int maxArea,int i){
                int area;
                int top=stack.pop();
                if(stack.isEmpty()){
                    area=heights[top]*i;
                } else{
                    area=heights[top]*(i-1-stack.peek());
                } 
                return Math.max(maxArea,area);
            }
            public String simplifyPath(String path) {
                Stack<String> res=new Stack<>();
                String[] paths=path.split("/");
                for(String p:paths){
                    if(p.equals("..") && !res.isEmpty()){
                        res.pop();
                    }
                    else if(!p.equals("") && !p.equals(".") && !p.equals("..")){
                        res.push(p);
                    }
                }
                if(res.isEmpty()) return "/";
                StringBuilder sb=new StringBuilder();
                while(!res.isEmpty()){
                    sb.insert(0,res.pop()).insert(0, "/");
                }
                return sb.toString();
            }

        }

