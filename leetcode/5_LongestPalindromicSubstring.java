/**
 * 출처: https://leetcode.com/problems/longest-palindromic-substring/
 */

class Solution {
	
	public static String longestPalindrome(String s) {
        if (s.length() <= 1) return s;
	 
	    int N = s.length();
	    int max = 0;
	    boolean [][] dp = new boolean[N][N];
	 
	    String ret = null;
	    
	    for (int i = 0; i < N; i++) {
	        for (int j = 0; j < N - i; j++) {
	            int m = j + i;
	            if (s.charAt(j) == s.charAt(m) && (m - j <= 2 || dp[j + 1][m - 1])) {
	                dp[j][m] = true;
	 
	                if (m - j + 1 > max) {
	                   max = m - j + 1; 
	                   ret = s.substring(j, m + 1);	                 
	                }
	            }
	        }
	    }
	 
	    return ret;
	}
}
