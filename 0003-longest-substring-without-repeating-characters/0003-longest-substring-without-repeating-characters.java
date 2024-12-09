class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int left = 0;
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!set.contains(c)) {
                set.add(c);
                max = Math.max(max, i - left + 1);
            } else {
                while (set.contains(c)) {
                    set.remove(s.charAt(left));
                    left++;
                }
                set.add(c);
            }
        }
        return max;
    }
}