/**
 * 출처: https://leetcode.com/problems/group-anagrams/
 */

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            
            List<String> l = map.getOrDefault(sorted, new ArrayList<>());
            l.add(str);
            
            map.put(sorted, l);
        }
        
        return map.values().stream().collect(Collectors.toList());
    }
}
