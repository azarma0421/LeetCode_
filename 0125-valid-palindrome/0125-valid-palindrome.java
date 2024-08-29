class Solution {
    public boolean isPalindrome(String s) {
        char[] charArray = s.toCharArray();
        int len = charArray.length;
        int head = 0;
        int last = len - 1;

        while (head <= last) {
            char h = charArray[head];
            char l = charArray[last];
            if (!Character.isLetterOrDigit(h)) {
                head++;
            } else if (!Character.isLetterOrDigit(l)) {
                last--;
            } else {
                if (Character.toLowerCase(h) != Character.toLowerCase(l)) {
                    return false;
                }
                head++;
                last--;
            }
        }

        return true;
    }
}