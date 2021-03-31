/**
 *  https://leetcode.com/problems/number-of-rectangles-that-can-form-the-largest-square/
 */

class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        int numOfRectangles = rectangles.length;
        
        int result = 0;
        int maxLen = 0;
        
        for (int i = 0; i < numOfRectangles; i++) {
            int[] rectangle = rectangles[i];
            int len = Math.min(rectangle[0], rectangle[1]);
            
            if (len == maxLen) {
                result++;
            }
            
            if (len > maxLen) {
                maxLen = len;
                result = 1;
            }
        }
        
        return result;
    }
}
