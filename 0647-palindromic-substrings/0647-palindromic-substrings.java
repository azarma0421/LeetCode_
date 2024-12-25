class Solution {
    public int countSubstrings(String s) {
        int window_len = 1;
        int ans = 0;
        while (window_len <= s.length()) {
            for (int i = 0; i + window_len <= s.length(); i++) {
                if (isPalindromic(s, i, i + window_len - 1))
                    ans++;
            }
            window_len++;
        }
        return ans;
    }

    private boolean isPalindromic(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }
}