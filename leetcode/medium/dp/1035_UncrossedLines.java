/** 
 * https://leetcode.com/problems/uncrossed-lines/
 */

class Solution {
    
    public int maxUncrossedLines(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;
        
        int[][] memo = new int[n + 1][m + 1];
        
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (A[i - 1] == B[j - 1]) {
                    memo[i][j] = memo[i-1][j-1] + 1;
                } else {
                    memo[i][j] = Math.max(memo[i-1][j], memo[i][j-1]);
                }
            }
        }
        
        return memo[n][m];
    }
    
}
