public class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean endOfWord = false;
}

class PrefixTree {

    TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = root;
        for(char c : word.toCharArray()) {
            int index = c - 'a';
            if(cur.children[index] == null) {
                cur.children[index] = new TrieNode();
            }
            cur = cur.children[index];
        }
        cur.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode cur = root;
        for(char c: word.toCharArray()) {
            int index = c - 'a';
            if(cur.children[index] == null) {
                return false;
            }
            cur = cur.children[index];
        }
        return cur.endOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(Character c: prefix.toCharArray()) {
            int index = c - 'a';
            if(cur.children[index] == null) {
                return false;
            }
            cur = cur.children[index];
        }
        return true;
    }
}
