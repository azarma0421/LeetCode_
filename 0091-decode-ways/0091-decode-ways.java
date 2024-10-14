class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0')
            return 0;
        int[] ans = new int[s.length() + 1];
        ans[0] = 1;

        for (int i = 1; i <= s.length(); i++) {
            int first = s.charAt(i - 1) - '0';
            int second = i > 1 ? (s.charAt(i - 2) - '0') * 10 + first : 0;
            if (first == 0) {
                if (second == 0)
                    return 0;
            } else
                ans[i] = ans[i - 1];
            if (second >= 10 && second <= 26)
                ans[i] += ans[i - 2];
        }
        return ans[s.length()];
    }
}