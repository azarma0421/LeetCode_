class Solution {
    public String minWindow(String s, String t) {
        int word = 0;
        int[] map = new int[128];
        String ans = s;
        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i < t.length(); i++) {
            if (map[t.charAt(i)]-- == 0)
                word++;
        }

        int left = 0;
        int right = 0;

        while (left < s.length() && right < s.length()) {

            while (word > 0 && right < s.length()) {
                if (map[s.charAt(right++)]++ == -1)
                    word--;
            }
            while (word == 0) {
                ans = minLength > right - left ? s.substring(left, right) : ans;
                minLength = Math.min(minLength, right - left);
                if (map[s.charAt(left++)]-- == 0)
                    word++;
            }
        }
        return minLength == Integer.MAX_VALUE ? new String() : ans;
    }
}