class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int word = 0;
        int left = 0;
        int right = 0;
        List<Integer> ans = new ArrayList<>();

        if (p.length() > s.length()) {
            return ans;
        }

        int[] map = new int[128];
        for (char c : p.toCharArray()) {
            if (map[c]-- == 0)
                word++;
        }
        for (int i = 0; i < p.length(); i++) {
            if (map[s.charAt(i)]++ == -1)
                word--;
        }
        right = p.length() - 1;

        if (word == 0)
            ans.add(left);

        while (right + 1 < s.length()) {
            if (map[s.charAt(left++)]-- == 0)
                word++;
            if (map[s.charAt(++right)]++ == -1)
                word--;

            if (word == 0)
                ans.add(left);
        }
        return ans;
    }
}