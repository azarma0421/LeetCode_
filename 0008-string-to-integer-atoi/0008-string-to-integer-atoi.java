class Solution {
    public int myAtoi(String s) {
        int ans = 0;
        int sign = 1;
        s = s.trim();
        if (s.length() == 0)
            return 0;
        if (Character.isLetter(s.toCharArray()[0]))
            return 0;
        if (s.toCharArray()[0] == '+') {
            sign = 1;
            s = s.substring(1);
        } else if (s.toCharArray()[0] == '-') {
            sign = -1;
            s = s.substring(1);
        }
        for (char c : s.toCharArray()) {
            int digit = c - '0';
            if (!Character.isDigit(c))
                return ans * sign;
            if (ans > (Integer.MAX_VALUE - digit) / 10) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            ans = ans * 10 + digit;
        }
        return ans * sign;
    }
}