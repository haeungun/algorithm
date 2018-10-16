import java.util.*;
import java.util.Map.Entry;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            String[] cloth = clothes[i];
            String k = cloth[1];

            int count = map.getOrDefault(k, 0);
            map.put(k, ++count);
        }

        if (map.size() > 1) {
            int comb = 1;
            for (Entry<String, Integer> entry : map.entrySet()) {
                comb *= (entry.getValue() + 1);
            }
            answer += comb - 1;
        } else {
            answer = map.get(clothes[0][1]);
        }

        return answer;
    }
}
