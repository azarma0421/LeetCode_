class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0
                || t.length() == 0 || s.length() < t.length()) {
            return new String();
        }
        int[] map = new int[128];
        int len = Integer.MAX_VALUE;
        int start = 0, end = 0, startIndex = 0;
        int count = t.length();

        for (char c : t.toCharArray()) {
            map[c]++;
        }

        char[] chS = s.toCharArray();

        while (end < s.length()) {
            if (map[chS[end++]]-- > 0) {
                count--;
            }
            while (count == 0) {
                if (len > end - start) {
                    len = end - start;
                    startIndex = start;
                }
                if (map[chS[start++]]++ == 0) {
                    count++;
                }
            }
        }

        return len == Integer.MAX_VALUE ? new String() : new String(chS, startIndex, len);
    }
}