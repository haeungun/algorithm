/**
 * https://leetcode.com/problems/split-a-string-in-balanced-strings/
 */

class Solution {
    public int balancedStringSplit(String s) {
        int lcount = 0;
        int rcount = 0;
        int bcount = 0;
        
        for (char c : s.toCharArray()) {
            if (c == 'L') {
                lcount++;
            }
            
            if (c == 'R') {
                rcount++;
            }
            
            if (lcount == rcount) {
                bcount++;
            }
        }
        
        return bcount;
        
    }
}
