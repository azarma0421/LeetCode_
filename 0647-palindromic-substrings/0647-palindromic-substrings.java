class Solution {
    public int countSubstrings(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            ans += isPalindrome(s, i, i);
            ans += isPalindrome(s, i, i + 1);
        }
        return ans;
    }

    private int isPalindrome(String s, int i, int j) {
        int same = 0;
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
            same++;
        }
        return same;
    }
}