/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
} */

class Solution {
    public static int sum = 0;
    public static void transformTree(Node root) {
        getsum(root);
        update(root);
    }
    public static void update(Node root){
        if(root==null) return;
        
        update(root.left);
        sum = sum - root.data;
        root.data = sum;
        update(root.right);
        
    }
    
    public static void getsum(Node root){
        if(root==null) return;
        sum = sum + root.data;
        getsum(root.left);
        getsum(root.right);
    }
}