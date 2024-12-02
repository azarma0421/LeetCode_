class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int left = 0;
        Set<String> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            String str = s.substring(i, i + 1);
            if (!set.contains(str)) {
                set.add(str);
                max = Math.max(max, i - left + 1);
            } else {
                while (set.contains(str)) {
                    set.remove(s.substring(left, left + 1));
                    left++;
                }
                set.add(str);
                max = Math.max(max, i - left + 1);
            }
        }
        return max;
    }
}