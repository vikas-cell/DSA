class Trie {
     class Node{
        boolean isEnd;
        Node [] child = new Node[26];
        Node(){
            isEnd = false;
            Arrays.fill(child,null);
        }
     }
    Node root;
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node temp = root;
        for(int i=0;i<word.length();i++){
            int idx = word.charAt(i)-'a';
            if(temp.child[idx]==null){
                temp.child[idx] = new Node();
                temp = temp.child[idx];
            }
            else temp = temp.child[idx];
        }
        temp.isEnd = true;
    }
    
    public boolean search(String word) {
        Node temp = root;
        for(int i=0;i<word.length();i++){
            int idx = word.charAt(i)-'a';
            if(temp.child[idx]==null) return false;
            temp = temp.child[idx];
        }
        return temp.isEnd;
    }
    
    public boolean startsWith(String word) {
        Node temp = root;
        for(int i=0;i<word.length();i++){
            int idx = word.charAt(i)-'a';
            if(temp.child[idx]==null) return false;
            temp = temp.child[idx];
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