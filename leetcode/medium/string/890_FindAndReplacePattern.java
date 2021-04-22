/**
 * https://leetcode.com/problems/find-and-replace-pattern/submissions/
 */

class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<Integer> p = this.mapping(pattern);
        List<String> result = new ArrayList<String>();
        for (String w : words) {
            if (this.matches(p, this.mapping(w))) {
                result.add(w);
            }
        }
        return result;
    }

    private List<Integer> mapping(String word) {
        List<Integer> result = new ArrayList<>();
        
        int N = 0;
        Map<Character, Integer> map = new HashMap<>(); 
        for (var c : word.toCharArray()) {
            Integer x = map.get(c);
            if (x == null) {
                x = N;
                N++;
            } 
            map.put(c, x);
            result.add(x);
        }
        return result;
    }
    
    private boolean matches(List<Integer> a, List<Integer> b) {
        if (a.size() != b.size()) return false;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) != b.get(i)) return false;
        }
        return true;
    }
}
