class Solution {
    public String longestPalindrome(String s) {
        int start = 0;
        int end = s.length();
        int len = 1;

        while (start < end) {
            for (int i = 0; end + i <= s.length(); i++) {
                if (isPalindromic(start + i, end + i - 1, s))
                    return s.substring(start + i, end + i);
            }
            end--;
        }
        return s.substring(0, 1);
    }

    private boolean isPalindromic(int left, int right, String s) {
        while (left <= right) {
            if (s.charAt(left++) != s.charAt(right--))
                return false;
        }
        return true;
    }
}