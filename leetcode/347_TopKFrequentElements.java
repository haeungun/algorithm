/**
 * 출처: https://leetcode.com/problems/top-k-frequent-elements/description/
 */

class Solution {
    class Counter implements Comparable<Counter> {
        int id;
        int count;
        
        public Counter(int id, int count) {
            this.id = id;
            this.count = count;
        }
        
        public int compareTo(Counter c) {
            return c.count - this.count;
        }
    }
    
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int num : nums) {
            int n = map.getOrDefault(num, 0);
            map.put(num, ++n);
        }
        
        List<Counter> counters = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            counters.add(new Counter(e.getKey(), e.getValue()));
        }
        
        Collections.sort(counters);
        for (int i = 0; i < k; i++) 
            result.add(counters.get(i).id);
        
        return result;
    }
}
