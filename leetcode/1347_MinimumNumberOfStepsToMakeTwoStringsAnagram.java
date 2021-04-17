/**
 * https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/
 */

class Solution {
    public int minSteps(String s, String t) {
        int[] alphabet = new int[26];
        
        for (char c : s.toCharArray()) {
            alphabet[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            if (alphabet[c - 'a'] != 0)
                alphabet[c - 'a']--;
        }

        int result = 0;
        for (int a : alphabet) {
            result += a;
        }
        
        return result;
    }
}
