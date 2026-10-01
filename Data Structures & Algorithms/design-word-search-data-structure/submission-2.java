class TrieNode{
    Map<Character, TrieNode> children;
    boolean isCompleteWord; 

    public TrieNode(){
        this.children = new HashMap<>(); 
        this.isCompleteWord = false; 
    }
}

class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root; 
        for(int i = 0; i < word.length(); i++){
           curr = curr.children.computeIfAbsent(word.charAt(i), k -> new TrieNode());
        }
        curr.isCompleteWord = true;
    }

    public boolean searchSubString(TrieNode root, String word){
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            if(word.charAt(i) == '.'){
                for(var children : curr.children.entrySet()){
                    if(searchSubString(children.getValue(), word.substring(i+1))){
                        return true;
                    }
                }
                return false;
            }
            if(!curr.children.containsKey(word.charAt(i))){
                return false;
            }
            curr = curr.children.get(word.charAt(i));
        }
        return curr.isCompleteWord;
    }
    public boolean search(String word) {
        return searchSubString(root, word);
    }   
}
