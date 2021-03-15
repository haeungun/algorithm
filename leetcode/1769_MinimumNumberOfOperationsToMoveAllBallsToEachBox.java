// https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/

class Solution {
    public int[] minOperations(String boxes) {
        int[] answer = new int[boxes.length()];
        
        char[] box = boxes.toCharArray();
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = sumOfDistance(i, box);
        }
        
        return answer;
    }
    
    public int sumOfDistance(int pos, char[] box) {
        int result = 0;
        
        for (int i = 0; i < box.length; i++) {
            if (i == pos || box[i] != '1') continue;
            
            result += Math.abs(i - pos);
        }
        
        return result;
    }
}
