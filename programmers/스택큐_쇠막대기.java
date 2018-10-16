/**
 * 출처: https://programmers.co.kr/learn/courses/30/lessons/42585?language=java#
 */

import java.util.*;

class Solution {
    public int solution(String arrangement) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();

        char prev = 0;
        for (int i = 0; i < arrangement.length(); i++) {
            char c = arrangement.charAt(i);

            if (c == '(') {
                stack.push(c);
            } else {
                stack.pop();
                if (prev == '(') answer += stack.size();
                else answer++;
            }

            prev = c;
        }

        return answer;
    }
}
