package others.datastructures;

public class Trie {

    public static void main(String[] args) {
     // Input keys (use only 'a' through 'z' and lower case)
        String keys[] = {"the", "a", "there", "answer", "any",
                         "by", "bye", "their"};
      
        String output[] = {"Not present in trie", "Present in trie"};
      
      
        Trie trie = new Trie();
      
        // Construct trie
        int i;
        for (i = 0; i < keys.length ; i++)
            trie.insert(keys[i]);
      
        // Search for different keys
        if(trie.search("the") == true)
            System.out.println("the --- " + output[1]);
        else System.out.println("the --- " + output[0]);
         
        if(trie.search("these") == true)
            System.out.println("these --- " + output[1]);
        else System.out.println("these --- " + output[0]);
         
        if(trie.search("their") == true)
            System.out.println("their --- " + output[1]);
        else System.out.println("their --- " + output[0]);
         
        if(trie.search("thaw") == true)
            System.out.println("thaw --- " + output[1]);
        else System.out.println("thaw --- " + output[0]);
    }

    private static final int ALPHABET_SIZE = 26; //a-z
    private static class TrieNode{
        TrieNode []children = new TrieNode[ALPHABET_SIZE];
        /**
         * Indicates the end of the word
         */
        boolean isEndOfWord = false;
    }
    
    private TrieNode rootNode = null;
    
    public Trie() {
        rootNode = new TrieNode();
    }
    
    public void insert(String str) {
        if(str == null || str.length() == 0)
            return;
        TrieNode node = rootNode;
        for(int level = 0; level < str.length(); level++) {
            int index = str.charAt(level) - 'a'; //The index of child
            if(node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }
    public boolean search(String key) {
        TrieNode node = rootNode;
        for(int level = 0; level < key.length(); level++) {
            int index = key.charAt(level) - 'a'; //The index of child
            node = node.children[index];
            if(node == null)
                break;
        }
        return node != null && node.isEndOfWord;
    }
}
