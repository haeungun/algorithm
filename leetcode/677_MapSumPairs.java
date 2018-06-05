/*
 * https://leetcode.com/problems/map-sum-pairs/description/
 */
 
 class MapSum {

    private Map<String, Integer> map;
    
    /** Initialize your data structure here. */
    public MapSum() {
        this.map = new HashMap<>();
    }
    
    public void insert(String key, int val) {
        this.map.put(key, val);
    }
    
    public int sum(String prefix) {
        int sum = 0;
        for (String str : map.keySet()) {
            if (str.startsWith(prefix)) {
                sum += map.get(str);
            }
        }
        
        return sum;
    }
}
