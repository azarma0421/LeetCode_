class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int left = 0;
        int len = s.length();
        Set<Character> set = new HashSet<>();

        for (int right = 0; right < len; right++) {
            Character index = s.charAt(right);
            if (!set.contains(index)) {
                set.add(index);
                max = Math.max(max,right - left + 1);
            }else{
                while(set.contains(index)){
                    set.remove(s.charAt(left));
                    left++;
                }
                set.add(index);
            }
        }

        return max;
    }
}