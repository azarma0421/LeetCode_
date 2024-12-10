class Solution {
    public int characterReplacement(String s, int k) {
        int beg = 0;
        int maxLen = 0;
        int maxCount = 0;
        int[] arr = new int[26];

        for (int end = 0; end < s.length(); end++) {
            arr[s.charAt(end) - 'A']++;
            maxCount = Math.max(maxCount, arr[s.charAt(end) - 'A']);
            if (end - beg + 1 - maxCount > k) {
                arr[s.charAt(beg) - 'A']--;
                beg++;
            }
            maxLen = Math.max(maxLen, end - beg + 1);
        }
        return maxLen;
    }
}