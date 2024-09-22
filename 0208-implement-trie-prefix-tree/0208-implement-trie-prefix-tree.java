class TreeNode {
    boolean isEnd;
    TreeNode[] children;

    TreeNode() {
        children = new TreeNode[26];
    }
}

class Trie {

    TreeNode root = null;

    public Trie() {
        root = new TreeNode();
    }

    public void insert(String word) {
        TreeNode current = root;
        for (int i = 0; i < word.length(); i++) {
            int id = word.charAt(i) - 'a';
            if (current.children[id] == null) {
                current.children[id] = new TreeNode();
                current.children[id].isEnd = false;
            }
            current = current.children[id];
        }
        current.isEnd = true;
    }

    public boolean search(String word) {
        TreeNode current = root;
        for (int i = 0; i < word.length(); i++) {
            int id = word.charAt(i) - 'a';
            if (current.children[id] == null) {
                return false;
            }
            current = current.children[id];
        }
        if (current.isEnd) {
            return true;
        }
        return false;
    }

    public boolean startsWith(String prefix) {
        TreeNode current = root;
        for (int i = 0; i < prefix.length(); i++) {
            int id = prefix.charAt(i) - 'a';
            if (current.children[id] == null) {
                return false;
            }
            current = current.children[id];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */