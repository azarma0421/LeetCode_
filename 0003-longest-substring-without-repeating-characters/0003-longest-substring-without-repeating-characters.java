class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int start = 0;
        int end = 0;

        Set<Character> set = new HashSet<>();
        while (end < s.length()) {
            if (!set.contains(s.charAt(end)))
                set.add(s.charAt(end++));
            else {
                while (set.contains(s.charAt(end))) {
                    set.remove(s.charAt(start++));
                }
            }
            max = Math.max(max, end - start);
        }

        return max;
    }
}