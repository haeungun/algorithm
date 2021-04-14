/**
 * https://leetcode.com/problems/remove-covered-intervals/submissions/
 */
 
 class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        
        int result = 0;
        
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < intervals.length; i++) {
            int n = intervals[i][1];
            if (n > max) {
                result++;
                max = n;
            }
        }
        
        return result;
    }
    
}
