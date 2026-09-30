class Trie{
    Map<Character, Trie> children;
    boolean isCompleteWord;
    public Trie(){
        this.children = new HashMap<>();
        this.isCompleteWord = false;
    }
}

class PrefixTree {
    
    Trie root;
    public PrefixTree() {
        root = new Trie();
    }

    public void insert(String word) {
        Trie curr = root;
        for (int i = 0; i < word.length(); i++){
            if(!curr.children.containsKey(word.charAt(i))){
                curr.children.put(word.charAt(i), new Trie());
            }
            curr = curr.children.get(word.charAt(i));
        }
        curr.isCompleteWord = true;
    }

    public boolean search(String word) {
        Trie curr = root; 
        for (int i = 0; i < word.length(); i++){
            if(!curr.children.containsKey(word.charAt(i))){
                return false;
            }
            curr = curr.children.get(word.charAt(i));
        }
        return curr.isCompleteWord;
    }

    public boolean startsWith(String prefix) {
        Trie curr = root; 
        for (int i = 0; i < prefix.length(); i++){
            if(!curr.children.containsKey(prefix.charAt(i))){
                return false;
            }
            curr = curr.children.get(prefix.charAt(i));
        }
        return true;
    }
}
