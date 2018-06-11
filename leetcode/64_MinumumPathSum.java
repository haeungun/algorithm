/**
 * 출처: https://leetcode.com/problems/minimum-path-sum/description/
 */

class Solution {
    public int minPathSum(int[][] grid) {
        int N = grid.length;
        
        if (N < 1) return 0;
        
        int M = grid[0].length;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i - 1 >= 0 && j - 1 >= 0) {
                    grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
                } else if (i - 1 >= 0) {
                    grid[i][j] = grid[i][j] + grid[i - 1][j];
                } else if (j - 1 >= 0) {
                    grid[i][j] = grid[i][j] + grid[i][j - 1];
                } else {
                    grid[i][j] = grid[i][j];
                }
            }
        }
        
        return grid[N - 1][M - 1];
        
    }
}
