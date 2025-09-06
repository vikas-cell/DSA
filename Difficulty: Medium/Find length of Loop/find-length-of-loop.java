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
    public int lengthOfLoop(Node head) {
        // code here
        Node slow = head;
        Node fast = head;
        
        if(head==null) return 0;
        
        boolean flag = false;
        
        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow){
                flag = true;
                break;
            }
        }
        
        if(!flag) return 0;
        
        int count = 1;
        Node temp = slow.next;
        while(temp!=fast){
            temp = temp.next;
            count++;
        }
        return count;
    }
}