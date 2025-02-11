class Solution {
    int max_length = 0;
    String ans;

    public String longestPalindrome(String s) {
        if (s.length() == 1)
            return s;
        for (int i = 0; i < s.length() - 1; i++) {
            palindromic(s, i, i);
            palindromic(s, i, i + 1);
        }

        return ans;
    }

    private void palindromic(String s, int left, int right) {
        if (left < 0 || right >= s.length())
            return;
        if (s.charAt(left) == s.charAt(right)) {
            if (right - left + 1 > max_length) {
                max_length = right - left + 1;
                ans = s.substring(left, right + 1);
            }
            palindromic(s, --left, ++right);
        }
    }

}