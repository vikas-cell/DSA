/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
*/

class Solution {
    ArrayList<Integer> al;
    Node mergeKLists(Node[] arr) {
        al = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            helper(arr[i]);
        }
        Collections.sort(al);
        Node head = new Node(al.get(0));
        Node temp = head;
        for(int i=1;i<al.size();i++){
            Node a = new Node(al.get(i));
            temp.next = a;
            temp = a;
        }
        return head;
    }
    public void helper(Node head){
        Node temp = head;
        while(temp!=null){
            al.add(temp.data);
            temp = temp.next;
        }
    }    
}