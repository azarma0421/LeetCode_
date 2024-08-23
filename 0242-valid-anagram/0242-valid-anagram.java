class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int word = 0;
        int[] map = new int[128];
        for (char c : s.toCharArray()) {
            if (map[c]++ == 0)
                word++;
        }

        for (char c : t.toCharArray()) {
            if (map[c]-- == 1)
                word--;
        }

        return word == 0;
    }
}