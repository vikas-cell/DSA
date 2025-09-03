/*
class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
*/
class Solution {
    public Node reverse(Node head) {
        // code here
        
        if(head==null) return null;
        
        Node temp = null; Node curr = head; Node agla = head;
        
        while(agla!=null){
          agla = agla.next;
          curr.next = temp;
          curr.prev = agla;
          temp = curr;
          curr = agla;
        }
        return temp;
    }
}