class Solution {
    public String minWindow(String s, String t) {
        int[] map = new int[128];
        int count = t.length();
        int minlen = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int startIndex = 0;

        char[] chS = s.toCharArray();

        for (char c : t.toCharArray()) {
            map[c]++;
        }

        while (end < s.length()) {
            if (map[chS[end++]]-- > 0)
                count--;
            while (count == 0) {
                if (minlen > end - start) {
                    startIndex = start;
                    minlen = end - start;
                }
                if (map[chS[start++]]++ == 0)
                    count++;
            }
        }
        return minlen == Integer.MAX_VALUE ? new String() : new String(chS, startIndex, minlen);
    }
}