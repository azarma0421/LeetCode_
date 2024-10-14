class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0')
            return 0;
        int[] ans = new int[s.length() + 1];
        ans[0] = 1;
        int preNum = 0;

        for (int i = 1; i <= s.length(); i++) {
            char c = s.charAt(i - 1);

            if ('0' == c) {
                if (preNum == 0)
                    return 0;
            } else {
                ans[i] = ans[i - 1];
            }

            if (('0' <= c && c <= '6' && preNum == 2) || preNum == 1)
                ans[i] += ans[i - 2];

            if ('1' == c)
                preNum = 1;
            else if ('2' == c)
                preNum = 2;
            else
                preNum = 0;
        }
        return ans[s.length()];
    }
}