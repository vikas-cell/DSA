



/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/

class Solution {
    public static Node reverseKGroup(Node head, int k) {
        Node temp = head;
        int count = 0;
        while(temp!=null){
            temp = temp.next;
            count++;
        }
        int n = count;
        int [] arr = new int[n];
        temp = head;
        // for(int i=0;i<n;i++){
        //     arr[i]=temp.data;
        //     temp = temp.next;
        // }
        int l = 0;
        while(temp!=null){
            arr[l++] = temp.data;
            temp = temp.next;
        }
        helper(arr,k);
        Node a = new Node(arr[0]);
        Node t = a;
        for(int i=1;i<n;i++){
            Node tt = new Node(arr[i]);
            t.next = tt;
            t = tt;
        }
        return a;
    }
    public static void helper(int [] arr,int k){
        int n = arr.length;
        n = n - n%k;
        for(int i=0;i<n;i++){
            if((i+1)%k==0){
               int st = i-k+1;int ed = i;
               while(st<ed){
                   int temp  = arr[st];
                   arr[st] = arr[ed];
                   arr[ed] = temp;
                   st++;ed--;
               }
            }
        }
        int st = n;int ed = arr.length-1;
        while(st<ed){
            int temp  = arr[st];
            arr[st] = arr[ed];
            arr[ed] = temp;
            st++;ed--;
        }
    }
}
