class Solution {
    class TrieNode{
        boolean isEnd;
        TrieNode [] child = new TrieNode[26];
        TrieNode(){
            isEnd = false;
            for(int i=0;i<26;i++){
                child[i] = null;
            }
        }
    }
        public TrieNode root = new TrieNode();
        
        public void insert(String word){
            TrieNode curr = root;
            for(int i=0;i<word.length();i++){
                char ch = word.charAt(i);
                int idx = ch-'a';
                if(curr.child[idx]==null){
                    curr.child[idx] = new TrieNode();
                }
                curr = curr.child[idx];
            }
            curr.isEnd = true;
        }
        
        public boolean search(String word){
            TrieNode curr = root;
            for(int i=0;i<word.length();i++){
                char ch = word.charAt(i);
                int idx = ch-'a';
                if(curr.child[idx] == null || !curr.child[idx].isEnd){
                   return false;
                }
                   curr = curr.child[idx];
            }
            return true;
     }
    public String longestString(String[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        for(int i=0;i<n;i++){
            insert(arr[i]);
        }
        
        String res = "";
        for(int i=0;i<n;i++){
            if(search(arr[i]) && arr[i].length()>res.length()){
                res = arr[i];
            }
        }
        return res;
    }
}
