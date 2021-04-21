/**
 * https://leetcode.com/problems/matrix-block-sum/
 */

class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int n = mat.length;
        int m = mat[0].length;
        
        int[][] sums = new int[n + 1][m + 1];
      
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sums[i + 1][j + 1] = 
                    sums[i][j + 1] + sums[i + 1][j] - sums[i][j] + mat[i][j];
            }
        }
        
        int[][] result = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int x1 = Math.max(0, i - k);
                int y1 = Math.max(0, j - k);
                
                int x2 = Math.min(n, i + k + 1);
                int y2 = Math.min(m, j + k + 1);
                
                result[i][j] = sums[x2][y2] - sums[x1][y2] - sums[x2][y1] + sums[x1][y1];
            }
        }
        
        return result;
    }
}
