class WordDictionary {

    TrieNode root;

    public class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        public TrieNode() {
            isEnd = false;
            children = new TrieNode[26];
        }
    }
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode current = root;
        for(char c: word.toCharArray()) {
            int charIndex = c - 'a';
            if(current.children[charIndex] == null) {
                current.children[charIndex] = new TrieNode();
            }
            current = current.children[charIndex];
        }
        current.isEnd = true;
    }

    public boolean search(String word) {
        return search(word, 0, root);
    }
    public boolean search(String word, int index, TrieNode node) {
        TrieNode current = node;
        for(int i = index; i < word.length(); i++) {
            char c = word.charAt(i);
            if(c == '.') {
                for(TrieNode child : current.children) {
                    if(child != null && search(word, i + 1, child)) {
                        return true;
                    }
                }
                return false;
            } else {
            int charIndex = c - 'a';
                if(current.children[charIndex] == null) {
                    return false;
                }
                current = current.children[charIndex];
            }
        }
        return current.isEnd;
    }
}
