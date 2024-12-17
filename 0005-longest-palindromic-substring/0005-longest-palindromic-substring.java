class Solution {
    public String longestPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        int left = 0;
        int right = 0;

        while (start <= end) {
            for (int i = 0; end + i < s.length(); i++) {
                if (isPalindromic(s, start + i, end + i))
                    return s.substring(start + i, end + i + 1);
            }
            end--;
        }
        return "";
    }

    private boolean isPalindromic(String s, int left, int right) {
        while (left <= right) {
            if (s.charAt(left++) != s.charAt(right--))
                return false;
        }
        return true;
    }
}