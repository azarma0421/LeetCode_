class Solution {
    public int characterReplacement(String s, int k) {

        int[] arr = new int[26];
        int maxCount = 0;
        int beg = 0;
        int maxlen = 0;

        for (int end = 0; end < s.length(); end++) {
            arr[s.charAt(end) - 'A']++;
            maxCount = Math.max(maxCount, arr[s.charAt(end) - 'A']);
            if (end - beg + 1 - maxCount > k) {
                arr[s.charAt(beg) - 'A']--;
                beg++;
            }
            maxlen = Math.max(maxlen, end - beg + 1);
        }
        return maxlen;
    }
}