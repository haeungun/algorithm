/**
 * 출처: https://programmers.co.kr/learn/courses/30/lessons/42586
 */
 
import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> results = new ArrayList<>();
        Queue<Integer> complete = new LinkedList<>();
        
        for (int i = 0; i < progresses.length; i++) {
            int progress = progresses[i];
            int speed = speeds[i];
            int day = 0;
            while (progress < 100) {
                progress += speed;
                day++;
            }
            complete.add(day);
        }
        
        while (complete.size() > 0) {
            int count = 1;
            int d = complete.poll();
            
            while (complete.size() > 0 && complete.peek() <= d) {
                complete.poll();
                count++;
            }
            
            results.add(count);
        }
        
        int[] answer = new int[results.size()];
        for (int i = 0; i < results.size(); i++) {
            answer[i] = results.get(i);
        }
        
        return answer;
    }
}
