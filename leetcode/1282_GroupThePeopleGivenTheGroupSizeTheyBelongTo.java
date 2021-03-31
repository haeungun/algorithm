/**
 * https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/
 */

class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> results = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < groupSizes.length; i++) {
            int groupSize = groupSizes[i];
            List<Integer> group = map.getOrDefault(groupSize, new ArrayList<>());
            
            group.add(i);
            
            if (group.size() == groupSize) {
                results.add(group);
                map.put(groupSize, new ArrayList<>());
            } else {
                map.put(groupSize, group);
            }
        }
        
        return results;
        
    }
}
