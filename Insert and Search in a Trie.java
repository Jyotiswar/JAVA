class TrieNode {
    boolean isLeaf;
    TrieNode[] children;

    public TrieNode() {
        isLeaf = false;
        children = new TrieNode[26];
    }
}

public class Trie {
    public void insert(TrieNode root, String key) {
        if (key.length() == 0) {
            root.isLeaf = true;
            return;
        }

        int index = key.charAt(0) - 'a';
        if (root.children[index] != null) {
            insert(root.children[index], key.substring(1));
        } else {
            root.children[index] = new TrieNode();
            insert(root.children[index], key.substring(1));
        }
    }

    public boolean search(TrieNode root, String key) {
        if (key.length() == 0 && root.isLeaf) {
            return true;
        }

        int index = key.charAt(0) - 'a';
        if (root.children[index] != null) {
            return search(root.children[index], key.substring(1));
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        TrieNode root = new TrieNode();

        trie.insert(root, "apple");
        System.out.println("Search for 'apple': " + trie.search(root, "apple"));  // Should print true
        System.out.println("Search for 'app': " + trie.search(root, "app"));      // Should print false
    }
}
