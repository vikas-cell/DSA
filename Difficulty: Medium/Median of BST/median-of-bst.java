/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public static ArrayList<Integer> al;
    public int findMedian(Node root) {
        // Code here
        al = new ArrayList<>();
        find(root);
        Collections.sort(al);
        int n = al.size();
        if(n%2!=0) return (al.get((n)/2));
        return al.get(n/2-1);
    }
    public static void find(Node root){
        if(root==null) return;
        
        al.add(root.data);
        find(root.left);
        
        find(root.right);
    }
}