/**
 * https://leetcode.com/problems/count-square-submatrices-with-all-ones/
 */

class Solution {
    public int countSquares(int[][] matrix) {
        int result = 0;
        
        int n = matrix.length;
        int m = matrix[0].length;
        
        int[][] memo = new int[n + 1][m + 1];
        
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (matrix[i - 1][j - 1] == 1) {
                    int x = Math.min(Math.min(memo[i - 1][j], memo[i][j - 1]), memo[i - 1][j - 1]);
                    memo[i][j] = x + 1;
                }
                result += memo[i][j];
            }
        }
        
        return result;
    }
}
