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
    public Node swapKth(Node head, int k) {
        // code here
        Node temp = head;
        int count = 0;
        while(temp!=null){
            temp = temp.next;
            count++;
        }
        
        if(k>count) return head;
        
        int [] arr = new int[count];
        int i = 0;
        temp = head;
        while(i<count){
            arr[i] = temp.data;
            temp = temp.next;
            i++;
        }
        
        int tmp = arr[k-1];
        arr[k-1] = arr[count-k];
        arr[count-k] = tmp;
        
        
        temp = head;
        i=0;
        while(i<count){
            temp.data = arr[i];
            i++;
            temp = temp.next;
        }
        return head;
    }
}
