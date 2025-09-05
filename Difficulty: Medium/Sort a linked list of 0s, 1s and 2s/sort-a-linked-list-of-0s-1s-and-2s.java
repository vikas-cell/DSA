/*
class Node {
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}*/

class Solution {
    public Node segregate(Node head) {
        // code here
        Node temp = head;
        int n = 0;
        int zero = 0; int one = 0; int two = 0;
        
        while(temp!=null){
            if(temp.data==0) zero++;
            if(temp.data==1) one++;
            if(temp.data==2) two++;
            n++;
            temp = temp.next;
        }
        
        temp = head;
        for(int i=0;i<n;i++){
            if(i<zero) temp.data = 0;
            else if(i>=zero && i<one+zero) temp.data = 1;
            else temp.data = 2;
            temp = temp.next;
        }
        return head;
        
    }
}