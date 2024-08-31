class Solution {
    public String longestPalindrome(String s) {

        if (s.length() == 1)
            return s;
        String maxStr = "";
        int maxlen = 0;

        for (int i = 0; i < s.length(); i++) {

            // odd length
            String odd_s = expandFromCenter(s, i, i);
            if (maxlen < odd_s.length()) {
                maxlen = odd_s.length();
                maxStr = odd_s;
            }
            // even length
            String even_s = expandFromCenter(s, i, i + 1);
            if (maxlen < even_s.length()) {
                maxlen = even_s.length();
                maxStr = even_s;
            }
        }
        return maxStr;
    }

    private String expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
}