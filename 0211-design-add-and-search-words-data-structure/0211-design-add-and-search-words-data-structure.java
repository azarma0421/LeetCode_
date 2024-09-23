
class WordDictionary {
    boolean isEnd;
    WordDictionary[] children;

    WordDictionary() {
        children = new WordDictionary[26];
        isEnd = false;
    }

    public void addWord(String word) {
        WordDictionary current = this;
        for (char c : word.toCharArray()) {
            if (current.children[c - 'a'] == null) {
                current.children[c - 'a'] = new WordDictionary();
            }
            current = current.children[c - 'a'];
        }
        current.isEnd = true;
    }

    public boolean search(String word) {
        WordDictionary current = this;
        for (int i = 0; i <= word.length() - 1; i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (WordDictionary node : current.children) {
                    if (node != null && node.search(word.substring(i + 1)))
                        return true;
                }
                return false;
            }
            if (current.children[c - 'a'] == null)
                return false;

            current = current.children[c - 'a'];
        }
        return current != null && current.isEnd;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */